public class LC_137 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int tmp = 0;
            for (int num : nums)
                tmp += ((num >> i) & 1);
            if (tmp % 3 != 0)
                res |= (1 << i);
        }
        return res;
    }
}
