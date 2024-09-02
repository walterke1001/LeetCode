import java.util.List;

public class LC_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (i >= word.length()) {
                    if (s.substring(i - word.length(), i).equals(word) && dp[i - word.length()]) {
                        dp[i] = dp[i - word.length()];
                        break;
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }
}
