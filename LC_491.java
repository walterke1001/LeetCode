import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC_491 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    public static void backtrack(int[] nums, int startIdx) {
        if (path.size() >= 2)
            res.add(new ArrayList<>(path));
        if (startIdx == nums.length)
            return;
        HashSet<Integer> set = new HashSet<>();
        for (int i = startIdx; i < nums.length; i++) {
            if (!path.isEmpty())
                if (nums[i] < path.get(path.size() - 1)) continue;
            if (set.contains(nums[i])) continue;

            set.add(nums[i]);
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 4, 3, 2, 1};
        findSubsequences(nums);
        System.out.println(res);
    }
}
