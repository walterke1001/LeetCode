import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_77v2 {
    static ArrayList<Integer> path = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 0);
        return res;
    }

    public static void backtrack(int n, int k, int startIdx) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIdx; i < n; i++) {
            path.add(i);
            backtrack(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
