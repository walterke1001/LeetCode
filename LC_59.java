public class LC_59 {
    public int[][] generateMatrix(int n) {
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIdx = 0;
        int num = 1;
        int cont = 1;
        int[][] res = new int[n][n];
        res[0][0] = num++;
        int x = 0, y = 0;
        while (cont < n * n) {
            int testX = x + dir[dirIdx][0];
            int testY = y + dir[dirIdx][1];
            if (testX < 0 || testX >= n || testY < 0 || testY >= n || res[testX][testY] != 0) {
                dirIdx = (dirIdx + 1) % 4;
            }
            x = x + dir[dirIdx][0];
            y = y + dir[dirIdx][1];
            res[x][y] = num++;
            cont++;
        }
        return res;
    }
}
