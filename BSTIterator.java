import java.util.ArrayList;
import java.util.Arrays;

public class BSTIterator {
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

    private ArrayList<Integer> list;
    private int cur;

    public BSTIterator(TreeNode root) {
        cur = -1;
        list = new ArrayList<>();
        traverse(root, list);
    }

    public int next() {
        cur++;
        return list.get(cur);
    }

    public boolean hasNext() {
        return cur + 1 < list.size();
    }

    public static void traverse(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
}

