package com.shop.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件上传下载工具类
 */
public class FileUtils {

	private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);
	
    // 秘钥
	@Value("${(encrypPassword}")
	private static String encrypPassword;

	// 接口地址
	@Value("${piccsz.fs.address}")
    private static String fileSvrAddr;

    // 环境代码
	@Value("${envCode}")
    private static String envCode;

	// 系统代码
	@Value("${systemCode}")
	private static String systemCode;

	@Autowired
	private static UserUtils userUtils;

	// 文件上传
	public static Map<String, Object> uploadPost(String type, String businessNo, MultipartFile multipartFile,String createdUser) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// 获取文件服务器地址
		String urlPrefix = fileSvrAddr + "/";
		String url = urlPrefix + "uploadFile";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String result = "";
		try {
			HttpPost httpPost = new HttpPost(url);
			MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

			builder.addBinaryBody("file", multipartFile.getInputStream(), ContentType.MULTIPART_FORM_DATA, multipartFile.getName());
			// 类似浏览器表单提交，对应input的name和value
			builder.addTextBody("password", encrypPassword);
			builder.addTextBody("envCode", envCode);
			builder.addTextBody("systemCode", systemCode);
			builder.addTextBody("type", type);
			builder.addTextBody("businessNo", businessNo);
			builder.addTextBody("createdUser", createdUser);
			builder.setCharset(CharsetUtils.get("UTF-8"));
			HttpEntity entity = builder.build();
			httpPost.setEntity(entity);
			// 执行提交
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity responseEntity = response.getEntity();
			if (responseEntity != null) {
				// 将响应内容转换为字符串
				result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
				Map<String, Object> params = JSON.parseObject(result, HashMap.class);
				String flag = params.get("flag").toString();
				String fileId = params.get("fileId").toString();
				map.put("flag",flag);
				map.put("fileId",fileId);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.getConnectionManager().shutdown();
			} catch (Exception ignore) {
			}
		}
		return map;
	}

	// 多文件上传
	public static Map<String, Object> uploadPosts(String type, String businessNo, MultipartFile[] files) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		// 获取文件服务器地址
		String urlPrefix = fileSvrAddr + "/";
		String url = urlPrefix + "uploadFiles";
		String createdUser = userUtils.getUserId().toString();

		CloseableHttpClient httpClient = HttpClients.createDefault();
		String result = "";
		try {
			HttpPost httpPost = new HttpPost(url);
			MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			for (int i = 0, len = files.length; i < len; i++) {
				builder.addBinaryBody("files", files[i].getInputStream(), ContentType.MULTIPART_FORM_DATA, files[i].getOriginalFilename());
			}
			// 类似浏览器表单提交，对应input的name和value
			builder.addTextBody("password", encrypPassword);
			builder.addTextBody("envCode", envCode);
			builder.addTextBody("systemCode", systemCode);
			builder.addTextBody("type", type);
			builder.addTextBody("businessNo", businessNo);
			builder.addTextBody("createdUser", createdUser);
			builder.setCharset(CharsetUtils.get("UTF-8"));
			HttpEntity entity = builder.build();
			httpPost.setEntity(entity);
			// 执行提交
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity responseEntity = response.getEntity();
			if (responseEntity != null) {
				// 将响应内容转换为字符串
				result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
				Map<String, Object> params = JSON.parseObject(result, HashMap.class);
				String flag = params.get("flag").toString();
				map.put("flag",flag);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.getConnectionManager().shutdown();
			} catch (Exception ignore) {
			}
		}
		return map;
	}

	// 下载文件
	public static void downLoadFile(HttpServletResponse res, String fid){
		InputStream in = null;
		FileOutputStream out = null;
		OutputStream output = null;
		try {
			String urlPrefix = fileSvrAddr +"/";
			String urlStr = urlPrefix + "downloadFile";
			HttpPost httpPost = new HttpPost(urlStr);
			CloseableHttpClient client = HttpClients.createDefault();
			String respContent = null;
			// JSON方式
			JSONObject jsonParam = new JSONObject();
			jsonParam.put("id", fid);
			jsonParam.put("password", encrypPassword);
			// 解决中文乱码问题
			StringEntity entity = new StringEntity(jsonParam.toString(),"utf-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httpPost.setEntity(entity);
			HttpResponse resp = client.execute(httpPost);
			if(resp.getStatusLine().getStatusCode() == 200) {
				HttpEntity he = resp.getEntity();
				respContent = EntityUtils.toString(he,"UTF-8");
			}
			String urlFile = "";
			Map<String, Object> params = JSON.parseObject(respContent, HashMap.class);
			String flagTemp = params.get("flag").toString();
			if (flagTemp.equals("Y")) {
				List<String> urlList = (List<String>) params.get("urlList");
				urlFile = urlList.get(0);
			}else {
				return;
			}
			// 获取文件名
			int fileNameIndex = urlFile.lastIndexOf("/");
			String fileName = urlFile.substring(fileNameIndex + 1, urlFile.length());

			// 开始输出文件流
			// 1.HttpURLConnection链接文件
			// 2.输入流读取文件
			// 3.得到流
			// 4.输出流写数据
			// 5.关闭流

			// url转码
			urlFile = urlFile.substring(0, urlFile.lastIndexOf("/")) + "/" + URLEncoder.encode(fileName,"UTF-8");
			URL url = new URL(urlFile);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 设置超时间为3秒
			conn.setConnectTimeout(3 * 1000);
			// 防止屏蔽程序抓取而返回403错误
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			// 得到输入流
			in = conn.getInputStream();
			res.reset();
			// res.setContentType("");
			res.addHeader("content-Disposition", "inline;filename=" + URLEncoder.encode(fileName, "UTF-8"));
			output = res.getOutputStream();
			byte[] b = new byte[4096];
			int i = 0;
			while ((i = in.read(b)) > 0) {
				output.write(b, 0, i);
			}
		} catch (MalformedURLException malformedURLException) {
			malformedURLException.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if (null != out) {
					out.close();
				}
				if (null != in) {
					in.close();
				}
				if( null != output) {
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 查询文件ID
	public static Map<String, Object> viewFile(HttpServletResponse res, String businessNo){
		try {
			String urlPrefix = fileSvrAddr +"/";
			String urlStr = urlPrefix + "downloadFile";

			HttpPost httpPost = new HttpPost(urlStr);
			CloseableHttpClient client = HttpClients.createDefault();
			String respContent = null;
			// JSON方式
			JSONObject jsonParam = new JSONObject();
			jsonParam.put("businessNo", businessNo);
			jsonParam.put("password", encrypPassword);
			// 解决中文乱码问题
			StringEntity entity = new StringEntity(jsonParam.toString(),"utf-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httpPost.setEntity(entity);
			HttpResponse resp = client.execute(httpPost);
			if(resp.getStatusLine().getStatusCode() == 200) {
				HttpEntity he = resp.getEntity();
				respContent = EntityUtils.toString(he,"UTF-8");
			}

			Map<String, Object> params = JSON.parseObject(respContent, HashMap.class);
			String flagTemp = params.get("flag").toString();
			if (flagTemp.equals("Y")) {
				return params;
			}else {
				return null;
			}
		} catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *
	 * @param fileName
	 * @return 创建文件生成路径
	 * @throws Exception
	 */
	public String createTemplatePath(StringBuffer fileName) throws Exception {
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		path = path.replace("/WEB-INF/classes", "/fileUpload/temp");
		path = path.substring(1, path.length());
		StringBuffer sb = new StringBuffer();
		sb.append(path).append(fileName.toString()).append(".xls");
		return sb.toString();
	}

}
