import java.util.LinkedList;
import java.util.Stack;
public class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>(); 
        minSt = new Stack<>();
        minSt.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        st.push(val);
        minSt.push(Math.min(minSt.peek(), val));
    }

    public void pop() {
        st.pop();
        minSt.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }
}
