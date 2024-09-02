import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//超时
public class LC_373 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 7, 11};
        int[] nums2 = new int[]{2, 4, 6};
        int k = 3;
        System.out.println(kSmallestPairs(nums1, nums2, k));

    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> heap = new ArrayList<>();
        for (int v1 : nums1) {
            for (int v2 : nums2) {
                List<Integer> tmp = new ArrayList<>(Arrays.asList(v1, v2));
                heap.add(tmp);
            }
        }
        int n = heap.size();
        for (int i = n / 2; i >= 0; i--) {
            heapify(heap, i, n);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            res.add(heap.get(0));
            swap(heap, 0, n - i);
            heapify(heap, 0, n - i);
        }
        return res;
    }

    public static void heapify(List<List<Integer>> heap, int rootIdx, int n) {
        int leftIdx = rootIdx * 2 + 1;
        int rightIdx = rootIdx * 2 + 2;
        int root = heap.get(rootIdx).stream().mapToInt(Integer::intValue).sum();
        int minIdx = rootIdx;
        if (leftIdx < n) {
            if (sum(heap.get(leftIdx)) < sum(heap.get(minIdx)))
                minIdx = leftIdx;
        }
        if (rightIdx < n) {
            if (sum(heap.get(rightIdx)) < sum(heap.get(minIdx)))
                minIdx = rightIdx;
        }

        if (minIdx != rootIdx) {
            swap(heap, rootIdx, minIdx);
            heapify(heap, minIdx, n);
        }
    }

    public static int sum(List<Integer> list) {
        return list.get(0) + list.get(1);
    }

    public static void swap(List<List<Integer>> list, int idx1, int idx2) {
        List<Integer> tmp1 = list.get(idx1);
        List<Integer> tmp2 = list.get(idx2);
        list.set(idx1, tmp2);
        list.set(idx2, tmp1);
    }
}
