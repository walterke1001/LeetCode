import java.util.*;

public class LC_433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        HashSet<String> visited = new HashSet<>();
        Deque<String> que = new LinkedList<>();
        char[] chars = new char[]{'A', 'C', 'G', 'T'};
        if (!set.contains(endGene)) return -1;
        if (startGene.equals(endGene)) return 0;
        que.addLast(startGene);
        visited.add(startGene);
        int step = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                String curStr = que.removeFirst();
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (chars[j] != curStr.charAt(i)) {
                            StringBuilder sb = new StringBuilder(curStr);
                            sb.setCharAt(i, chars[j]);
                            if (!visited.contains(sb.toString()) && set.contains(sb.toString())) {
                                if (endGene.contentEquals(sb)) return step;
                                visited.add(sb.toString());
                                que.addLast(sb.toString());
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
