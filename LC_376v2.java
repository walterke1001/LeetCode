public class LC_376v2 {
    public int wiggleMaxLength(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i])
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                if (nums[j] < nums[i])
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
            }
        }
        return Math.max(dp[dp.length - 1][1], dp[dp.length - 1][0]);
    }
}
