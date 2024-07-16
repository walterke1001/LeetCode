public class LC_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        boolean flag = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) {
                row = i - 1;
                flag = true;
                break;
            }
        }
        if (row < 0)
            return false;
        if (!flag)
            row = matrix.length - 1;
        int[] nums = matrix[row];
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}
