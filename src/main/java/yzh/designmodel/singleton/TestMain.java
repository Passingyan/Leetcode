package yzh.designmodel.singleton;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yongzh
 * @date 2019/10/9
 */
public class TestMain {
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 60000L,
                    TimeUnit.MICROSECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.DiscardOldestPolicy());
            for (int i = 0; i < 10; i++) {
                threadPoolExecutor.submit(() ->
                        System.out.println(LazyInnerSingleton.getInstance())
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
