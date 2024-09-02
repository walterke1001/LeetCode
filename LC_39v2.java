import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_39v2 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return res;
    }

    public static void backtrack(int[] nums, int tar, int startIdx) {
        if (path.stream().mapToInt(Integer::intValue).sum() == tar) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (path.stream().mapToInt(Integer::intValue).sum() > tar)
            return;
        for (int i = startIdx; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, tar, i);
            path.remove(path.size() - 1);
        }
    }
}
