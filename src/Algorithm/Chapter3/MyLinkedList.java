package Algorithm.Chapter3;

import java.util.Iterator;

/**
 * 单链表
 * @param <AnyType>
 */
public class MyLinkedList <AnyType> implements Iterable<AnyType>{
    @Override
    public Iterator<AnyType> iterator() {
        return null;
    }

    private SingleListNode<AnyType> head;
    public MyLinkedList() {
        head = null;
    }

    public void insert(AnyType x) {
        insert(new SingleListNode<>(x));
    }

    private void insert(SingleListNode<AnyType> n) {
        if (head == null) {
            head = n;
            return;
        }
        // 如果不赋值给temp就操作head会导致head指向修改后的指针
        SingleListNode<AnyType> temp =  head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(n);
    }

    public void printList() {
        printList(head);
    }

    private void printList(SingleListNode<AnyType> n) {
        while(n != null) {
            System.out.println(n.getVal());
            n = n.getNext();
        }
    }

    public void printReverse() {
        printList(reverse(head));
    }

    private SingleListNode<AnyType> reverse(SingleListNode<AnyType> n) {
        if (n == null || n.getNext() == null)
            return n;
        SingleListNode<AnyType> reHead = reverse(n.getNext());
        n.getNext().setNext(n);
        n.setNext(null);
        return reHead;
    }

    public void remove(AnyType x) {
        SingleListNode<AnyType> temp = new SingleListNode<>(null);
        temp.setNext(head);
        SingleListNode<AnyType> prev = temp;
        while(head != null) {
            if (x == head.getVal()) {
                prev.setNext(head.getNext());
            } else {
                prev = head;
            }
            head = head.getNext();
        }
        head = temp.getNext();
    }

    public static void main(String []args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.insert(4);
        myLinkedList.insert(5);
        myLinkedList.insert(6);
        myLinkedList.insert(7);
        myLinkedList.remove(4);
        myLinkedList.printList();
        myLinkedList.printReverse();
    }
}

