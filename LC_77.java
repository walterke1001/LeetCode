import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC_77 {
    static List<Integer> path = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        backTrack(n, k, 1);
        return res;
    }

    public static void backTrack(int n, int k, int idx) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i <= n; i++) {
            path.add(i);
            backTrack(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        combine(4, 2);
        System.out.println(res);
    }
}
