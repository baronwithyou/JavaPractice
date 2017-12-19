package Algorithm.Chapter7;

public class MergeSort<AnyType extends Comparable<? super AnyType>> {
    public static void main(String []args) {
        Integer []arr = {5, 10, 2, 9, 30, 7, 12};
        mergeSort(arr);

        for (int item : arr)
            System.out.println(item);
    }
    /**
     * You can't call something that doesn't exist. Since you haven't created an object,
     * the non-static method doesn't exist yet. A static method (by definition) always exists.
     * 该类中静态方法中不添加<AnyType extends Comparable<? super AnyType>>就会报错 --以上截取自stackoverflow
     * @param a
     * @param <AnyType>
     */
    public static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType []a) {
        AnyType []tmpArray = (AnyType[]) new Comparable[a.length];

        mergeSort(a, tmpArray, 0, a.length - 1);
    }

    private static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType []a, AnyType []tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    private static <AnyType extends Comparable<? super AnyType>> void merge(AnyType []a, AnyType []tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while(leftPos <= leftEnd && rightPos <= rightEnd)
            if (a[leftPos].compareTo(a[rightPos]) <= 0)
                tmpArray[tmpPos++] = a[leftPos++];
            else
                tmpArray[tmpPos++] = a[rightPos++];

        while(leftPos <= leftEnd)
            tmpArray[tmpPos++] = a[leftPos++];

        while(rightPos <= rightEnd)
            tmpArray[tmpPos++] = a[rightPos++];

        // Copy tmpArray back
        for (int i = 0; i < numElements; i++, rightEnd--)
            a[rightEnd] = tmpArray[rightEnd];
    }
}
