public class LC_701 {
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

    static TreeNode pre = null;

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            if (pre == null) return new TreeNode(val);
            if (val > pre.val) {
                pre.right = new TreeNode(val);
            } else if (val < pre.val) {
                pre.left = new TreeNode(val);
            }
            return null;
        }
        pre = root;
        if (val > root.val) insertIntoBST(root.right, val);
        if (val < root.val) insertIntoBST(root.left, val);
        return root;
    }
}
