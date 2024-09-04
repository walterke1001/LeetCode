import java.util.ArrayList;

public class LC_459 {
    public boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < next.length; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j))
                j = next[j - 1];
            if (s.charAt(i) == s.charAt(j))
                j++;
            next[i] = j;
        }
        int subLen = s.length() - next[next.length - 1];
        return next[next.length - 1] != 0 && s.length() % subLen == 0;
    }
}
