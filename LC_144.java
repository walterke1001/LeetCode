import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC_144 {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> res = new ArrayList<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode cur = st.pop();
            if (cur == null) continue;
            res.add(cur.val);
            st.push(cur.right);
            st.push(cur.left);
        }
        return res;
    }
}
