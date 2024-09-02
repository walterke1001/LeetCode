public class LC_977 {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[nums.length];
        int idx = r;
        while (l <= r) {
            int num1 = nums[l] * nums[l];
            int num2 = nums[r] * nums[r];
            if (num1 <= num2) {
                res[idx--] = num2;
                r--;
            } else {
                res[idx--] = num1;
                l++;
            }
        }
        return res;
    }
}
