package ThinkingInJava.concurrency.share_21_3_1;

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    // 这里设置成static是因为需要用类来调用
    public static int nextSerialNumber() {
        return serialNumber++;
    }
}
