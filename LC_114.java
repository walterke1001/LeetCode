public class LC_114 {
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

    public void flatten(TreeNode root) {
        help(root);
    }

    public static void help(TreeNode root) {
        if (root == null) return;
        TreeNode leftChRight = root.left;
        if (leftChRight != null) {
            while (leftChRight.right != null)
                leftChRight = leftChRight.right;
            leftChRight.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        help(root.right);
    }
}
