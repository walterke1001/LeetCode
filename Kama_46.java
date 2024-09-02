    import java.util.Arrays;
    import java.util.Scanner;
    
    public class Kama_46 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
    
            int m = sc.nextInt();
            int n = sc.nextInt();
    
            int[] nums = new int[m];
            int[] values = new int[m];
            for (int i = 0; i < m; i++)
                nums[i] = sc.nextInt();
            for (int i = 0; i < m; i++)
                values[i] = sc.nextInt();
    
    //        System.out.println("nums:" + Arrays.toString(nums));
    //        System.out.println("values:" + Arrays.toString(values));
    
            int[][] dp = new int[m][n + 1];
            for (int i = 0; i < dp.length; i++)
                dp[i][0] = 0;
            for (int j = 0; j < dp[0].length; j++)
                dp[0][j] = j >= nums[0] ? values[0] : 0;
    
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j <= n; j++) {
                    if (j >= nums[i])
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + values[i]);
                    else dp[i][j] = dp[i - 1][j];
                }
            }
    
    //        for (int i = 0; i < dp.length; i++) {
    //            for (int j = 0; j < dp[0].length; j++) {
    //                System.out.print(dp[i][j] + " ");
    //            }
    //            System.out.println();
    //        }
    
            System.out.println(dp[dp.length - 1][dp[0].length - 1]);
        }
    }
