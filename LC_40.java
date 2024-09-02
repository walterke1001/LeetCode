import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_40 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return res;
    }

    public static void backtrack(int[] nums, int tar, int startIdx) {
        int sum = path.stream().mapToInt(Integer::intValue).sum();
        if (sum == tar) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > tar)
            return;
        for (int i = startIdx; i < nums.length; i++) {
            if (i > startIdx && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtrack(nums, tar, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
