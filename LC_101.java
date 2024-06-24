import java.util.*;

public class LC_101 {
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

    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        que.addLast(root);
        while (!que.isEmpty()) {
            TreeNode u = que.removeLast();
            TreeNode v = que.removeLast();
            if (u == null && v == null) continue;
            if (u == null || v == null || u.val != v.val) return false;
            que.addLast(u.left);
            que.addLast(v.right);
            que.addLast(u.right);
            que.addLast(v.left);
        }
        return true;
    }
}
