package ThinkingInJava.concurrency.executor_21_2_3;

import ThinkingInJava.concurrency.task_21_2_1.LiftOff;

import java.util.concurrent.*;

public class CachedThreadPool {
    public static void main(String []args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();

        System.out.println("this is  a test");
    }
}
