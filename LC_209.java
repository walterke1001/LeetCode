import java.util.Arrays;

public class LC_209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum < target) return 0;
        int l = 0;
        int r = 0;
        sum = 0;
        int res = Integer.MAX_VALUE;
        while (r < nums.length && l <= r) {
            sum += nums[r];
            if (sum < target) r++;
            else {
                while (sum >= target) {
                    res = Math.min(res, r - l + 1);
                    sum -= nums[l++];
                }
                r++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int tar = 1;
        int[] nums = new int[]{1,4,4};
        System.out.println(minSubArrayLen(tar, nums));
    }
}
