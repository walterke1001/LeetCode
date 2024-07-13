public class LC_130 {
    static int[][] move = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static boolean[][] visited;

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        if (m < 3 || n < 3) return;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                visited[i][0] = true;
                dfs(i, 0, board);
            }
            if (board[i][n - 1] == 'O') {
                visited[i][n - 1] = true;
                dfs(i, n - 1, board);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                visited[0][j] = true;
                dfs(0, j, board);
            }
            if (board[m - 1][j] == 'O') {
                visited[m - 1][j] = true;
                dfs(m - 1, j, board);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    public static void dfs(int x, int y, char[][] board) {
        board[x][y] = 'A';
        for (int[] dir : move) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX < 0 || nextX > board.length - 1 || nextY < 0 || nextY > board[0].length - 1) continue;
            if (!visited[nextX][nextY] && board[nextX][nextY] == 'O') {
                visited[nextX][nextY] = true;
                dfs(nextX, nextY, board);
            }
        }
    }
}
