import java.util.*;

public class TopoDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] indeg = new int[n];
        List<Integer>[] list = new List[n];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            indeg[t]++;
            list[s].add(t);
        }

        Deque<Integer> que = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0)
                que.addLast(i);
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!que.isEmpty()) {
            int cur = que.pollFirst();
            res.add(cur);
            for (Integer next : list[cur]) {
                indeg[next]--;
                if (indeg[next] == 0) {
                    que.addLast(next);
                }
            }
        }
        if (res.size() == n) {
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i));
                if (i < res.size() - 1)
                    System.out.print(" ");
            }
        } else System.out.println(-1);
    }
}
