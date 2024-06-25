import java.util.ArrayList;

public class LC_129 {
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

    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        preOrder(root);
        int res = 0;
        for (Integer i : list)
            res += i;
        return res;
    }

    public static void preOrder(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            if (sb.length()>0) {
                String tmp = sb.toString();
                System.out.println(tmp);
                list.add(Integer.parseInt(tmp));
                sb.deleteCharAt(sb.length() - 1);
            }
            return;
        }
        sb.append(root.val);
        preOrder(root.left);
        preOrder(root.right);
        if (sb.length()>0) sb.deleteCharAt(sb.length() - 1);
    }
}
