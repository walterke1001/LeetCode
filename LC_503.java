import java.util.Arrays;
import java.util.Stack;

public class LC_503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        st.add(0);
        for (int i = 1; i < nums.length * 2; i++) {
            if (nums[i % nums.length] <= nums[st.peek()])
                st.push(i % nums.length);
            else {
                while (!st.isEmpty() && nums[i % nums.length] > nums[st.peek()]) {
                    int idx = st.pop();
                    res[idx] = nums[i % nums.length];
                }
                st.push(i % nums.length);
            }
        }
        return res;
    }
}
