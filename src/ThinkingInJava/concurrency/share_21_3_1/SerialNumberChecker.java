package ThinkingInJava.concurrency.share_21_3_1;

import java.util.concurrent.*;

// 一个包装好的数组类（当插入的数量大于预设的数组大小，就会覆盖原来的值）
class CircularSet {
    private int[] array;
    private int len;
    private int index = 0;
    public CircularSet(int size) {
        array = new int[size];
        len = size;
        for (int i = 0; i < size; i++)
            array[i] = -1;
    }

    public synchronized void add(int i) {
        array[index] = i;
        index = ++index % len;
    }

    public synchronized boolean contains(int i) {
        for (int a : array)
            if (a == i)
                return true;
        return false;
    }
}

public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static CircularSet serials = new CircularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();
    static class SerialChecker implements Runnable {
        @Override
        public void run() {
            while (true) {
                int serial = SerialNumberGenerator.nextSerialNumber();
                if (serials.contains(serial)) {
                    System.out.println("Duplicate " + serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }

    public static void main(String []args) throws Exception {
        // 创建十个附带任务的线程
        for (int i = 0; i < SIZE; i++)
            exec.execute(new SerialChecker());
        if (args.length > 0) {
            TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
            System.out.println("No duplicates detected");
            System.exit(0);
        }
    }
}
