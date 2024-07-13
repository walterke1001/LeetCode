import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LC_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        HashSet<String> visited = new HashSet<>();
        Deque<String> que = new LinkedList<>();
        if (!wordSet.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 1;
        que.addLast(beginWord);
        visited.add(beginWord);
        int len = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            len++;
            while (size-- > 0) {
                String curStr = que.removeFirst();
                for (int i = 0; i < curStr.length(); i++) {
                    for (int j = 0; j < 26; j++) {
                        if (curStr.charAt(i) != (char) ('a' + j)) {
                            StringBuilder sb = new StringBuilder(curStr);
                            sb.setCharAt(i, (char) ('a' + j));
                            if (!visited.contains(sb.toString()) && wordSet.contains(sb.toString())) {
                                if (sb.toString().equals(endWord)) return len;
                                visited.add(sb.toString());
                                que.addLast(sb.toString());
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}
