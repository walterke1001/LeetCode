public class LC_101v3 {
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
        return func(root, root);
    }

    public static boolean func(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null) return false;
        else if (right == null) return false;
        else if (left.val != right.val) return false;
        return func(left.right, right.left) && func(left.left, right.right);
    }
}
