import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kama_105 {
    static boolean[] visited;

    public static void main(String[] args) {
        System.out.println(func());
    }
    public static int func() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        visited = new boolean[n + 1];
        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < k; i++) {
            graph[sc.nextInt()].add(sc.nextInt());
        }
        visited[0] = true;
        visited[1] = true;
        dfs(1,graph);
        for (boolean v : visited) {
            if (!v) {
                return -1;
            }
        }
        return 1;
    }

    public static boolean dfs(int cur, List<Integer>[] graph) {
        List<Integer> curNext = graph[cur];
        for (Integer next : curNext) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, graph);
            }
        }
        return false;
    }
}
