import java.util.Arrays;

public class LC_105 {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder);
    }
    //该方法时间复杂度比较大
    public static TreeNode build(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        int rootVal = preorder[0];
        int rootInorderIdx = findRootInorderIdx(rootVal, inorder);
        TreeNode root = new TreeNode(rootVal);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootInorderIdx);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootInorderIdx + 1, inorder.length);
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, 1 + inorderLeft.length);
        int[] preorderRight = Arrays.copyOfRange(preorder, 1 + inorderLeft.length, preorder.length);
        root.left = build(preorderLeft, inorderLeft);
        root.right = build(preorderRight, inorderRight);
        return root;
    }

    public static int findRootInorderIdx(int val, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) return i;
        }
        return -1;
    }

}
