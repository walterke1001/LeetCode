public class LC_153 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[l] <= nums[mid]) {
                //左边单调
                min = Math.min(min, nums[l]);
                l = mid + 1;
            } else {
                //右边单调
                min = Math.min(min, nums[mid]);
                r = mid - 1;
            }
        }
        return min;
    }
}
