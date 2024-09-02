public class LC_376 {
    public static int wiggleMaxLength(int[] nums) {
        int res = 1;
        int preDiff = 0;
        int nextDiff = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) nextDiff = nums[i] - nums[i - 1];
            if (preDiff <= 0 && nextDiff > 0 || preDiff >= 0 && nextDiff < 0) {
                res++;
                preDiff = nextDiff;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
