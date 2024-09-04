import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KruskalDemo {
    static class Edge {
        int s;
        int t;
        int val;

        public Edge(int s, int t, int val) {
            this.s = s;
            this.t = t;
            this.val = val;
        }
    }

    public static void init() {
        for (int i = 0; i < f.length; i++) {
            f[i] = i;
        }
    }

    public static void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (v == u) return;
        f[v] = u;
    }

    public static int find(int u) {
        if (u == f[u])
            return u;
        f[u] = find(f[u]);
        return f[u];
    }

    public static boolean isSame(int u, int v) {
        return find(u) == find(v);
    }

    static int[] f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        f = new int[v + 1];
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            int val = sc.nextInt();
            list.add(new Edge(s, t, val));
        }

        list.sort((a, b) -> a.val - b.val);
        init();
        int res = 0;
        for (Edge edge : list) {
            if (!isSame(edge.s, edge.t)) {
                res += edge.val;
                join(edge.s, edge.t);
            }
        }
        System.out.println(res);
    }
}
