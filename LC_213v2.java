import java.util.Arrays;

public class LC_213v2 {
    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(doRob(nums1), doRob(nums2));
    }

    public static int doRob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp.length; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 2};
        System.out.println(rob(nums));
    }
}
