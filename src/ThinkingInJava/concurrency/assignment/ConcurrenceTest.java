package ThinkingInJava.concurrency.assignment;

class MyThread extends Thread {
    private int ticket = 10;
    public void run() {
        while (ticket > 0) {
            System.out.println(getName() + " buy a ticket. " + --ticket + " tickets left");
        }
    }
}

class MyRunnable implements Runnable {
    // 如果不设置成static的话每个线程都会从ticket = 10开始
    private volatile int ticket = 10;
    public void run() {
        while (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + " buy a ticket. " + --ticket + " tickets left");
            Thread.yield();
        }
    }
}

public class ConcurrenceTest {
    public static void main(String []args) {
//        Thread t1 = new MyThread();
//        Thread t2 = new MyThread();
//        Thread t3 = new MyThread();
        Runnable r = new MyRunnable();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
    }
}
