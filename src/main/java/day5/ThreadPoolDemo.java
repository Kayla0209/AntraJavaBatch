package day5;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 1; i <= 10; i++) {
            threadPoolExecutor.execute(
                    () -> {
                        System.out.println(Thread.currentThread().getName() + " is working");
                    }
            );
        }

        threadPoolExecutor.shutdown();
    }
}
