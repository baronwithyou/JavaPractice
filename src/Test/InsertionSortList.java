package Test;

public class InsertionSortList {
    private ListNode head;

    public InsertionSortList() {
        head = null;
    }

    public void sort() {
        ListNode copy = sort(head);
        while(copy != null) {
            System.out.println(copy.val);
            copy = copy.next;
        }
    }

    public void insert(int val) {
        head = insert(val, head);
    }

    private ListNode insert(int val, ListNode head) {
        ListNode copy = head;
        ListNode next = new ListNode(val);
        if (head == null)
            return next;
        while (head.next != null) {
            head = head.next;
        }
        head.next = next;
        return copy;
    }

    private ListNode sort(ListNode head) {
        // 这里的dummy不需要和head连接起来 因为获得的元素直接插入进dummy中
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode node = dummy;
            while(node.next != null && node.next.val < head.val)
                node = node.next;
            ListNode next = head.next;
            head.next = node.next;
            node.next = head;
            head = next;
        }

        return dummy.next;
    }

    public static void main(String []args) {
        InsertionSortList sortList = new InsertionSortList();
        sortList.insert(1);
        sortList.insert(3);
        sortList.insert(2);
        sortList.insert(0);
        sortList.sort();
    }
}
