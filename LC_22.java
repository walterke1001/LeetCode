import java.util.*;
//超时
public class LC_22 {
    static StringBuilder path = new StringBuilder();
    static List<String> res = new ArrayList<>();
    static HashSet<String> set = new HashSet<>();

    public static List<String> generateParenthesis(int n) {
        for (int i = 0; i < n * 2; i++)
            path.append('(');
        backTrack(path, path.length() - 1, 0);
        res = new ArrayList<>(set);
        return res;
    }

    public static void backTrack(StringBuilder path, int idx, int cont) {
        //if (idx == 0) return;
        if (cont == path.length() / 2 && isValid(path)) {
            set.add(path.toString());
            return;
        }
        for (int i = idx; i >= 1; i--) {
            if (path.charAt(i) == ')') continue;
            path.setCharAt(i, ')');
            backTrack(path, idx - 1, cont + 1);
            path.setCharAt(i, '(');
        }
    }

    public static boolean isValid(StringBuilder sb) {
        Stack<Character> st = new Stack<>();
        st.push(sb.charAt(0));
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) == '(')
                st.push('(');
            else {
                if (st.isEmpty() || st.peek() != '(')
                    return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        int n = 8;
        generateParenthesis(n);
        System.out.println(res);
    }


}
