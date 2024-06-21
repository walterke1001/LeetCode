import java.util.List;

public class LC_92 {
    public static class ListNode {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        dummy.next = head;
        ListNode p = head;
        for (int i = 1; i < left; i++) pre = pre.next;
        ListNode cur = pre.next;
        ListNode r = cur.next;
        for (int i = 0; i < right - left; i++) {
            cur.next = r.next;
            r.next = pre.next;
            pre.next = r;
            r = cur.next;
        }
        return dummy.next;
    }
}
