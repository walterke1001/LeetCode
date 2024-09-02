import java.util.HashMap;

public class LC_106v2 {
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

    static HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode build(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
        if (postStart > postEnd|| inStart > inEnd) return null;
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootInorderIdx = map.get(rootVal);
        int leftSize = rootInorderIdx - inStart;
        root.left = build(postorder, postStart, postStart + leftSize - 1, inorder, inStart, rootInorderIdx - 1);
        root.right = build(postorder, postStart + leftSize, postEnd - 1, inorder, rootInorderIdx + 1, inEnd);
        return root;
    }
}
