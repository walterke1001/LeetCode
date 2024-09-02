import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> que1;
    Queue<Integer> que2;

    public MyStack() {
        que1 = new LinkedList<>();
        que2 = new LinkedList<>();
    }

    public void push(int x) {
        que1.add(x);
    }

    public int pop() {
        while (que1.size() > 1) que2.add(que1.poll());
        int tmp = que1.poll();
        dumpTo1();
        return tmp;
    }

    public int top() {
        while (que1.size() > 1) que2.add(que1.poll());
        int tmp = que1.poll();
        que2.add(tmp);
        dumpTo1();
        return tmp;
    }

    public boolean empty() {
        return que1.isEmpty();
    }

    public void dumpTo1() {
        while (!que2.isEmpty())
            que1.add(que2.poll());
    }

}
