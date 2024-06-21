public class LC_86 {
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

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        //第一个大于等于x的节点
        ListNode firstBig = head;
        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                firstBig = p;
                break;
            } else {
                p = p.next;
                pre = pre.next;
            }
        }
        ListNode firstBigPre = pre;
        if (p != null) p = p.next;
        pre = pre.next;
        while (p != null) {
            if (p.val < x) {
                pre.next = p.next;
                p.next = firstBigPre.next;
                firstBigPre.next = p;
                firstBigPre = p;
                p = pre.next;
            } else {
                p = p.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
