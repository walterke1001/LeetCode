import java.util.Arrays;

public class LC_455 {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        boolean[] used = new boolean[s.length];
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (s[j] >= g[i] && !used[j]) {
                    used[j] = true;
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1, 2};
        int[] s = new int[]{1, 2,3};
        System.out.println(findContentChildren(g, s));
    }
}
