import java.util.Stack;

public class LC_230 {
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

    static int idx = 0;
    static int res = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    public static void inorder(TreeNode root, int k) {
        if (root == null) return;
        inorder(root.left, k);
        idx++;
        if (idx == k) {
            res = root.val;
            return;
        }
        inorder(root.right, k);
    }
}
