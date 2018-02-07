package ThinkingInJava.concurrency.share_21_3_1;

import java.util.concurrent.*;

public class EvenChecker implements Runnable{
    private IntGenerator generator;
    private final int id;
    public EvenChecker(IntGenerator generator, int id) {
        this.id = id;
        this.generator = generator;
    }
    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }

    private static void test(IntGenerator gp, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp, i));
        }
        exec.shutdown();
    }
}
