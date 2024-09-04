import java.util.ArrayList;

public class LC_28 {
    public static int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j))
                j = next[j - 1];
            if (haystack.charAt(i) == needle.charAt(j))
                j++;
            if (j >= next.length) return i - next.length + 1;
        }
        return -1;
    }

    public static void getNext(int[] next, String str) {
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j))
                j = next[j - 1];
            if (str.charAt(i) == str.charAt(j))
                j++;
            next[i] = j;
        }
    }

    public static void main(String[] args) {
        String str1 = "leetcode";
        String str2 = "leeto";
        System.out.println(strStr(str1, str2));
    }
}
