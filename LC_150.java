import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class LC_150 {
    public static void main(String[] args) {
        String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        HashSet<String> set = new HashSet<>();
        set.addAll(Arrays.asList("+", "-", "*", "/"));
        for (String token : tokens) {
            if (set.contains(token)) {
                int num2 = Integer.parseInt(st.pop());
                int num1 = Integer.parseInt(st.pop());
                switch (token) {
                    case ("+"):
                        st.push(Integer.toString(num1 + num2));
                        break;
                    case ("-"):
                        st.push(Integer.toString(num1 - num2));
                        break;
                    case ("*"):
                        st.push(Integer.toString(num1 * num2));
                        break;
                    case ("/"):
                        st.push(Integer.toString(num1 / num2));
                        break;
                }
            } else st.push(token);
        }
        return Integer.parseInt(st.peek());
    }
}
