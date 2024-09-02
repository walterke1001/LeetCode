public class LC_67 {
    public static String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder res = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        int lenA = a.length();
        int lenB = b.length();
        int dif = Math.abs((lenA - lenB));
        while (dif-- > 0) tmp.append(0);
        if (lenA < lenB) {
            tmp.append(a);
            a = tmp.toString();
        } else if (lenA > lenB) {
            tmp.append(b);
            b = tmp.toString();
        }
        int idx = a.length() -1;
        while (idx >= 0) {
            int cA = a.charAt(idx) - '0';
            int cB = b.charAt(idx) - '0';
            int cur = (carry + cA + cB) % 2;
            carry = (carry + cA + cB) / 2;
            res.insert(0, cur);
            idx--;
        }
        if (carry != 0) res.insert(0, 1);
        return res.toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }
}
