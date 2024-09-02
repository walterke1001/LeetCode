public class LC_541 {
    public static String reverseStr(String s, int k) {
        char[] chArr = s.toCharArray();
        int flag = 0;
        for (int i = 0; i < chArr.length; i++) {
            if ((i + 1) % (2 * k) == 0 ) {
                swap(chArr, i - 2 * k + 1, i - k);
                flag = i + 1;
            }
        }
        int left = s.length() - 2 * k * (s.length() / (2 * k));
        if (left < k)
            swap(chArr, flag, chArr.length - 1);
        else if (left < 2 * k)
            swap(chArr, flag, flag + k - 1);
        return new String(chArr);
    }

    public static void swap(char[] chArr, int start, int end) {
        while (start <= end) {
            char tmp = chArr[start];
            chArr[start] = chArr[end];
            chArr[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String s = "abcde";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }
}
