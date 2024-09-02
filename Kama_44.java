import java.util.Scanner;

public class Kama_44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
                sum += matrix[i][j];
            }
        }

        int[][] pre = new int[n + 1][m + 1];
        for (int i = 1; i < pre.length; i++) {
            for (int j = 1; j < pre[0].length; j++) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < pre.length; i++) {
            int part1 = pre[i][pre[0].length - 1];
            int part2 = sum - part1;
            int dif = Math.abs(part2 - part1);
            min = Math.min(min, dif);
        }
        for (int j = 1; j < pre[0].length; j++) {
            int part1 = pre[pre.length - 1][j];
            int part2 = sum - part1;
            int dif = Math.abs(part2 - part1);
            min = Math.min(min, dif);
        }
        System.out.println(min);
    }
}
