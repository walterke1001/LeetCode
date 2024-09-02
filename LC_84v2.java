import java.util.Stack;

public class LC_84v2 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int[] newHeight = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeight, 1, heights.length);
        newHeight[0] = 0;
        newHeight[newHeight.length - 1] = 0;
        st.push(0);
        int res = 0;
        for (int i = 1; i < newHeight.length; i++) {
            if (newHeight[i] > newHeight[st.peek()])
                st.push(i);
            else if (newHeight[i] == newHeight[st.peek()]) {
                st.pop();
                st.push(i);
            } else {
                while (!st.isEmpty() && newHeight[i] < newHeight[st.peek()]) {
                    int h = newHeight[st.pop()];
                    int leftIdx = st.peek();
                    res = Math.max(res, (i - leftIdx - 1) * h);
                }
                st.push(i);
            }
        }
        return res;
    }
}
