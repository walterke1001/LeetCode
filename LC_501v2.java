import java.util.ArrayList;
import java.util.List;

public class LC_501v2 {
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

    static int cont = 0;
    static int maxCont = 0;
    static TreeNode pre = null;
    static List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        find(root);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void find(TreeNode root) {
        if (root == null) return;
        find(root.left);
        if (pre == null || root.val != pre.val) {
            cont = 1;
        } else {
            cont++;
        }
        if (cont > maxCont) {
            maxCont = cont;
            list.clear();
            list.add(root.val);
        } else if (cont == maxCont) 
            list.add(root.val);
        pre = root;
        find(root.right);
    }
}
