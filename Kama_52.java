import java.util.Scanner;

public class Kama_52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int bagSize = sc.nextInt();
        int[] weight = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < n; i++) {
            for (int j = weight[i]; j <= bagSize; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + values[i]);
            }
        }
        System.out.println(dp[bagSize]);
    }
}
