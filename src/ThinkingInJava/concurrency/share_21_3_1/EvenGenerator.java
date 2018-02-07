package ThinkingInJava.concurrency.share_21_3_1;

public class EvenGenerator extends IntGenerator{

    private int currentEvenValue = 0;
    // 如果不对next方法进行同步，该程序就会因为线程同时执行++currentEvenValue而得到基数
    @Override
    public synchronized int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String []args){
        EvenChecker.test(new EvenGenerator());
    }
}
