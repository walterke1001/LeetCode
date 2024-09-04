import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kama_53v2 {
    static class edge {
        int s;
        int t;
        int val;

        edge(int s, int t, int val) {
            this.s = s;
            this.t = t;
            this.val = val;
        }
    }

    static int[] f;

    public static void init() {
        for (int i = 0; i < f.length; i++) {
            f[i] = i;
        }
    }

    public static int find(int u) {
        if (f[u] == u) return u;
        f[u] = find(f[u]);
        return f[u];
    }

    public static void join(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootV == rootU) return;
        f[rootV] = rootU;
    }

    public static boolean isSame(int u, int v) {
        return find(u) == find(v);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        f = new int[v + 1];
        List<edge> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            int val = sc.nextInt();
            edges.add(new edge(s, t, val));
        }
        edges.sort((a, b) -> Integer.compare(a.val, b.val));

        init();
        int res = 0;
        for (edge edge : edges) {
            if (!isSame(edge.s, edge.t)) {
                res += edge.val;
                join(edge.s, edge.t);
            }
        }
        System.out.println(res);
    }
}
