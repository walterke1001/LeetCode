import java.util.Random;

public class LC_162 {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid = l + (r - l) / 2;
        while (!(compare(nums, mid - 1, mid) < 0 && compare(nums, mid, mid + 1) > 0)) {
            if (nums[mid] < nums[mid + 1]) l = mid + 1;
            else r = mid - 1;
            mid = l + (r - l) / 2;
        }
        return mid;
    }

    public static int[] get(int[] nums, int idx) {
        if (idx < 0 || idx >= nums.length) return new int[]{0, 0};
        return new int[]{1, nums[idx]};
    }

    public static int compare(int[] nums, int idx1, int idx2) {
        int[] tmp1 = get(nums, idx1);
        int[] tmp2 = get(nums, idx2);
        if (tmp1[0] != tmp2[0])
            return tmp1[0] > tmp2[0] ? 1 : -1;
        if (tmp1[1] == tmp2[1])
            return 0;
        return tmp1[1] > tmp2[1] ? 1 : -1;
    }
}
