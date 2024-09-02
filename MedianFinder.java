import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        right = new PriorityQueue<>((o1, o2) -> o1 - o2);
    }

    public void addNum(int num) {
        if (left.size() == right.size()) {
            left.add(num);
            right.add(left.poll());
        } else {
            right.add(num);
            left.add(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() != right.size()) return right.peek();
        else return (double) (left.peek() + right.peek()) / 2;
    }
}
