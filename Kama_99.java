import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Kama_99 {
    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;

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

        int res = 0;
        visited = new boolean[n][m];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    
    public static void dfs(int[][] grid, int x, int y) {
        for (int[] dir : dir) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX < 0 || nextX > grid.length - 1 || nextY < 0 || nextY > grid[0].length - 1)
                continue;
            if (grid[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                dfs(grid, nextX, nextY);
            }
        }
    }
}

/*
public static void bfs(int[][] grid, int i, int j) {
    Deque<int[]> que = new LinkedList<>();
    que.add(new int[]{i, j});
    while (!que.isEmpty()) {
        int x = que.peekFirst()[0];
        int y = que.peekFirst()[1];
        que.pollFirst();
        for (int[] dir : dir) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX < 0 || nextX > grid.length - 1 || nextY < 0 || nextY > grid[0].length - 1)
                continue;
            if (!visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                visited[nextX][nextY] = true;
                que.add(new int[]{nextX, nextY});
            }
        }
    }
}*/
