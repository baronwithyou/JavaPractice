package ThinkingInJava.concurrency.ui_21_2_12;

class UnresponsiveUI {
    private volatile double d = 1;
    public UnresponsiveUI() throws Exception {
        while (d > 0)
            d += (Math.PI + Math.E) / d;
        System.in.read();
    }
}

public class ResponsiveUI extends Thread{
    private static volatile double d = 1;
    public ResponsiveUI() {
        // 后台线程（守护线程），这里run的运算不是永久的，因为当用户输入之后，程序就会打印出run的结果并且退出
        setDaemon(true);
        start();
    }

    public void run() {
        while (true) {
            d += (Math.PI + Math.E) / d;
        }
    }

    public static void main(String []args) throws Exception {
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}
