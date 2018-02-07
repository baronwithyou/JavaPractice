package ThinkingInJava.concurrency.task_21_2_1;

public class LiftOff implements Runnable{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff() {}
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }
    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + ").";
    }
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            // 可以将CPU从一个线程转移给另一个线程
            Thread.yield();
        }
    }
}
