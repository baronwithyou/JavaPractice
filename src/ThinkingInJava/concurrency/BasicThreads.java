package ThinkingInJava.concurrency;

public class BasicThreads {
    public static void main(String []args) {
        // 从这个例子（交替输出）中可以看出main线程和t这个线程同时运行
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for 1");
        System.out.println("Waiting for 2");
        System.out.println("Waiting for 3");
        System.out.println("Waiting for 4");
        System.out.println("Waiting for 5");
    }
}
