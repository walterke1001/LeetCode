import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC_90 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    public static void backtrack(int[] nums, int startIdx) {
        res.add(new ArrayList<>(path));
        if (startIdx == nums.length)
            return;
        HashSet<Integer> set = new HashSet<>();
        for (int i = startIdx; i < nums.length; i++) {
            if (i > startIdx && set.contains(nums[i])) continue;
            set.add(nums[i]);
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        subsetsWithDup(nums);
        System.out.println(res);
    }
}
