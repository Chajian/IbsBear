package com.bear.util;

import com.bear.menu.plugin.BasePlugin;
import com.sun.corba.se.spi.orbutil.threadpool.ThreadPoolManager;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * bear线程池
 */
public class BearThreadPool {
    public static ThreadPoolExecutor threadPool = null;
    public static BearThreadPool bearThreadPool = null;
    public static int cpuNum = 4;//处理器数量
    public static int threadNum = 9;//并发线程数量
    public static int corePoolSize = 8;//核心池数量
    public static int maximumpoolSize = 9;
    long keepAliveTime = 60l;

    /*存放插件池*/
    public HashMap<String, BasePlugin> threads = new HashMap<>();


    private  BearThreadPool(){
        synchronized (ThreadPoolManager.class) {
            cpuNum = Runtime.getRuntime().availableProcessors();//获取处理器数量
            threadNum = cpuNum * 2 + 1;
            corePoolSize = cpuNum * 2;
            maximumpoolSize = corePoolSize + 1;
            threadPool = new ThreadPoolExecutor(corePoolSize, maximumpoolSize, keepAliveTime
                    , TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(300), Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy());
            System.out.println(threadNum+":"+corePoolSize);
        }
    }


    public static BearThreadPool getBearThreadPool() {
        if(bearThreadPool == null)
            bearThreadPool = new BearThreadPool();
        return bearThreadPool;
    }
}
