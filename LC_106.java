import java.util.HashMap;

public class LC_106 {
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

    static HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        int len = inorder.length;
        return build(inorder, 0, len - 1, postorder, 0, len - 1);
    }

    public static TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd|| inStart > inEnd) return null;
        int rootInorderIdx = map.get(postorder[postEnd]);
        int rightSize = inEnd - rootInorderIdx;
        TreeNode root = new TreeNode(postorder[postEnd]);
        root.left = build(inorder, inStart, rootInorderIdx - 1, postorder, postStart, postEnd - rightSize-1);
        root.right = build(inorder, rootInorderIdx + 1, inEnd, postorder, postEnd - rightSize , postEnd-1);
        return root;
    }
}
