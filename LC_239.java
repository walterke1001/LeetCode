import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC_239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> que = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!que.isEmpty() && nums[i] > nums[que.peekLast()])
                que.pollLast();
            que.addLast(i);
        }
        list.add(nums[que.peekFirst()]);

        for (int i = k; i < nums.length; i++) {
            while (!que.isEmpty() && nums[i] > nums[que.peekLast()])
                que.pollLast();
            que.addLast(i);
            if (i - k + 1 > que.peekFirst()) que.pollFirst();
            list.add(nums[que.peekFirst()]);
        }
        System.out.println(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        maxSlidingWindow(nums, k);
    }
}
