public class LC_738 {
    public static int monotoneIncreasingDigits(int n) {
        String s = Integer.toString(n);
        StringBuilder sb = new StringBuilder(s);
        int flag = s.length();
        for (int i = sb.length() - 1; i > 0; i--) {
            char l = sb.charAt(i - 1);
            char r = sb.charAt(i);
            if (r - l < 0) {
                sb.setCharAt(i - 1, (char) (l - 1));
                flag = i;
            }
        }
        for (int i = sb.length() - 1; i >= flag; i--) {
            sb.setCharAt(i, '9');
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(332));
    }
}
