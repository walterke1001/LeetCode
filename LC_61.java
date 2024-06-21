public class LC_61 {
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        ListNode q = head;
        int len = 0;
        ListNode j = head;
        while (j != null) {
            j = j.next;
            len++;
        }
        k %= len;
        if (k == 0) return head;
        for (int i = 0; i < k; i++) q = q.next;
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        ListNode dummy = new ListNode();
        dummy.next = p.next;
        p.next = null;
        q.next = head;
        return dummy.next;
    }
}
