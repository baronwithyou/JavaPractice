package ThinkingInJava.string;

public class Hex {
    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : data) {
            if (n % 16 == 0)
                result.append(String.format("%05X: ", n));
            result.append(String.format("%02X", b));
            n++;
            if (n % 16 == 0)
                result.append("\n");
        }
        result.append("\n");
        return result.toString();
    }

    public static void main(String []args) {
        String s1 = "Hello" + "World";
        String s2 = "HelloWorld";
        String s3 = new String("HelloWorld");
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s2.equals(s3));
    }
}
