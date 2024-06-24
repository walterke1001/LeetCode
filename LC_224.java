import java.util.*;

public class LC_224 {
    public static void main(String[] args) {
        String s = "-(1+2)";
        int res = calculate(s);
        System.out.println(res);
    }

    public static int calculate(String s) {
        Deque<String> suf = toSuf(s);
        return calSuf(suf);
    }

    public static Deque<String> toSuf(String s) {
        char[] str = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        Deque<Character> op = new ArrayDeque<>();
        Deque<String> suf = new ArrayDeque<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        int i = 0;
        while (i < str.length) {
            char c = str[i];
            if (c == ' ') {
                i++;
                continue;
            }
            if (c == ')') {
                while (!op.isEmpty() && op.peekLast() != '(') suf.addLast(String.valueOf(op.pollLast()));
                if (!op.isEmpty() && op.peek() == '(') op.pollLast();
            } else if (c == '(') {
                op.addLast(c);
            } else if (map.containsKey(c)) {
                while (!op.isEmpty() && op.peekLast() != '(' && map.get(op.peekLast()) <= map.get(c))
                    suf.addLast(String.valueOf(op.pollLast()));
                op.addLast(c);
            } else {
                //Character.isDigit(c)
                int num = 0;
                while (i < str.length && Character.isDigit(str[i])) {
                    num = num * 10 + (str[i] - '0');
                    i++;
                }
                i--;
                suf.addLast(String.valueOf(c));
            }
            i++;
        }
        while (!op.isEmpty()) {
            if (op.peekLast() != '(') suf.addLast(String.valueOf(op.pollLast()));
            else op.pollLast();
        }

        for (String c : suf) {
            System.out.print(c + ' ');
        }
        System.out.println();

        return suf;
    }

    public static int calSuf(Deque<String> suf) {
        for (String c : suf) {
            System.out.print(c + ' ');
        }
        System.out.println();
        Stack<Integer> st = new Stack<>();
        HashSet<String> set = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        for (String c : suf) {
            if (!set.contains(c)) st.push(Integer.parseInt(c));
            else {
                int num2 = st.pop();
                int num1 = st.pop();
                switch (c) {
                    case "+":
                        st.push(num1 + num2);
                        break;
                    case "-":
                        st.push(num1 - num2);
                        break;
                    case "*":
                        st.push(num1 * num2);
                        break;
                    case "/":
                        st.push(num1 / num2);
                        break;
                }
            }
        }
        return st.peek();
    }
}
