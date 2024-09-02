import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC_47 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    static boolean[] used;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        func(nums);
        return res;
    }

    public static void func(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!used[i] && !hs.contains(nums[i])) {
                used[i] = true;
                hs.add(nums[i]);
                path.add(nums[i]);
                func(nums);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }   
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};
        permuteUnique(nums);
        System.out.println(res);
    }
}
