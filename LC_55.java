public class LC_55 {
    public static boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int flag = 0;
        int end = nums[0];
        for (int i = 0; i < nums.length; i++) {
            flag = Math.max(flag, i + nums[i]);
            if (i == end) {
                end = flag;
            }
            if (end > nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }
}
