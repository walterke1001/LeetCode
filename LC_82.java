import java.util.ArrayDeque;
import java.util.Deque;

public class LC_82 {
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = head;
        ListNode q = head.next;
        while (q != null) {
            if (p.val == q.val) {
                while (q != null && p.val == q.val) q = q.next;
                pre.next = q;
                p = q;
                if (q != null) q = q.next;
            } else {
                pre = pre.next;
                p = p.next;
                q = q.next;
            }
        }
        return dummy.next;
    }
}
