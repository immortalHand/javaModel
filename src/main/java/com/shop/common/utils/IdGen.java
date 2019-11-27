package com.shop.common.utils;

import com.shop.modules.oss.entity.SysOssEntity;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

public class IdGen {
	
	private static SecureRandom random = new SecureRandom();
	
	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.  32位长度。一般用它
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 使用SecureRandom随机生成Long. 
	 */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}

	/**
	 * 随机生成包含大小写字母及数字的字符串
	 *
	 * @param length
	 * @return
	 */
	public static String getStringRandom(int length) {

		String val = "";
		Random random = new Random();

		//参数length，表示生成几位随机数
		for (int i = 0; i < length; i++) {

			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			//输出字母还是数字
			if ("char".equalsIgnoreCase(charOrNum)) {
				//输出是大写字母还是小写字母
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (random.nextInt(26) + temp);
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}

	/**
	 * 生成随机数字,
	 *
	 * @param length
	 * @return
	 */
	public static String getNumRandom(int length) {

		String val = "";
		Random random = new Random();

		//参数length，表示生成几位随机数
		for (int i = 0; i < length; i++) {
			val += String.valueOf(random.nextInt(10));
		}
		return val;
	}

	/**
	 * 生成随机数字和小写字母串,
	 *
	 * @param length
	 * @return
	 */
	public static String getNumSmallCharRandom(int length) {

		String val = "";
		Random random = new Random();

		//参数length，表示生成几位随机数
		for (int i = 0; i < length; i++) {

			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			//输出字母还是数字
			if ("char".equalsIgnoreCase(charOrNum)) {
				//输出小写字母
				val += (char) (random.nextInt(26) + 97);
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				//输出数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}

	/**
	 * 生成随机数字和大写字母串,
	 *
	 * @param length
	 * @return
	 */
	public static String getNumBigCharRandom(int length) {

		String val = "";
		Random random = new Random();

		//参数length，表示生成几位随机数
		for (int i = 0; i < length; i++) {

			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			//输出字母还是数字
			if ("char".equalsIgnoreCase(charOrNum)) {
				//输出大写字母
				val += (char) (random.nextInt(26) + 65);
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				//输出数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
	
	public static void main(String[] args) {
		System.out.println(IdGen.uuid());   
		System.out.println(randomLong());
		System.out.println(getStringRandom(50));
	}

}