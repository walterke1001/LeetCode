import java.util.*;

public class Kama_98 {

    static List<Integer> path = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());


        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
        }
        path.add(1);
        func(1, n, graph);
        if (res.isEmpty()) System.out.println(-1);
        else {
            for (List<Integer> path : res) {
                for (int i = 0; i < path.size() - 1; i++) {
                    System.out.print(path.get(i) + " ");
                }
                System.out.println(path.get(path.size() - 1));
            }
        }
    }

    public static void func(int curNode, int n, List<List<Integer>> graph) {
        if (curNode == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (Integer i : graph.get(curNode)) {
            path.add(i);
            func(i, n, graph);
            path.remove(path.size() - 1);
        }
    }
}
