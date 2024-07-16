public class LC_35 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int tar = 0;
        System.out.println(searchInsert(nums, tar));
    }

    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            int cur = nums[mid];
            if (cur < target)
                l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}
