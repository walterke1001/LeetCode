import java.util.ArrayList;
import java.util.List;

public class LC_93 {
    static List<String> res = new ArrayList<>();
    static StringBuilder path;

    public static List<String> restoreIpAddresses(String s) {
        path = new StringBuilder(s);
        backtrack(0, 0);
        return res;
    }

    public static void backtrack(int idx, int pointCont) {
        if (pointCont == 3) {
            if (isValid(path))
                res.add(path.toString());
            return;
        }
        for (int i = idx; i < path.length(); i++) {
            path.insert(i + 1, '.');
            backtrack(i + 2, pointCont + 1);
            path.deleteCharAt(i + 1);
        }
    }

    public static boolean isValid(StringBuilder sb) {
        String[] strs = sb.toString().split("\\.");
        if (strs.length < 4) return false;
        for (String str : strs) {
            if (str.isEmpty() || str.length() > 3)
                return false;
            if (str.length() > 1 && str.startsWith("0"))
                return false;
            if (Integer.parseInt(str) > 255)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "101023";
        System.out.println(restoreIpAddresses(s));
    }
}
