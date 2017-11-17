package Chapter10.AuthBoxing;

import java.util.ArrayList;

public class PreJava {
    public static void main(String []args) {
        // Java 5.0 之前的ArrayList只能传入object对象
        ArrayList listOfNum = new ArrayList();
        listOfNum.add(new Integer(3));
        Integer one = (Integer) listOfNum.get(0);
        System.out.println(one.intValue());
    }
}
