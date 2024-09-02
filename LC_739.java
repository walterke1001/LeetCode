import java.util.Arrays;
import java.util.Stack;

public class LC_739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] <= temperatures[st.peek()])
                st.push(i);
            else {
                while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                    int idx = st.pop();
                    res[idx] = i - idx;
                }
                st.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(nums)));
    }
}
