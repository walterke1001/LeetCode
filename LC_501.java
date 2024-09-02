import java.util.*;

public class LC_501 {
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

    static HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        traverse(root);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((entry1, entry2) -> {
            return entry2.getValue() - entry1.getValue();
        });
        List<Integer> resList = new ArrayList<>();
        int last = list.get(0).getValue();
        resList.add(list.get(0).getKey());
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getValue() != last) break;
            resList.add(list.get(i).getKey());
            last = list.get(i).getValue();
        }
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void traverse(TreeNode root) {
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        traverse(root.left);
        traverse(root.right);
    }
}
