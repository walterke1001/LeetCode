public class LC_404 {
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

    static int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        preOrder(root, false);
        return res;
    }

    public static void preOrder(TreeNode root, boolean flag) {
        if (root == null) return;
        if (root.left == null && root.right == null && flag)
            res += root.val;
        preOrder(root.left, true);
        preOrder(root.right, false);
    }
}
