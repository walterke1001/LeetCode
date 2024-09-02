public class LC_160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = len(headA);
        int lenB = len(headB);
        int dif = Math.abs(lenA - lenB);
        ListNode pA = headA;
        ListNode pB = headB;
        if (lenA > lenB)
            while (dif-- > 0) pA = pA.next;
        if (lenA < lenB)
            while (dif-- > 0) pB = pB.next;
        while (pA != null && pB != null) {
            if (pA == pB) return pA;
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }

    public static int len(ListNode head) {
        int res = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            res++;
        }
        return res;
    }
}
