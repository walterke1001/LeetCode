import java.util.ArrayList;
import java.util.List;

public class LC_131 {
    static List<List<String>> res = new ArrayList<>();
    static List<String> path = new ArrayList<>();

    public static List<List<String>> partition(String s) {
        backtrack(s, 0);
        return res;
    }

    public static void backtrack(String s, int startIdx) {
        if (startIdx == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIdx; i < s.length(); i++) {
            if (!isValid(s.substring(startIdx, i + 1))) continue;
            path.add(s.substring(startIdx, i + 1));
            System.out.println("前 path:" + path);
            backtrack(s, i + 1);
            path.remove(path.size() - 1);
            System.out.println("后 path:" + path);
        }
    }

    public static boolean isValid(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        partition(s);
    }
}
