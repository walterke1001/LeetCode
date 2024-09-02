import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC_216 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(n, k, 1);
        return res;
    }

    public static void backtrack(int n, int k, int startIdx) {
        if (path.size() == k) {
            if (path.stream().mapToInt(Integer::intValue).sum() == n)
                res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIdx; i <= 9; i++) {
            path.add(i);
            backtrack(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
