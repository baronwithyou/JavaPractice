package Algorithm.Chapter2;

public class BinarySearch {
    public static void main(String []args) {
        // 这里不能写成int 因为Integer作为继承了comparabled的对象 而int只是一个主类型
        Integer []arr1 = {3, 4, 12, 1, 14, 5, 23, 10};
        int target = 6;
        binarySearch(arr1, target);
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
