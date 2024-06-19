import java.lang.reflect.Array;
import java.util.*;

public class LC_224 {
    public static void main(String[] args) {
        String s = "1-(     -2)";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        Stack<String> op = new Stack<>();
        Stack<String> res = new Stack<>();
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("*", 3);
        map.put("/", 3);
        map.put("+", 2);
        map.put("-", 2);
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i, i + 1);
            if (" ".equals(sub)) continue;
            //是括号
            if (sub.equals("(")||sub.equals(")")) {
                if (")".equals(sub)) {
                    while (!op.isEmpty() && !"(".equals(op.peek())) list.add(op.pop());
                    if (!op.isEmpty() && op.peek().equals("(")) op.pop();
                }else {
                    op.push(sub);
                }
            } else if(map.containsKey(sub)){
                //是操作符
                while (!op.isEmpty() &&!"(".equals(op.peek())&& map.get(sub) <= map.get(op.peek()))
                    list.add(op.pop());
                op.push(sub);
            }else{
                //是数字
                StringBuilder sb = new StringBuilder();
                while (i<s.length()&&Character.isDigit(s.charAt(i))){
                    sb.append(s.charAt(i++));
                }
                i--;
                list.add(sb.toString());
            }
        }
        list.addAll(op);

        for (String str : list) {
            if (map.containsKey(str)) {
                int num2 = Integer.parseInt(res.pop());
                int num1 = Integer.parseInt(res.pop());
                switch (str) {
                    case "+" -> res.push(Integer.toString(num1 + num2));
                    case "-" -> res.push(Integer.toString(num1 - num2));
                    case "*" -> res.push(Integer.toString(num1 * num2));
                    case "/" -> res.push(Integer.toString(num1 / num2));
                }
            } else res.push(str);
        }
        return Integer.parseInt(res.pop());
    }
}
