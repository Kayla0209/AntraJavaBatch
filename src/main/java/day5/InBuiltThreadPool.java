package day5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InBuiltThreadPool {
    public static void main(String[] args) {
        // LinkedBlockingQueue - unlimited, a problem of out of memory
        ExecutorService tp1 = Executors.newFixedThreadPool(3); // core = 3, max = 3

        ExecutorService tp2 = Executors.newSingleThreadExecutor(); // core = 1, max = 1
        ExecutorService tp3 = Executors.newCachedThreadPool(); // core = 0, max = Integer.MAX_VALUE
        ExecutorService tp4 = Executors.newScheduledThreadPool(3); // core = 3, max = Integer.MAX_VALUE
    }
}
