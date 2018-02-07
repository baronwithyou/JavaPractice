package ThinkingInJava.concurrency.daemon_21_2_8;

import java.util.concurrent.*;

/**
 * 后台（daemon）线程，是指在程序运行的时候在后台提供一种通用服务的线程。
 * 因此，当所有的非后台线程结束时，程序也就终止并且杀死进程中的所有后台线程。
 */
public class SimpleDaemons implements Runnable{

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String []args) {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
//            将其设置为后台线程
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All deamons started");
        try {
//            调整main线程的sleep时间可以看出如果main线程结束，所有的后台线程就会结束。
            TimeUnit.MILLISECONDS.sleep(17500);
        } catch (InterruptedException e) {
            System.out.println("main sleep() interrupted");
        }
    }
}
