import java.util.Stack;

public class LC_42 {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        st.add(0);
        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[st.peek()])
                st.push(i);
            else if (height[st.peek()] == height[i]) {
                st.pop();
                st.push(i);
            } else {
                while (!st.isEmpty() && height[i] > height[st.peek()] && st.size() >= 2) {
                    int midIdx = st.pop();
                    int leftIdx = st.peek();
                    int h = Math.min(height[i], height[leftIdx]) - height[midIdx];
                    int tmp = h * (i - leftIdx - 1);
                    if (tmp > 0) res += tmp;
                }
                st.push(i);
            }
        }
        return res;
    }
}
