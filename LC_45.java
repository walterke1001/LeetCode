public class LC_45 {
    public static int jump(int[] nums) {
        int cont = 0;
        if (nums.length == 1) return cont;
        int end = nums[0];
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            flag = Math.max(flag, i + nums[i]);
            if (i == end) {
                cont++;
                end = flag;
            }
            if (end >= nums.length - 1) {
                cont++;
                break;
            }
        }
        return cont;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,0,1,4};
        System.out.println(jump(nums));
    }
}
