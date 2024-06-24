import java.util.Deque;
import java.util.LinkedList;

public class LC_117 {
    static class Node {
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
        if (root == null) return null;
        Deque<Node> que = new LinkedList<>();
        que.addLast(root);
        while (!que.isEmpty()) {
            int cont = que.size();
            while (cont-- > 0) {
                Node node = que.pollFirst();
                if (node.left != null) que.addLast(node.left);
                if (node.right != null) que.addLast(node.right);
                if (cont == 0) node.next = null;
                else node.next = que.peekFirst();
            }
        }
        return root;
    }
}
