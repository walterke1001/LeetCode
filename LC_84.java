public class LC_84 {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        left[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int t = i - 1;
            while (t >= 0 && heights[t] >= heights[i]) t = left[t];
            left[i] = t;
        }

        right[right.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            int t = i + 1;
            while (t < heights.length && heights[t] >= heights[i]) t = right[t];
            right[i] = t;
        }

        for (int i = 0; i < heights.length; i++) {
            int tmp = heights[i] * (right[i] - left[i]-1);
            res = Math.max(res, tmp);
        }
        return res;
    }
}
