package day5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// Three ways to create thread.
public class ThreadCreation {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new CustomizedThread();
        t1.start();

        Thread t2 = new Thread(new CustomizedRunnable());
        t2.start();

        FutureTask ft = new FutureTask(new CustomizedCallable());
        Thread t3 = new Thread(ft);
        t3.start();
        System.out.println(ft.get());
    }
}

class CustomizedThread extends Thread { // it's an option to override run() method
    public void run() {
        System.out.println("extends thread class, the current thread is " + Thread.currentThread().getName());
    }
}

class CustomizedRunnable implements Runnable { // have to override run() method
    @Override
    public void run() {
        System.out.println("From runnable, the current thread is " + Thread.currentThread().getName());
    }
}

class CustomizedCallable implements Callable {
    @Override
    public Integer call() throws Exception {
        System.out.println("From callable, the current thread is " + Thread.currentThread().getName());
        return 200;
    }
}