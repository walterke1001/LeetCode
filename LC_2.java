public class LC_2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p = dummy;
        int carry = 0;
        int sum = 0;
        while (p1 != null && p2 != null) {
            sum = p1.val + p2.val + carry;
            p.next = new ListNode(sum % 10);
            carry = sum / 10;
            p = p.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p2 != null) {
            sum = p2.val + carry;
            p.next = new ListNode(sum % 10);
            carry = sum / 10;
            p = p.next;
            p2 = p2.next;
        }


        while (p1 != null) {
            sum = p1.val + carry;
            p.next = new ListNode(sum % 10);
            carry = sum / 10;
            p = p.next;
            p1 = p1.next;
        }
        if (carry != 0) {
            p.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
