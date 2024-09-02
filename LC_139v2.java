import java.util.List;

public class LC_139v2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len) {
                    String sub = s.substring(i - len, i);
                    if (sub.equals(word) && dp[i - len])
                        dp[i] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
