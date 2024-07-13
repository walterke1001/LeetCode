public class LC_918 {
    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length * 2; i++) {
            dp[i % n] = Math.max(dp[(i - 1) % n] + nums[i % n], nums[i % n]);
            max = Math.max(max, dp[i % n]);
        }
        return max;
    }           

    public static void main(String[] args) {
        int[] nums = new int[]{1, -2, 3, -2};
        System.out.println(maxSubarraySumCircular(nums));
    }
}
