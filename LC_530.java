import java.util.ArrayList;
import java.util.List;

public class LC_530 {
    public static class TreeNode {
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

    static int min;
    static int last;

    public int getMinimumDifference(TreeNode root) {
        last = -1;
        min = Integer.MAX_VALUE;
        inorder(root);
        return min;
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (last == -1)
            last = root.val;
        else {
            min = Math.min(min, Math.abs(root.val - last));
            last = root.val;
        }
        inorder(root.right);
    }
}
