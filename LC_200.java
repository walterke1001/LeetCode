import java.util.Deque;
import java.util.LinkedList;

public class LC_200 {
    static int[][] move = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static boolean[][] visited;
    static int res = 0;
    static Deque<int[]> que = new LinkedList<>();

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = true;
                if (!visited[i][j] && grid[i][j] == '1') {
                    que.addLast(new int[]{i, j});
                    res++;
                    bfs(grid);
                }
            }
        }
        return res;
    }

    public static void bfs(char[][] grid) {
        while (!que.isEmpty()) {
            int x = que.peekFirst()[0];
            int y = que.peekFirst()[1];
            que.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextX = x + move[i][0];
                int nextY = y + move[i][1];
                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) continue;
                if (grid[nextX][nextY] == '1' && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    que.addLast(new int[]{nextX, nextY});
                }
            }
        }
    }
}
