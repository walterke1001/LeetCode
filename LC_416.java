import java.util.ArrayList;
import java.util.Arrays;

public class LC_416 {
    static boolean flag = false;
    static ArrayList<Integer> path = new ArrayList<>();

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;
        Arrays.sort(nums);
        int tar = sum / 2;
        backtrack(nums, tar, 0);
        return flag;
    }

    public static void backtrack(int[] nums, int tar, int startIdx) {
        if (path.stream().mapToInt(Integer::intValue).sum() == tar) {
            flag = true;
            return;
        }
        for (int i = startIdx; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, tar, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,5};
        System.out.println(canPartition(nums));
    }
}
