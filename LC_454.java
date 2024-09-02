import java.util.HashMap;
import java.util.Map;

public class LC_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> ab = new HashMap<>();
        HashMap<Integer, Integer> cd = new HashMap<>();

        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                ab.put(sum, ab.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                int sum = i + j;
                cd.put(sum, cd.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : ab.entrySet()) {
            if (cd.containsKey(-entry.getKey()))
                res += entry.getValue() * cd.get(-entry.getKey());
        }
        return res;
    }
}
