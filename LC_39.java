import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_39 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target,0);
        return res;
    }

    public static void backTrack(int[] candidates, int tar,int idx) {
        int sum = path.stream().mapToInt(Integer::intValue).sum();
        if (sum > tar) return;
        else if (sum == tar) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            path.add(candidates[i]);
            backTrack(candidates, tar,i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int tar = 7;
        combinationSum(candidates, tar);
        System.out.println(res);
    }
}
