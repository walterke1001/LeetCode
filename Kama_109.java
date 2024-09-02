import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
有向树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。该树除了根节点之外的每一个节点都有且只有一个父节点，而根节点没有父节点。有向树拥有 n 个节点和 n - 1 条边。

输入一个有向图，该图由一个有着 n 个节点（节点编号 从 1 到 n），n 条边，请返回一条可以删除的边，使得删除该条边之后该有向图可以被当作一颗有向树。

输入描述

第一行输入一个整数 N，表示有向图中节点和边的个数。

后续 N 行，每行输入两个整数 s 和 t，代表 s 节点有一条连接 t 节点的单向边

输出描述

输出一条可以删除的边，若有多条边可以删除，请输出标准输入中最后出现的一条边。

输入示例

3
1 2
1 3
2 3

输出示例

2 3
* */
public class Kama_109 {
    static int[] f;
    static int n;
    static Scanner sc = new Scanner(System.in);
    static int[][] edges;
    static int[] indeg;

    public static void main(String[] args) {
        n = sc.nextInt();
        f = new int[n + 1];
        edges = new int[n][2];
        indeg = new int[n + 1];
        List<Integer> list = new ArrayList<>(1001);
        //记录边，计算点的入度
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            edges[i] = new int[]{s, t};
            indeg[t]++;
        }
        //记录入度大于1的点的边
        for (int i = n - 1; i >= 0; i--) {
            if (indeg[edges[i][1]] > 1)
                list.add(i);
        }
        if (!list.isEmpty()) {
            if (removeEdge(edges, list.get(0))) {
                System.out.println(edges[list.get(0)][0] + " " + edges[list.get(0)][1]);
                System.exit(0);
            } else {
                System.out.println(edges[list.get(1)][0] + " " + edges[list.get(1)][1]);
                System.exit(0);
            }
            
        }

        func(edges);
    }

    public static boolean removeEdge(int[][] edges, int delIdx) {
        init();
        for (int i = 0; i <n; i++) {
            if (i == delIdx) continue;
            if (isSame(edges[i][0], edges[i][1])) return false;
            join(edges[i][0], edges[i][1]);
        }
        return true;
    }

    public static void func(int[][] edges) {
        init();
        for (int i = 0; i <n; i++) {
            if (isSame(edges[i][0], edges[i][1])) {
                System.out.println(edges[i][0] + " " + edges[i][1]);
                System.exit(0);
            } else {
                join(edges[i][0], edges[i][1]);
            }
        }
    }

    public static void init() {
        for (int i = 0; i < f.length; i++) {
            f[i] = i;
        }
    }

    public static void join(int u, int v) {
        int rootU = f[u];
        int rootV = f[v];
        if (rootU != rootV) f[v] = u;
    }

    public static boolean isSame(int u, int v) {
        return find(u) == find(v);
    }

    public static int find(int u) {
        int rootU = f[u];
        if (rootU == u) return u;
        else f[u] = find(f[u]);
        return f[u];

    }
}
