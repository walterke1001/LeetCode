public class LC_200V2 {
    static int[][] move = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static boolean[][] visited;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    res++;
                    dfs(i, j, grid);
                }
            }
        }
        return res;
    }

    public static void dfs(int x, int y, char[][] grid) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + move[i][0];
            int nextY = y + move[i][1];
            if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) continue;
            if (!visited[nextX][nextY] && grid[nextX][nextY] == '1') {
                visited[nextX][nextY] = true;
                dfs(nextX, nextY, grid);
            }
        }
    }
}
