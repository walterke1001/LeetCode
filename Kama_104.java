import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Kama_104 {
    static int count;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


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

        int num = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count = 1;
                    grid[i][j] = num;
                    dfs(i, j, grid, num);
                    map.put(num++, count);
                }
            }
        }

        int res = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    flag = false;
                    Set<Integer> set = new HashSet<>();
                    int tmp = 1;
                    for (int[] dir : dir) {
                        int nextX = i + dir[0];
                        int nextY = j + dir[1];
                        if (nextX < 0 || nextX > grid.length - 1 || nextY < 0 || nextY > grid[0].length - 1) continue;
                        int key = grid[nextX][nextY];
                        if (set.contains(key)) continue;
                        set.add(key);
                        tmp += map.getOrDefault(key, 0);
                    }
                    res = Math.max(res, tmp);
                }
            }
        }
        System.out.println(flag ? n * m : res);
    }

    public static void dfs(int x, int y, int[][] grid, int num) {
        for (int[] dir : dir) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX < 0 || nextX > grid.length - 1 || nextY < 0 || nextY > grid[0].length - 1) continue;
            if (grid[nextX][nextY] == 1) {
                grid[nextX][nextY] = num;
                count++;
                dfs(nextX, nextY, grid, num);
            }
        }
    }
}
