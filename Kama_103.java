import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kama_103 {
    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] matrix1;
    static boolean[][] matrix2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        matrix1 = new boolean[n][m];
        matrix2 = new boolean[n][m];

        for (int j = 0; j < m; j++) {
            matrix1[0][j] = true;
            dfs(0, j, grid, matrix1);
            matrix2[n - 1][j] = true;
            dfs(n - 1, j, grid, matrix2);
        }
        for (int i = 0; i < n; i++) {
            matrix1[i][0] = true;
            dfs(i, 0, grid, matrix1);
            matrix2[i][m - 1] = true;
            dfs(i, m - 1, grid, matrix2);
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix1[i][j] && matrix2[i][j]) {
                    System.out.println(i + " " + j);
                }
            }
        }

    }

    public static void dfs(int x, int y, int[][] grid, boolean[][] matrix) {
        for (int[] dir : dir) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX < 0 || nextX > grid.length - 1 || nextY < 0 || nextY > grid[0].length - 1) continue;
            if (!matrix[nextX][nextY] && grid[x][y] <= grid[nextX][nextY]) {
                matrix[nextX][nextY] = true;
                dfs(nextX, nextY, grid, matrix);
            }
        }
    }
}
