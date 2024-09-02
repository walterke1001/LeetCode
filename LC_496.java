import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class LC_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums1.length; i++)
            map.put(nums1[i], i);

        st.add(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[st.peek()])
                st.push(i);
            else {
                while (!st.isEmpty() && nums2[i] > nums2[st.peek()]) {
                    if (map.containsKey(nums2[st.peek()]))
                        res[map.get(nums2[st.peek()])] = nums2[i];
                    st.pop();
                }
                st.push(i);
            }
        }
        return res;
    }
}
