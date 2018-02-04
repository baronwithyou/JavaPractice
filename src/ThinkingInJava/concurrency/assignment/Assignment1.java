package ThinkingInJava.concurrency.assignment;

public class Assignment1 implements Runnable {
    private String startMsg = "This is a demo start";
    private String endMsg = "This is a demo end";
    private final String runMsg = "This is a demo run";
    public Assignment1() { }
    public Assignment1(String startMsg, String endMsg) {
        this.startMsg = startMsg;
        this.endMsg = endMsg;
    }
    @Override
    public void run() {
        System.out.println(startMsg);
        for (int i = 0; i < 3; i++) {
            System.out.println(runMsg);
            Thread.yield();
        }
        System.out.println(endMsg);
    }
    public static void main(String []args) {
        for (int i = 0; i < 5; i++)
            new Thread(new Assignment1(i + "start", i + "end")).start();
        System.out.println("Waiting for Threads");
    }
}
