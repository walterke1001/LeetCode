

import java.util.ArrayList;
import java.util.List;

public class LC_98v2 {
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

    static List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1))
                return false;
        }
        return true;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
