import java.util.ArrayList;

public class LC_28 {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        for (int i = 0; i <= haystack.length() - len; i++) {
            if (haystack.substring(i, i + len).equals(needle)) return i;
        }
        return -1;
    }
}
