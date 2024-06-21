public class LC_25 {
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



    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode end = head;
        for (int i = 1; end != null; i++) {
            if (i % k == 0) {
                reverse(pre, cur, end, k);
                pre = cur;
                cur = cur.next;
            }
            end = end.next;
        }
        return dummy.next;
    }

    public static void reverse(ListNode pre, ListNode cur, ListNode end, int k) {
        ListNode curNext = cur.next;
        for (int i = 0; i < k; i++) {
            cur.next = curNext.next;
            curNext.next = pre.next;
            pre.next = curNext;
            curNext = cur.next;
        }
    }

}
