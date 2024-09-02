public class LC_27 {
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[r] != val) nums[l++] = nums[r++];
            else
                while (r < nums.length && nums[r] == val) r++;
        }
        return l ;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }
}
