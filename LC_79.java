public class LC_79 {
    static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static boolean[][] visited;
    static boolean flag = false;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && word.charAt(0) == board[i][j]) {
                    visited[i][j] = true;
                    dfs(board, i, j, word, 0);
                    visited[i][j] = false;
                    if (flag) return flag;
                }
            }
        }
        return false;
    }

    public static void dfs(char[][] board, int x, int y, String word, int idx) {
        if (idx == word.length() - 1) {
            flag = true;
            return;
        }
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length) continue;
            if (!visited[nextX][nextY] && board[nextX][nextY] == word.charAt(idx + 1)) {
                visited[nextX][nextY] = true;
                dfs(board, nextX, nextY, word, idx + 1);
                visited[nextX][nextY] = false;
            }
        }
    }
}
