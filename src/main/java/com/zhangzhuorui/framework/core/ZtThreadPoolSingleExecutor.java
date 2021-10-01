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
public class ZtThreadPoolSingleExecutor {

    protected static final Logger log = LoggerFactory.getLogger(ZtThreadPoolSingleExecutor.class);

    private ThreadPoolExecutor executor;

    private ZtThreadPoolSingleExecutor() {
    }

    enum SingletonEnum {
        //枚举天生为单例
        INSTANCE;
        private ZtThreadPoolSingleExecutor executorZt;

        private SingletonEnum() {

            TimeUnit unit = TimeUnit.MILLISECONDS;
            this.executorZt = new ZtThreadPoolSingleExecutor();
            BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
            ThreadFactory threadFactory = new NameTreadFactory();
            RejectedExecutionHandler handler = new MyIgnorePolicy();

            this.executorZt.executor = new
                    ThreadPoolExecutor(1
                    , 1
                    , 0
                    , unit, workQueue, threadFactory, handler);

            this.executorZt.executor.prestartAllCoreThreads();

        }

        public ZtThreadPoolSingleExecutor getInstnce() {
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
            Thread t = new Thread(r, "zt-single-" + this.mThreadNum.getAndIncrement());
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
