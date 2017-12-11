package Algorithm.Chapter3;

public class SingleListNode<AnyType> {
    private AnyType val;
    private SingleListNode<AnyType> next;
    public SingleListNode(AnyType val) {
        this.val = val;
    }

    public SingleListNode<AnyType> getNext() {
        return next;
    }

    public void setNext(SingleListNode<AnyType> next) {
        this.next = next;
    }

    public AnyType getVal() {
        return val;
    }
}
