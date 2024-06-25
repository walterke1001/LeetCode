public class LC_112 {
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

    static int tar;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        tar = targetSum;
        return help(root, 0);
    }

    public static boolean help(TreeNode root, int curSum) {
        if (root != null) {
            curSum += root.val;
            if (curSum == tar && root.left == null && root.right == null) return true;
            return help(root.left, curSum) || help(root.right, curSum);
        } else return false;
    }
}
