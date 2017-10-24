package Algorithm.Chapter2;

public class BinarySearch {
    public static void main(String []args) {
    }

    private static <AnyType extends Comparable<? super AnyType>> int binarySearch(AnyType []a, AnyType x) {
        int low = 0;
        int hight = a.length;
        while (low <= hight) {
            int middle = (low + hight) / 2;
            if (a[middle].compareTo(x) < 0) {
                low = middle + 1;
            } else if (a[middle].compareTo(x) > 0) {
                hight = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
