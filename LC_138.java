import org.w3c.dom.Node;

import java.util.HashMap;

public class LC_138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        Node p = dummy;
        Node q = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (q != null) {
            p.next = new Node(q.val);
            map.put(q, p.next);
            p = p.next;
            q = q.next;
        }
        p = dummy.next;
        q = head;
        while (p != null) {
            p.random = map.get(q.random);
            p = p.next;
            q = q.next;
        }
        return dummy.next;
    }
}
