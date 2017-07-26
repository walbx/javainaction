package me.aloo.javainaction.action;

import java.util.concurrent.*;

/**
 * Created by walbx on 2017/7/26.
 */
public class SimulateJmeter {
    /**
     * 当线程启动起来  执行到signal.await();  那么线程被阻塞
     * 当主线程sleep完后  调用countDown  所有子线程恢复  这样可以算是并行执行了
     * @param es
     * @param threadCount
     * @param task
     * @return
     * @throws Exception
     */
    public static long runTasks(ExecutorService es, int threadCount, final Runnable task) throws Exception {
        final long startTestTime = System.currentTimeMillis();

        final CountDownLatch signal = new CountDownLatch(1);
        final CountDownLatch taskFinishSignal = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i ++) {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        signal.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                try {
                    task.run();
                } finally {
                    taskFinishSignal.countDown();
                }
            }
            });
        }
        //等所有线程都启动起来
        Thread.sleep(5000L);
        signal.countDown();

        taskFinishSignal.await();

        return System.currentTimeMillis() - startTestTime;
    }
}
