import java.util.HashMap;

public class LRUCache {
    static class Node {
        Node next;
        Node pre;
        int val;
        int key;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int cap;
    int num;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        cap = capacity;
        num = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToFirst(node);
            map.put(key, node);
        } else {
            Node node = new Node(value);
            node.val = value;
            node.key = key;
            if (num == cap)
                removeLast();
            insertToFirst(node);
        }
    }

    public void moveToFirst(Node node) {
        if (node.pre != null)
            node.pre.next = node.next;
        if (node.next != null)
            node.next.pre = node.pre;

        node.next = head.next;
        node.pre = head;
        node.next.pre = node;
        node.pre.next = node;
    }

    public void removeLast() {
        num--;
        Node last = tail.pre;
        last.pre.next = tail;
        tail.pre = last.pre;
        last.pre = null;
        last.next = null;
        map.remove(last.key);
    }

    public void insertToFirst(Node node) {
        num++;
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
        map.put(node.key, node);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println("cache.put(1, 1)");
        cache.put(1, 1);
        System.out.println("cache.put(2, 2)");
        cache.put(2, 2);
        System.out.println("cache.get(1):");
        cache.get(1);
        System.out.println("cache.put(3, 3);");
        cache.put(3, 3);
        System.out.println("cache.get(2):");
        cache.get(2);
        System.out.println("cache.put(4, 4)");
        cache.put(4, 4);
        System.out.println("cache.get(1):");
        cache.get(1);
        System.out.println("cache.get(3):");
        cache.get(3);
        System.out.println("cache.get(4)");
        cache.get(4);

    }
}
