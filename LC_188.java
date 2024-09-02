public class LC_188 {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k + 1];

        for (int i = 0; i < dp[0].length; i++)
            if (i % 2 != 0) dp[0][i] = -prices[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0];
            for (int j = 1; j < dp[0].length; j++) {
                if (j % 2 != 0)
                    dp[i][j] = Math.max(dp[i - 1][j - 1] - prices[i], dp[i - 1][j]);
                else
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + prices[i], dp[i - 1][j]);
            }
        }

        return dp[prices.length - 1][2 * k];
    }
}
