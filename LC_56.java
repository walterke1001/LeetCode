import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int l = intervals[0][0];
        int r = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] <= r) {
                r = Math.max(r, interval[1]);
                l = Math.min(l, interval[0]);
            } else {
                res.add(new int[]{l, r});
                l = interval[0];
                r = interval[1];
            }
        }
        res.add(new int[]{l, r});
        return res.toArray(new int[][]{});
    }
}
