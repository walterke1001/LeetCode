import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC_17 {
    static List<String> res = new ArrayList<>();
    static StringBuilder path = new StringBuilder();
    static String[] keys = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        backTrack(digits, 0);
        return res;
    }

    public static void backTrack(String digits, int idx) {
        if (idx == digits.length()) {
            res.add(path.toString());
            return;
        }
        String nowKey = keys[digits.charAt(idx) - '0'];
        for (int i = 0; i < nowKey.length(); i++) {
            path.append(nowKey.charAt(i));
            backTrack(digits, idx + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "386459";
        letterCombinations(digits);
        System.out.println(res);
    }
}
