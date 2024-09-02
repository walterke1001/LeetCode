import java.util.Arrays;

public class LC_452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 1;
        int right = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] <= right) {
                right = Math.min(right, points[i][1]);
            } else {
                count++;
                right = points[i][1];
            }
        }
        return count;
    }
}
