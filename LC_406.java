import java.util.ArrayList;
import java.util.Arrays;

public class LC_406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });
        ArrayList<int[]> que = new ArrayList<>();
        for (int[] person : people) {
            que.add(person[1], person);
        }
        return que.toArray(new int[people.length][]);
    }
}
