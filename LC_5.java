public class LC_5 {
    public static String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        if (maxLen < j - i + 1) {
                            maxLen = j - i + 1;
                            start = i;
                        }
                    } else if (dp[i + 1][j - 1]) {
                        if (maxLen < j - i + 1) {
                            maxLen = j - i + 1;
                            start = i;
                        }
                        dp[i][j] = true;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
