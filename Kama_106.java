import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
//岛屿的周长
public class Kama_106 {
    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;
    static int res = 0;
    static Deque<int[]> que = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        visited = new boolean[n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = true;
                    res += func(i, j, grid);
                    bfs(i, j, grid);
                    break;
                }
            }
        }
        System.out.println(res);
    }

    public static void bfs(int x, int y, int[][] grid) {
        que.add(new int[]{x, y});
        while (!que.isEmpty()) {
            int curX = que.peekFirst()[0];
            int curY = que.peekFirst()[1];
            que.pollFirst();
            for (int[] dir : dir) {
                int nextX = curX + dir[0];
                int nextY = curY + dir[1];
                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) continue;
                if (!visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    res += func(nextX, nextY, grid);
                    que.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    public static int func(int x, int y, int[][] grid) {
        int oneNums = 0;
        for (int[] dir : dir) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) continue;
            if (grid[nextX][nextY] == 1) oneNums++;
        }
        switch (oneNums) {
            case 0:
                return 4;
            case 1:
                return 3;
            case 2:
                return 2;
            case 3:
                return 1;
            case 4:
                return 0;
        }
        return 0;
    }
}
