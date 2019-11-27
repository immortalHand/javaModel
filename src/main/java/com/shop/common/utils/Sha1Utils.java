package com.shop.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Sha1Utils {
	
	private static final String SHA_ALG = "SHA-1";
	
	/**
	 * 验证签名
	 *
	 * @param token     分配给保险公司
	 * @param signature 加密签名
	 * @param timestamp 时间戳
	 * @param nonce     随机数
	 * @param message   加密报文
	 * @return
	 */
	public static boolean checkSignature(String token, String signature, String timestamp, String nonce, String appId) {
	    String tmpStr = sign(token, timestamp, nonce, appId);
	    // 将sha1加密后的字符串可与signature对比
	    return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
	}
	
	public static String sign(String token, String timestamp, String nonce, String appId) {
	    String[] arr = new String[]{token, timestamp, nonce, appId};
	    // 将token、timestamp、nonce、companyId四个参数进行字典序排序
	    Arrays.sort(arr);
	    StringBuilder content = new StringBuilder();
	    for (int i = 0; i < arr.length; i++) {
	        content.append(arr[i]);
	    }
	    MessageDigest md = null;
	    String signature = null;
	    try {
	        md = MessageDigest.getInstance(SHA_ALG);
	        // 将三个参数字符串拼接成一个字符串进行sha1加密
	        byte[] digest = md.digest(content.toString().getBytes());
	        signature = byteToStr(digest);
	    } catch (NoSuchAlgorithmException e) {
	    	e.printStackTrace();
	    }
	    return signature;
	}
	/**
	 * 将字节数组转换为十六进制字符串
	 *
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray) {
	    String strDigest = "";
	    for (int i = 0; i < byteArray.length; i++) {
	        strDigest += byteToHexStr(byteArray[i]);
	    }
	    return strDigest;
	}
	/**
	 * 将字节转换为十六进制字符串
	 *
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte) {
	
	    char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	    char[] tempArr = new char[2];
	    tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
	    tempArr[1] = Digit[mByte & 0X0F];
	
	    String s = new String(tempArr);
	    return s;
	}
	
	// 示例：Timestamp=20190122172135&nonce=123456&signature=0D4D9BD7CFD24C268E00076DBDD73204C2962348
    public  static void main(String[] args){
    	// token、timestamp、nonce，appID进行字典序排序
    	String token = "123456";
    	String timestamp = "20190122172135";
    	String nonce = "123456";
    	String appId = "2017440309098";
    	String signature = sign(token, timestamp, nonce, appId);
    	System.out.println("簽名值:" + signature);
    	boolean flag = checkSignature(token, signature, timestamp, nonce, appId);
    	System.out.println(flag);
    	
    }

}