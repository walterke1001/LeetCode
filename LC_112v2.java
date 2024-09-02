public class LC_112v2 {
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

    static boolean res = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        preOrder(root, targetSum, 0);
        return res;
    }

    public static void preOrder(TreeNode root, int tar, int curSum) {
        if (root == null || res) return;
        curSum += root.val;
        if (curSum == tar && root.left == null && root.right == null) {
            res = true;
            return;
        }
        preOrder(root.left, tar, curSum);
        preOrder(root.right, tar, curSum);
    }
}
