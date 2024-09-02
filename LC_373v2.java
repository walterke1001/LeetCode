import java.util.*;

public class LC_373v2 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums1.length;
        int m = nums2.length;
        for (int i = 0; i < Math.min(k, n); i++)
            pq.add(new int[]{i, 0});
        for (int i = 1; i <= k && !pq.isEmpty(); i++) {
            int[] poll = pq.poll();
            res.add(new ArrayList<>(Arrays.asList(nums1[poll[0]], nums2[poll[1]])));
            if (poll[1] < m - 1)
                pq.add(new int[]{poll[0], poll[1] + 1});
        }
        return res;
    }
}
