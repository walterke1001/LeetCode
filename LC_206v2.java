public class LC_206v2 {
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

    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    public static ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) return pre;
        ListNode res = reverse(cur, cur.next);
        cur.next = pre;
        return res;
    }
}
