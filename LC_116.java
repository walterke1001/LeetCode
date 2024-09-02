import java.util.Deque;
import java.util.LinkedList;

public class LC_116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        Deque<Node> que = new LinkedList<>();
        if (root == null) return root;
        que.addLast(root);
        while (!que.isEmpty()) {
            int cont = que.size();
            while (cont-- > 0) {
                Node cur = que.pollFirst();
                if (cur.left != null) que.addLast(cur.left);
                if (cur.right != null) que.addLast(cur.right);
                cur.next = cont == 0 ? null : que.peekFirst();
            }
        }
        return root;
    }
}
