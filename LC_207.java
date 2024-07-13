import java.util.*;

public class LC_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //入度
        int[] indeg = new int[numCourses];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int cont = 0;
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] rela : prerequisites) {
            indeg[rela[0]]++;
            list.get(rela[1]).add(rela[0]);
        }
        Deque<Integer> que = new LinkedList<>();
        //先从不需要先修课的课程开始
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0)
                que.addLast(i);
        }
        while (!que.isEmpty()) {
            int u = que.removeFirst();
            cont++;
            //处理以u为先修课的课程
            for (Integer v : list.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0)
                    que.addLast(v);
            }
        }
        return cont == numCourses;
    }

}
