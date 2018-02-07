package ThinkingInJava.concurrency.thread_21_2_2;

import ThinkingInJava.concurrency.task_21_2_1.LiftOff;

public class MoreBasicThreads {
    public static void main(String []args) {
        // 同一时间创建5个线程并且同时运行，每一个线程的任务总是会完成（底层机智为：切分CPU时间，通常不需要考虑）
        for (int i = 0; i < 5; i++)
            new Thread(new LiftOff()).start();
        System.out.println("Waiting for LiftOff");
    }
}
