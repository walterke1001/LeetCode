public class LC_530v2 {
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

    static int minDiff = Integer.MAX_VALUE;
    static int pre = -1;

    public int getMinimumDifference(TreeNode root) {
        preOrder(root);
        return minDiff;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) return;
        preOrder(root.left);
        if (pre != -1)
            minDiff = Math.min(Math.abs(root.val - pre), minDiff);
        pre = root.val;
        preOrder(root.right);
    }
}
