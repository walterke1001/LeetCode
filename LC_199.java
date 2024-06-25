import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC_199 {
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

    static List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public static void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (res.size() <= depth)
            res.add(root.val);
        else res.set(depth, root.val);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
