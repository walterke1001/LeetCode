import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LC_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Deque<Integer> que = new LinkedList<>();
        int[] indeg = new int[numCourses];
        int cont = 0;
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] rela : prerequisites) {
            indeg[rela[0]]++;
            list.get(rela[1]).add(rela[0]);
        }
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) que.addLast(i);
        }
        while (!que.isEmpty()) {
            int u = que.removeFirst();
            cont++;
            res.add(u);
            for (Integer v : list.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0) que.addLast(v);
            }
        }
        return cont == numCourses ? res.stream().mapToInt(Integer::intValue).toArray() : new int[]{};
    }
}
