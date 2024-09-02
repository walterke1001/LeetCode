public class LC_669 {
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

    static int l;
    static int r;

    public TreeNode trimBST(TreeNode root, int low, int high) {
        l = low;
        r = high;
        return traverse(root);
    }

    public static TreeNode traverse(TreeNode root) {
        if (root == null) return null;
        if (root.val < l) return traverse(root.right);
        if (root.val > r) return traverse(root.left);
        root.left = traverse(root.left);
        root.right = traverse(root.right);
        return root;
    }
}
