import java.util.Arrays;

public class LC_1005 {
    public static int largestSumAfterKNegations(int[] nums, int k) {
        int[] sorted = Arrays
                .stream(nums)
                .boxed()
                .sorted((a, b) -> Math.abs(b) - Math.abs(a))
                .mapToInt(Integer::intValue)
                .toArray();
        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] < 0&&k>0) {
                sorted[i] = -sorted[i];
                k--;
            }
        }
        if (k > 0)
            if (k % 2 == 1) sorted[sorted.length - 1] = -sorted[sorted.length - 1];
        return Arrays.stream(sorted).sum();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-8, 3, -5, -3, -5, -2};
        int k = 6;
        System.out.println(largestSumAfterKNegations(nums, k));
    }
}
