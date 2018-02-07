package ThinkingInJava.concurrency.share_21_3_1;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

class Pair { // Not thread-safe
    private int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Pair() { this(0, 0); }
    public int getX() { return x; }
    public int getY() { return y; }
    public void incrementX() { x++; }
    public void incrementY() { y++; }
    public String toString() {
        return "x: " + x + " y: " + y;
    }
    private class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super ("Pair values not equal: " + Pair.this);
        }
    }
    public void checkState() {
        if (x != y)
            throw new PairValuesNotEqualException();
    }
}

// Protect a Pair inside a thread-safe class;
abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<>());
    public synchronized Pair getPair() {
        return new Pair(p.getX(), p.getY());
    }
    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) { }
    }
    public abstract void increment();
}

// Synchronized the entire method
class PairManager1 extends PairManager {
    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

// Use a critical section:
class PairManager2 extends PairManager {
    @Override
    public void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}

// 估计就是多态 同一个方法作用在不同的对象产生不同的结果
class PairManipulator implements Runnable {
    private PairManager pm;
    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }
    @Override
    public void run() {
        while (true)
            pm.increment();
    }
    public String toString() {
        return "Pair: [" + pm.getPair() + "] checkCounter:" + pm.checkCounter;
    }
}

class PairChecker implements Runnable {
    private PairManager pm;
    public PairChecker(PairManager pm) {
        this.pm = pm;
    }
    @Override
    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}

public class CriticalSection {
    static void testApproaches(PairManager pman1, PairManager pman2) {
        ExecutorService exec = Executors.newCachedThreadPool();
        // 创建Runnable（任务）
        PairManipulator pm1 = new PairManipulator(pman1),
                pm2 = new PairManipulator(pman2);
        PairChecker pcheck1 = new PairChecker(pman1),
                pcheck2 = new PairChecker(pman2);
        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pcheck1);
        exec.execute(pcheck2);
//        try {
//            TimeUnit.MILLISECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            System.out.println("Sleep interrupted");
//        }
        new Timer(true).schedule(new TimerTask() {
            public void run() {
                /**
                 * 由于pm1和pcheck1同一时间处理的是同一个类，当其中的increment（synchronized）执行的时候，
                 * pcheck1中的getPair就需要等待increment的锁被打开（即不再占用资源）。
                 * 所以pairmanipulator和parichecker组成一对执行增加并且检测操作速度的任务。
                 */
                System.out.println("pm1: " + pm1);
                System.out.println("pm2: " + pm2);
                System.exit(0);
            }
        }, 500);
//        System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
//        System.exit(0);
    }

    public static void main(String []args) {
        PairManager pman1 = new PairManager1(),
                pman2 = new PairManager2();
        testApproaches(pman1, pman2);
    }
}
