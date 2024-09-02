import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LC_763 {
    public static List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        int flag = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            len++;
            char ch = s.charAt(i);
            flag = Math.max(flag, map.get(ch));
            if (i >= flag) {
                res.add(len);
                len = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
}

