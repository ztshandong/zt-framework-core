package com.zhangzhuorui.framework.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author :  zhangtao
 * @version :  1.0
 * @createDate : 2017-01-01
 * @description :
 * @updateUser :
 * @updateDate :
 * @updateRemark :
 */
public class ZtThreadPoolIoExecutor {

    protected static final Logger log = LoggerFactory.getLogger(ZtThreadPoolIoExecutor.class);

    private ThreadPoolExecutor executor;

    private ZtThreadPoolIoExecutor() {
    }

    enum SingletonEnum {
        //枚举天生为单例
        INSTANCE;
        private ZtThreadPoolIoExecutor executorZt;

        private SingletonEnum() {

            TimeUnit unit = TimeUnit.SECONDS;
            this.executorZt = new ZtThreadPoolIoExecutor();
            BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(5000);
            ThreadFactory threadFactory = new NameTreadFactory();
            RejectedExecutionHandler handler = new MyIgnorePolicy();

            this.executorZt.executor = new
                    ThreadPoolExecutor(
                    Runtime.getRuntime().availableProcessors() * 2
                    , Runtime.getRuntime().availableProcessors() * 2
                    , 300
                    , unit, workQueue, threadFactory, handler);
            // this.executorZt.executor.prestartAllCoreThreads();
        }

        public ZtThreadPoolIoExecutor getInstense() {
            return this.executorZt;
        }

        public ThreadPoolExecutor getExecutor() {
            return this.executorZt.executor;
        }
    }

    public static ThreadPoolExecutor getExecutor() {
        return SingletonEnum.INSTANCE.getExecutor();
    }

    static class NameTreadFactory implements ThreadFactory {

        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "zt-io-" + this.mThreadNum.getAndIncrement());
            log.info(t.getName() + " 已创建");
            return t;
        }
    }

    static class MyIgnorePolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            this.doLog(r, e);
        }

        private void doLog(Runnable r, ThreadPoolExecutor e) {
            log.error(r.toString() + " RejectedExecutionHandler");
        }
    }

}
