public class LC_129v2 {
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


    public int sumNumbers(TreeNode root) {
        return preOrder(root, 0);
    }

    public static int preOrder(TreeNode root, int preSum) {
        if (root == null)
            return 0;
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null)
            return sum;
        else
            return preOrder(root.left, sum) + preOrder(root.right, sum);
    }
}
