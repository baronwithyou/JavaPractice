package Test;

import java.util.ArrayList;

public class ListRemove {
    public static void main(String []args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.remove(2);

        list.add(6);

        System.out.println(list.get(list.size() - 1));
        System.out.println(Integer.MIN_VALUE );
//        for (int item : list)
//            System.out.println(item);
    }
}
