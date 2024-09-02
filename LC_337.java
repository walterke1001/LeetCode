public class LC_337 {
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

    public int rob(TreeNode root) {
        int[] dp = doRob(root);
        return Math.max(dp[0], dp[1]);
    }

    public static int[] doRob(TreeNode root) {
        int[] dp = new int[2];
        if (root == null) return dp;

        int[] left = doRob(root.left);
        int[] right = doRob(root.right);

        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = root.val + left[0] + right[0];
        return dp;
    }
}
