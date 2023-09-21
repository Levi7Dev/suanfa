package test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author Levi
 * @create 2023/8/24 13:42
 */
public class ThreadTest {
    public static Object object = new Object();
    static ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
    static InheritableThreadLocal<String> threadLocal2 = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println(111);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    threadLocal1.set("ggggg");
                    threadLocal2.set("hhhhh");
                    System.out.println(222);
                }
            }
        });

        t2.start();
        t2.join();
        t1.start();

        Thread t3 = new Thread(new RunnableA());
        t3.start();

    }
}

class RunnableA implements Runnable {
    @Override
    public void run() {

    }
}
