package Algorithm.Chapter3;

import java.util.*;

public class MyArrayList<AnyType> implements Iterable<AnyType> {
    private int theSize;
    private AnyType[] theItems;
    public int size() {
        return theSize;
    }

    public MyArrayList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {

    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize)
            return;
        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }
    /**
     * 删除ArrayList中的一个元素
     * 思路： 记录下待删除的元素，将这个元素的后的每一个元素往前移一位
     * @param idx
     * @return
     */
    public AnyType remove(int idx) {
        AnyType removeItem = theItems[idx];
        for (int i = idx; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        return removeItem;
    }

    public Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<AnyType> {
        private int current = 0;
        public boolean hasNext() {
            return current < size();
        }
        public AnyType next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return theItems[current++];
        }
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
