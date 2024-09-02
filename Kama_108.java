import java.util.Scanner;

/*

题目描述

树可以看成是一个图（拥有 n 个节点和 n - 1 条边的连通无环无向图）。 


现给定一个拥有 n 个节点（节点标号是从 1 到 n）和 n 条边的连通无向图，请找出一条可以删除的边，删除后图可以变成一棵树。
输入描述

第一行包含一个整数 N，表示图的节点个数和边的个数。

后续 N 行，每行包含两个整数 s 和 t，表示图中 s 和 t 之间有一条边。
输出描述
输出一条可以删除的边。如果有多个答案，请删除标准输入中最后出现的那条边。
输入示例

3
1 2
2 3
1 3

输出示例

1 3


* */
public class Kama_108 {
    static Scanner sc = new Scanner(System.in);
    static int[] f;
    static int n;

    public static void main(String[] args) {
        n = sc.nextInt();
        init();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            if (isSame(s, t)) {
                System.out.println(s + " " + t);
//                System.exit(0);
                return;
            } else join(s, t);
        }

    }

    public static void init() {
        f = new int[n + 1];
        for (int i = 0; i < f.length; i++) {
            f[i] = i;
        }
    }

    public static int find(int u) {
        int root = f[u];
        if (u == root) return u;
        else {
            f[u] = find(f[u]);
        }
        return f[u];
    }

    public static boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    public static void join(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) f[v] = u;
    }
}
