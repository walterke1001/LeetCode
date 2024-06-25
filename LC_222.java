import java.util.Deque;
import java.util.LinkedList;

public class LC_222 {
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

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        int cont = 1;
        while (!que.isEmpty()) {
            TreeNode tmp = que.pollFirst();
            if (tmp.left != null) {
                que.addLast(tmp.left);
                cont++;
            }
            if (tmp.right != null) {
                que.addLast(tmp.right);
                cont++;
            }
        }
        return cont;
    }
}
