import java.util.*;

public class Kama_117 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[n];
        //不能直接用Arrays.fill()
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        int[] indeg = new int[n];
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            graph[s].add(t);
            indeg[t]++;
        }
        //记录入度为0的点
        Deque<Integer> que = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++)
            if (indeg[i] == 0) que.addLast(i);

        ArrayList<Integer> res = new ArrayList<>();
        while (!que.isEmpty()) {
            int cur = que.pollFirst();
            res.add(cur);
            for (Integer next : graph[cur]) {
                indeg[next]--;
                if (indeg[next] == 0) que.addLast(next);
            }
        }
        if (res.size() == n) {
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i));
                if (i != res.size() - 1)
                    System.out.print(" ");
            }
        } else System.out.println(-1);
    }
}
