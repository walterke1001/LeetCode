import java.util.Arrays;

public class LC_105v3 {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int rootInorderIdx = find(inorder, preorder[0]);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootInorderIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootInorderIdx + 1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, 1 + inLeft.length);
        int[] preRight = Arrays.copyOfRange(preorder, 1 + inLeft.length, preorder.length);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }

    public static int find(int[] nums, int tar) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == tar) return i;
        }
        return -1;
    }
}
