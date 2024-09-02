import java.util.Scanner;

public class Kama_100 {
    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;
    static int count;

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

        visited = new boolean[n][m];

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) {
                visited[i][0] = true;
                dfs(grid, i, 0, false);
            }
            if (grid[i][grid[0].length - 1] == 1 && !visited[i][grid[0].length - 1]) {
                visited[i][grid[0].length - 1] = true;
                dfs(grid, i, grid[0].length - 1, false);
            }
        }
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[0][j] == 1 && !visited[0][j]) {
                visited[0][j] = true;
                dfs(grid, 0, j, false);
            }
            if (grid[grid.length - 1][j] == 1 && !visited[grid.length - 1][j]) {
                visited[grid.length - 1][j] = true;
                dfs(grid, grid.length - 1, j, false);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = true;
                    count++;
                    dfs(grid, i, j, true);
                }
            }
        }

        System.out.println(count);
    }


    public static void dfs(int[][] grid, int x, int y, boolean flag) {
        for (int[] dir : dir) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX < 0 || nextX > grid.length - 1 || nextY < 0 || nextY > grid[0].length - 1)
                continue;
            if (grid[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                if (flag) count++;
                dfs(grid, nextX, nextY, flag);
            }
        }
    }
}

