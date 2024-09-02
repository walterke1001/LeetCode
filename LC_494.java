import java.util.Arrays;

public class LC_494 {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum < Math.abs(target)) return 0;
        if ((target + sum) % 2 != 0) return 0;

        int tar = (target + sum) / 2;
        int[] dp = new int[tar + 1];
        dp[0] = 1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = tar; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[tar];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }
}
