import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC_429v2 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Node> que = new LinkedList<>();
        if (root == null) return res;
        que.add(root);
        while (!que.isEmpty()) {
            int cont = que.size();
            List<Integer> level = new ArrayList<>();
            while (cont-- > 0) {
                Node cur = que.pollFirst();
                if (cur != null)
                    level.add(cur.val);
                List<Node> children = cur.children;
                for (Node child : children)
                    que.addLast(child);
            }
            res.add(level);
        }
        return res;
    }
}
