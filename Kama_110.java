import java.lang.reflect.Array;
import java.util.*;
//字符串接龙
public class Kama_110 {
    public static void main(String[] args) {
        System.out.println(func());
    }

    public static int func() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String beginStr = sc.next();
        String endStr = sc.next();
        sc.nextLine();
        String[] list = new String[n];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextLine();
        }
        //System.out.println(Arrays.toString(list));
        if (beginStr.equals(endStr)) {
            return 1;
        }

        HashSet<String> wordList = new HashSet<>(Arrays.asList(list));
        HashSet<String> visited = new HashSet<>();
        Deque<String> que = new LinkedList<>();

//        if (!wordList.contains(endStr)) {
//            System.out.println(-1);
//            System.exit(1);
//        }

        que.addLast(beginStr);
        int res = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            res++;
            while (size-- > 0) {
                String cur = que.pollFirst();
                visited.add(cur);
                for (int i = 0; i < cur.length(); i++) {
                    StringBuilder curSb = new StringBuilder(cur);
                    for (int j = 0; j < 26; j++) {
                        curSb.setCharAt(i, (char) ('a' + j));
                        if (endStr.equals(curSb.toString())) {
                            return res;
                        }
                        if (wordList.contains(curSb.toString()) && !visited.contains(curSb.toString())) {
                            que.addLast(curSb.toString());
                        }
                    }
                }
            }
        }
        return -1;
    }
}
