import java.util.Arrays;

public class LC_279 {
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i * i <= n)
                dp[i * i] = 1;
            for (int j = 1; j < i; j++) {
                dp[i] = Math.min(dp[j] + dp[i - j], dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
}
