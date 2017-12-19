package Test;

// 单链表节点
public class ListNode {
    ListNode next;
    int val;
    ListNode(int val) {
        this(val, null);
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
