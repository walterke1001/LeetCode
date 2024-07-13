public class LC_215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        //建堆
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(nums, i, n);
        }
        //将堆底元素与堆顶元素交换k-1次
        for (int j = 1; j < k; j++) {
            swap(nums, 0, n - j);
            heapify(nums, 0, n - j);
        }
        //返回堆顶元素
        return nums[0];
    }

    //建大根堆
    public static void heapify(int[] nums, int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && nums[largest] < nums[left])
            largest = left;
        if (right < n && nums[largest] < nums[right])
            largest = right;
        if (i != largest) {
            swap(nums, i, largest);
            heapify(nums, largest, n);
        }
    }

    public static void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}
