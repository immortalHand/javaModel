package com.shop.common.utils;

import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Desc
 * @Author sinosoft-an
 * @Date 2019/2/24 14:12
 */
@Component
public final class ExceptionUtils {
	/**
	 * 构造方法，禁止实例化
	 */
	private ExceptionUtils() {
	}

	/**
	 * 得到异常堆栈内容
	 * 
	 * @param exception
	 *            异常
	 * @return 异常堆栈内容
	 */
	public static String getExceptionStackTraceString(final Exception exception) {
		StringWriter out = new StringWriter();
		exception.printStackTrace(new PrintWriter(out));
		return out.toString();
	}
}
