import java.util.Arrays;

public class LC_1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int tar = sum / 2;
        int[] dp = new int[tar + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = tar; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[dp.length - 1];
    }
}
