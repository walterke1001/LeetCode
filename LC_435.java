import java.util.Arrays;

public class LC_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        //[1,2],[1,3],[2,3],[3,4]
        int right = Integer.MAX_VALUE;
        int count = 0;
        for (int[] interval : intervals) {
            if (interval[0] < right) {
                right = Math.min(right, interval[1]);
            } else {
                count++;
                right = interval[1];
            }
        }
        count++;
        return intervals.length - count;
    }
}
