import java.util.Arrays;
import java.util.Scanner;

public class PrimDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[][] graph = new int[v + 1][v + 1];
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i],10001);
        }
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            int val = sc.nextInt();
            graph[s][t] = val;
            graph[t][s] = val;
        }

        int[] minDist = new int[v + 1];
        Arrays.fill(minDist, 10001);
        boolean[] isInTree = new boolean[v + 1];
        for (int i = 0; i < v; i++) {
            int cur = -1;
            int minVal = Integer.MAX_VALUE;
            //找出距离生成树最近的点
            for (int j = 1; j <= v; j++) {
                if (!isInTree[j] && minVal > minDist[j]) {
                    minVal = minDist[j];
                    cur = j;
                }
            }
            isInTree[cur] = true;
            //更新
            for (int k = 1; k <= v; k++) {
                if (!isInTree[k] && graph[cur][k] < minDist[k])
                    minDist[k] = graph[cur][k];
            }
        }
        int res = 0;
        for (int i = 2; i <=v; i++) {
            res += minDist[i];
        }
        System.out.println(res);
    }
}
