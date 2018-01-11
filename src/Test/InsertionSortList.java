package Test;

public class InsertionSortList {
    private ListNode head;

    public InsertionSortList() {
        head = null;
    }

    public void sort() {
        ListNode copy = sort(head);
        printAll(copy);
    }

    public void printAll(ListNode head) {
        ListNode tmp = head;
        while(tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
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

    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode reHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reHead;
    }

    private ListNode reverse2(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }


    public void printReverse() {
        head = reverse2(head);
//        printAll(head);
    }

    public void print() {
        printAll(head);
    }

    public static void main(String []args) {
        InsertionSortList sortList = new InsertionSortList();
        sortList.insert(1);
        sortList.insert(3);
        sortList.insert(2);
        sortList.insert(0);
        sortList.printReverse();
        sortList.print();
    }
}
