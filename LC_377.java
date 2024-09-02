import java.util.ArrayList;
import java.util.Arrays;

public class LC_377 {
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int tar = 4;
        System.out.println(combinationSum4(nums, tar));
    }
}

