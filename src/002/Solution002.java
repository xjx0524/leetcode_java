public class Solution002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = null, prev = null;
        int c = 0;
        while (p1 != null && p2 != null) {
            ListNode p = new ListNode((p1.val + p2.val + c) % 10);
            c = (p1.val + p2.val + c) / 10;
            if (prev == null) {
                head = p;
                prev = p;
            } else {
                prev.next = p;
                prev = p;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            ListNode p = new ListNode((p1.val + c) % 10);
            c = (p1.val + c) / 10;
            if (prev == null) {
                head = p;
                prev = p;
            } else {
                prev.next = p;
                prev = p;
            }
            p1 = p1.next;
        }
        while (p2 != null) {
            ListNode p = new ListNode((p2.val + c) % 10);
            c = (p2.val + c) / 10;
            if (prev == null) {
                head = p;
                prev = p;
            } else {
                prev.next = p;
                prev = p;
            }
            p2 = p2.next;
        }
        if (c > 0) {
            prev.next = new ListNode(c);
        }
        return head;
    }

    public static void main(String[] args) {
        // write your code here
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
