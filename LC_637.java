import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC_637 {
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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();
        if (root == null) return res;
        que.addLast(root);
        while (!que.isEmpty()) {
            int size = que.size();
            int cont = size;
            long sum = 0;
            while (size-- > 0) {
                TreeNode node = que.pollFirst();
                if (node != null) {
                    sum += node.val;
                    if (node.left != null) que.addLast(node.left);
                    if (node.right != null) que.addLast(node.right);
                }
            }
            res.add((double) sum / cont);
        }
        return res;
    }
}
