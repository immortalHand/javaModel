package com.shop.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class ClientUtils {
	
	private static Logger logger = LoggerFactory.getLogger(ClientUtils.class);

	public static String[] connectServer(String serverURL) {
		String[] result = new String[2];
		result[0] = "N";
		CloseableHttpResponse response = null;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(serverURL);
			response = httpclient.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				HttpEntity resEntity = response.getEntity();
				result[0] = "Y";
				result[1] = URLDecoder.decode(EntityUtils.toString(resEntity),
						"UTF-8");
			} else {
				throw new IllegalStateException("Method failed: "
						+ response.getStatusLine());
			}
		} catch (IllegalStateException e) {
			result[1] = "请求没有正常响应,请稍后再试...";
			e.printStackTrace();
		} catch (Exception e) {
			result[1] = "请求平台连接错误,请联系系统管理员...";
			e.printStackTrace();
		} finally {
			if (response != null){
				try {
					response.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if (response != null) {
			try {
				response.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	
	public static  String[] connectServer(Object inputObject, String serverURL) {
		String[] result = new String[2];
		result[0] = "N";
		String jsonData = JSON.toJSONString(inputObject);
		CloseableHttpResponse response = null;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httppost = new HttpPost(serverURL);
			StringEntity stringEntity = new StringEntity(URLEncoder.encode(
					jsonData, "UTF-8"), ContentType.create("text/plain",
					"UTF-8"));
			httppost.setEntity(stringEntity);
			response = httpclient.execute(httppost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				HttpEntity resEntity = response.getEntity();
				result[0] = "Y";
				result[1] = URLDecoder.decode(EntityUtils.toString(resEntity),
						"UTF-8");
			} else {
				throw new IllegalStateException("Method failed: "
						+ response.getStatusLine());
			}
		} catch (IllegalStateException e) {
			result[1] = "请求没有正常响应,请稍后再试...";
			e.printStackTrace();
		} catch (Exception e) {
			result[1] = "请求平台连接错误,请联系系统管理员...";
			e.printStackTrace();
		} finally {
			if (response != null){
				try {
					response.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if (response != null) {
			try {
				response.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}


	public static String[] connectServer(String serverURL,
			ArrayList<NameValuePair> nvpairs) throws Exception {
		String[] result = new String[2];
		result[0] = "N";

		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost(serverURL);
		CloseableHttpResponse response = null;
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvpairs, "GBK"));

			response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				HttpEntity resEntity = response.getEntity();
				result[0] = "Y";
				result[1] = EntityUtils.toString(resEntity);
			} else {
				throw new IllegalStateException("Method failed: "
						+ response.getStatusLine());
			}
		} catch (IllegalStateException e) {
			result[1] = "The request is not responding. Please try again later.";
			e.printStackTrace();
		} catch (Exception e) {
			result[1] = "Request connection error.";
			e.printStackTrace();
		} finally {
			if (response != null){
				try {
					response.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if (response != null) {
			try {
				response.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public static String[] connectServer(String serverURL, Object inputObject) {
		String[] result = new String[2];
		result[0] = "N";
		String jsonData = JSON.toJSONString(inputObject);
		CloseableHttpResponse response = null;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httppost = new HttpPost(serverURL);
			StringEntity stringEntity = new StringEntity(URLEncoder.encode(
					jsonData, "UTF-8"), ContentType.create("text/plain",
					"UTF-8"));
			httppost.setEntity(stringEntity);
			response = httpclient.execute(httppost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				HttpEntity resEntity = response.getEntity();
				result[0] = "Y";
				result[1] = EntityUtils.toString(resEntity, "UTF-8");
			} else {
				throw new IllegalStateException("Method failed: "
						+ response.getStatusLine());
			}
		} catch (IllegalStateException e) {
			result[1] = "请求没有正常响应,请稍后再试...";
			e.printStackTrace();
		} catch (Exception e) {
			result[1] = "请求平台连接错误,请联系系统管理员...";
			e.printStackTrace();
		} finally {
			if (response != null){
				try {
					response.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if (response != null) {
			try {
				response.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public static String[] connectOpenServer(String serverURL, Object inputObject) {
		String[] result = new String[2];
		result[0] = "N";
		String jsonData = JSON.toJSONString ( inputObject );
		logger.info ( jsonData );
		CloseableHttpResponse response = null;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault ();
			HttpPost httppost = new HttpPost( serverURL );
			StringEntity stringEntity = new StringEntity( jsonData ,
					ContentType.create ( "application/json" , "UTF-8" ) );
			httppost.setEntity ( stringEntity );
			response = httpclient.execute ( httppost );
			int statusCode = response.getStatusLine ().getStatusCode ();
			if ( statusCode == 200 ) {
				HttpEntity resEntity = response.getEntity ();
				result[0] = "Y";
				result[1] = EntityUtils.toString ( resEntity , "UTF-8" );
			}
			else {
				throw new IllegalStateException ( "Method failed: " + response.getStatusLine () );
			}
		}
		catch ( IllegalStateException e ) {
			result[1] = "请求没有正常响应,请稍后再试...";
			e.printStackTrace ();
		}
		catch ( Exception e ) {
			result[1] = "请求平台连接错误,请联系系统管理员...";
			e.printStackTrace ();
		}
		finally {
			if ( response != null ){
				try {
					response.close ();
				}
				catch ( Exception e ) {
					e.printStackTrace ();
				}
			}
		}
		if ( response != null ) {
			try {
				response.close ();
			}
			catch ( Exception e ) {
				e.printStackTrace ();
			}
		}

		return result;
	}

	/**
	 * 查看历史上传文件
	 * <p>User: xruichang
	 * <p>Date: 2017年9月7日
	 * <p>Version: 1.0
	 * @param jsontObject
	 * @param serverUrl
	 * @return
	 */
	public String[] connectUploadSystem(Object jsontObject,String serverUrl){
		String[] result = new String[2];
        result[0] = "N";
        String msg=jsontObject.toString();
        CloseableHttpClient httpclient = HttpClients.createDefault() ;
        StringEntity entity = new StringEntity(msg,Charset.forName("utf-8"));
        entity.setContentType("text/json");
        
        try {
	
			HttpPost httppost = new HttpPost(serverUrl);
			httppost.setHeader("Content-Type", "text/json");
			httppost.setHeader("Connection", "keep-alive");
			httppost.setEntity(entity);
			HttpResponse response = null;
			
			response = httpclient.execute(httppost);
			StatusLine statusLine = response.getStatusLine();
			
			if (statusLine != null && statusLine.getStatusCode() == HttpStatus.SC_OK) {
				result[0]="Y";
				HttpEntity resEntity = response.getEntity();
				String fileHistory = EntityUtils.toString(resEntity);
				result[1]=fileHistory;
				return result;
			}
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				httpclient.close();
			} catch (IOException e) {
				logger.error("IOException异常：{}" ,e.getMessage());
			}
		}
        result[1]="查询不到文件历史";
		return result;
	}

	public static String replacer(String data) {
		try {
			data = data.replaceAll ( "%(?![0-9a-fA-F]{2})" , "%25" );
			data = data.replaceAll ( "\\+" , "%2B" );
			data = URLDecoder.decode ( data , "utf-8" );
		}
		catch ( Exception e ) {
			e.printStackTrace ();
		}
		return data;
	}
	
	/**
	 * 向指定URL发送GET方法的请求
	 *
	 * @param url   发送请求的URL
	 * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static void downLoadFile(HttpServletResponse res, String serverUrl, String fileName) {
	    InputStream in = null;
	    OutputStream out = null;
	    try {
	        URL realUrl = new URL(serverUrl);
	        // 打开和URL之间的连接
	        URLConnection connection = realUrl.openConnection();
	        // 设置通用的请求属性
	        connection.setRequestProperty("accept", "*/*");
	        connection.setRequestProperty("connection", "Keep-Alive");
	        connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	        // 建立实际的连接
	        connection.connect();
	        // 获取所有响应头字段
	        /*Map<String, List<String>> map = connection.getHeaderFields();
	        // 遍历所有的响应头字段
	        for (String key : map.keySet()) {
	            System.out.println(key + "--->" + map.get(key));
	        }*/
	        
	        // 得到输入流
	        in = connection.getInputStream();
	        // 创建文件（加载文件流并存储至服务器内）
	        /*String path = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();
			path = path.replace("/test-classes", "/fileUpload");
			path = path.replace("/classes", "/fileUpload");
			File f = new File(path+"/"+fileName+".xls"); //写文件
			f.createNewFile();
			// 输出流
			FileOutputStream output = new FileOutputStream(f);
			byte[] b = new byte[4096];
			int i = 0;
			while ((i = in.read(b)) > 0) {
				output.write(b, 0, i);
			}
			output.flush();
			output.close();*/
			
	        // 加载文件流到返回响应
			res.reset();
			res.setContentType("application/vnd.ms-excel");
			res.addHeader("content-Disposition", "inline;filename=" + URLEncoder.encode(fileName, "UTF-8"));
			out = res.getOutputStream();
			byte[] b = new byte[4096];
			int i = 0;
			while ((i = in.read(b)) > 0) {
				out.write(b, 0, i);
			}
	    } catch (Exception e) {
	        System.out.println("发送GET请求出现异常！" + e);
	    } finally {// 使用finally块来关闭输入流
	        try {
	        	if (null != in) {
					in.close();
				}
				if ( null != out) {
					out.close();
				}
	        } catch (Exception e2) {
	        	logger.error("关闭文件流异常"+ExceptionUtils.getExceptionStackTraceString(e2));
	        }
	    }
	}
}