package ThinkingInJava.concurrency.task_21_2_1;

public class MainThread {
    public static void main(String []args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
