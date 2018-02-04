package ThinkingInJava.concurrency;

import java.util.concurrent.TimeUnit;

public class SimpleThread extends Thread {

    private int countDown = 5;
    private static int threadCount = 0;

    public SimpleThread() {
        super(Integer.toString(++threadCount));
        start();
    }

    public String toString() {
        return "#" + getName() + "(" + countDown + ").";
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.print("Interrupted");
        }
        while (true) {
            System.out.print(this);
            if (--countDown == 0) {
                Thread.yield();
                return;
            }
        }
    }

    public static void main(String []args) {
        for (int i = 0; i < 5; i++)
            new SimpleThread();
    }
}
