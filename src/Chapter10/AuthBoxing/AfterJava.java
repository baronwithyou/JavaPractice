package Chapter10.AuthBoxing;

import java.util.ArrayList;

public class AfterJava {
    public static void main(String []args) {
        // generic 类型的规则是只能指定类或接口类型，所以不能写成ArrayList<int>的形式
        // 下面这样的定义形式可以直接将primitive主数据类型放入Integer ArrayList中
        ArrayList<Integer> listOfNums = new ArrayList<>();
        listOfNums.add(12);
        System.out.println(listOfNums.get(0));
    }
}
