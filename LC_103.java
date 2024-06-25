import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC_103 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> que = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        que.addLast(root);
        int level = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> path = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = que.pollFirst();
                if (node != null) {
                    path.add(node.val);
                    if (node.left != null) que.addLast(node.left);
                    if (node.right != null) que.addLast(node.right);
                }
            }
            if (level++ % 2 == 0) res.add(new ArrayList<>(path));
            else res.add(reverse(path));
        }
        return res;
    }

    public static List<Integer> reverse(List<Integer> path) {
        List<Integer> list = new ArrayList<>();
        for (int i = path.size() - 1; i >= 0; i--)
            list.add(path.get(i));
        return list;
    }
}
