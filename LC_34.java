public class LC_34 {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int begin = -1;
        int end = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                begin = mid;
                r = mid - 1;
            } else if (nums[mid] > target)
                r = mid - 1;
            else l = mid + 1;
        }
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                end = mid;
                l = mid + 1;
            } else if (nums[mid] > target)
                r = mid - 1;
            else l = mid + 1;
        }
        return new int[]{begin, end};
    }
}
