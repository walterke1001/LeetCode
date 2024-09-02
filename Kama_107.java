import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Kama_107 {
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n + 1];
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            graph[num1].add(num2);
            graph[num2].add(num1);
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        visited[start] = true;
        System.out.println(dfs(start, end, graph) ? 1 : 0);
    }

    public static boolean dfs(int start, int end, ArrayList<Integer>[] graph) {
        ArrayList<Integer> nextList = graph[start];
        if (start == end) return true;
        for (Integer next : nextList) {
            if (!visited[next]) {
                visited[next] = true;
                if (dfs(next, end, graph))
                    return true;
            }
        }
        return false;
    }

}
