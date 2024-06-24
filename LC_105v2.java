import java.util.HashMap;
import java.util.HashSet;

public class LC_105v2 {
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

    public static HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        int rootInorderIdx = map.get(preorder[preStart]);
        int leftSize = rootInorderIdx - inStart;
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootInorderIdx - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, rootInorderIdx + 1, inEnd);
        return root;
    }
}
