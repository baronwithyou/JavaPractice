package Chapter10.AuthBoxing;

public class TestBox {
    Integer i = new Integer(12);
    int j;
    public static void main(String []args) {
        TestBox t = new TestBox();
        t.go();
        t.transfer("1232");
    }

    private void go() {
        j = i;
        System.out.println(i);
        System.out.println(j);
    }

    private void transfer(String x) {
        int y = Integer.parseInt(x);
        double z = Double.parseDouble(x);
        // 下面这种形式可以简化成 Boolean.parseBoolean(x);
        boolean b = new Boolean(x).booleanValue();
        String s = "$" + z;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(b);
        System.out.println(s);
    }
}
