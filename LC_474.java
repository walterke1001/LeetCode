import java.util.ArrayList;
import java.util.Arrays;

public class LC_474 {
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] tmp = fun(str);
            for (int i = m; i >= tmp[0]; i--) {
                for (int j = n; j >= tmp[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - tmp[0]][j - tmp[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static int[] fun(String str) {
        int zero = 0;
        int one = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') zero++;
            else one++;
        }
        return new int[]{zero, one};
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(findMaxForm(strs, m, n));
    }
}
