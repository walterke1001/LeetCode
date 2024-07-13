import java.util.List;

public class LC_23 {
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1)
            return lists[0];
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        ListNode p1 = lists[0];
        ListNode p2 = lists[1];
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;

        }
        if (p1 == null) p.next = p2;
        else p.next = p1;
        for (int i = 2; i < lists.length; i++) {
            if (lists[i] == null) continue;
            ListNode dummy1 = new ListNode();
            ListNode cur = dummy1;
            ListNode p3 = dummy.next;
            ListNode p4 = lists[i];
            while (p4 != null && p3 != null) {
                if (p3.val < p4.val) {
                    cur.next = p3;
                    p3 = p3.next;
                } else {
                    cur.next = p4;
                    p4 = p4.next;
                }
                cur = cur.next;
            }
            if (p3 == null) cur.next = p4;
            else cur.next = p3;
            dummy = dummy1;
        }
        return dummy.next;
    }
}
