import java.util.ArrayList;
import java.util.List;

public class LC_46 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    static boolean[] used;

    public static List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backTrack(nums);
        return res;
    }

    public static void backTrack(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backTrack(nums);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        permute(nums);
        System.out.println(res);
    }
}
