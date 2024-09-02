import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC_257 {
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        traverse(root, path, res);
        return res;
    }

    public static void traverse(TreeNode root, List<Integer> path, List<String> res) {
        if (root == null) return;
        if (root.left == null && root.right == null)
            res.add(buildPath(path));
        path.add(root.val);
        traverse(root.left, path, res);
        traverse(root.right, path, res);
        path.remove(path.size() - 1);
    }

    public static String buildPath(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i != path.size() - 1)
                sb.append("->");
        }
        return sb.toString();
    }


}
