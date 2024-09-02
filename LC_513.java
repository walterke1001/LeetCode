import java.util.Deque;
import java.util.LinkedList;

public class LC_513 {
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


    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        int res = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            res = que.peekFirst().val;
            while (size-- > 0) {
                TreeNode cur = que.pollFirst();
                if (cur.left != null) que.addLast(cur.left);
                if (cur.right != null) que.addLast(cur.right);
            }
        }
        return res;
    }
}
