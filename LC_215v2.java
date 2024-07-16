public class LC_215v2 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        for (int i = nums.length / 2; i >= 0; i--) {
            buildHeap(nums, i, n);
        }
        for (int i = 1; i < k; i++) {
            swap(nums, 0, nums.length - i);
            buildHeap(nums, 0,n-i);
        }
        return nums[0];
    }

    public static void buildHeap(int[] nums, int rootIdx,int n) {
        int left = rootIdx * 2 + 1;
        int right = rootIdx * 2 + 2;
        int maxIdx = rootIdx;
        if (left < n)
            if (nums[left] > nums[maxIdx]) maxIdx = left;
        if (right < n)
            if (nums[right] > nums[maxIdx]) maxIdx = right;
        if (maxIdx != rootIdx) {
            swap(nums, rootIdx, maxIdx);
            buildHeap(nums, maxIdx,n);
        }
    }

    public static void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}
