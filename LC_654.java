public class LC_654 {
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


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public static TreeNode build(int[] nums, int start, int end) {
        if (start > end) return null;
        int rootIdx = find(nums, start, end);
        TreeNode root = new TreeNode(nums[rootIdx]);
        root.left = build(nums, start, rootIdx - 1);
        root.right = build(nums, rootIdx + 1, end);
        return root;
    }

    public static int find(int[] nums, int start, int end) {
        int maxIdx = start;
        for (int i = start; i <= end; i++)
            if (nums[i] > nums[maxIdx])
                maxIdx = i;
        return maxIdx;
    }
}
