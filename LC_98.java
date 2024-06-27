import java.util.ArrayList;
import java.util.List;

public class LC_98 {
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
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (!list.isEmpty() && root.val <= list.get(list.size() - 1)) return false;
        else list.add(root.val);
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
