package ThinkingInJava.concurrency.daemon_21_2_8;

import ThinkingInJava.net.mindview.util.DaemonThreadFactory;

import java.util.concurrent.*;

public class DaemonFromFactory implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    public static void main(String []args) {
        // 通过使用后台线程池（工厂模式）来创建后台线程
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());

        for (int i = 0; i < 10; i++)
            exec.execute(new DaemonFromFactory());
        System.out.println("All daemons started");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Main thread sleep Interrupted");
        }
    }
}
