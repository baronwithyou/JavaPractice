package Test;

public class LinkedListQuote {
    public void makeAList() {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        test(head);
        print(head);
//        System.out.println("===" + head.val);
    }

    private void test(ListNode node) {
        node = new ListNode(10);
    }

    public void print(ListNode head) {
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String []args) {
        new LinkedListQuote().makeAList();
    }
}
