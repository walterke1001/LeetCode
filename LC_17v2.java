import java.util.ArrayList;
import java.util.List;

public class LC_17v2 {
    static String[] keys = new String[]{
            "",
            "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"};
    static List<String> res = new ArrayList<>();
    static StringBuilder path = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        backtrack(digits, 0);
        return res;
    }

    public static void backtrack(String digits, int idx) {
        if (idx == digits.length()) {
            res.add(path.toString());
            return;
        }

        String nowKey = keys[digits.charAt(idx) - '0'];
        for (int i = 0; i < nowKey.length(); i++) {
            path.append(nowKey.charAt(i));
            backtrack(digits, idx + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
