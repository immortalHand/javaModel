package com.shop.common.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * 线程池工具，用来创建线程池，并提供将任务添加到线程池的方法
 *
 */
public class ThreadPoolUtils {

    private static final ThreadPoolExecutor exec = new ThreadPoolExecutor(200, 200,
            0L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>());

    /**
     * 禁止实例化
     */
    private ThreadPoolUtils() {

    }

    /**
     * 提交任务
     */
    public static void exec(Runnable task) {

        exec.submit(task);
    }

}
