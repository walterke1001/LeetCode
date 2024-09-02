import java.util.Scanner;

public class Kama_107v2 {
    static int n;
    static int m;
    static int[] f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        f = new int[n + 1];
        init();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            join(f, u, v);
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        System.out.println(isInSame(start, end) ? 1 : 0);
    }

    public static void init() {
        for (int i = 0; i <= n; i++)
            f[i] = i;
    }

    public static void join(int[] f, int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        f[v] = u;
    }

    public static int find(int u) {
        if (u == f[u])
            return u;
        else {
            f[u] = find(f[u]);
            return f[u];
        }
    }

    public static boolean isInSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }
}
