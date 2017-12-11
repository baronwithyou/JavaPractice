package HeadFirst.Chapter11;

public class TestExceptions {
    public static void main(String []args) {
        try {
            doRisky("yes");
            // 如果上一条语句抛出异常 则不会运行下一行语句
            System.out.println("end try");
        } catch (Exception e) {
            System.out.println("scary exception");
        } finally {
            System.out.println("finally");
        }
    }

    static void doRisky(String test) throws Exception {
//        System.out.println("Start risky");
        if ("yes".equals(test)) {
            throw new Exception();
        }
//        System.out.println("end risky");
    }
}
