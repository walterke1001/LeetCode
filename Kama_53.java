import java.util.Arrays;
import java.util.Scanner;

public class Kama_53 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[][] graph = new int[v + 1][v + 1];
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], 100001);
        }
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            int val = sc.nextInt();
            graph[s][t] = val;
            graph[t][s] = val;
        }

        int[] minDist = new int[v + 1];
        Arrays.fill(minDist, 100001);
        boolean[] isInTree = new boolean[v + 1];
        //prim 算法主循环
        for (int i = 1; i < v; i++) {
            int cur = -1;
            int minVal = Integer.MAX_VALUE;
            //选择距离生成树最近的点
            for (int j = 1; j <= v; j++) {
                if (!isInTree[j] && minDist[j] < minVal) {
                    minVal = minDist[j];
                    cur = j;
                }
            }
            //将最近节点加入生成树
            isInTree[cur] = true;
            //更新非生成树其他结点到生成树的举例
            for (int j = 1; j <= v; j++) {
                if (!isInTree[j] && graph[cur][j] < minDist[j])
                    minDist[j] = graph[cur][j];
            }
        }
        int res = 0;
        for (int i = 2; i <= v; i++) {
            res += minDist[i];
        }
        System.out.println(res);
    }
}
