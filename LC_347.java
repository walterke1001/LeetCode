import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC_347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            que.add(new int[]{entry.getKey(), entry.getValue()});

        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = que.poll()[0];
        return res;
    }
}
