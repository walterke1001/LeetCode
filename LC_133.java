import java.util.*;

public class LC_133 {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Deque<Node> que = new LinkedList<>();
        //原始的邻接表
        HashMap<Integer, List<Node>> oriListMap = new HashMap<>();
        HashMap<Integer, ArrayList<Node>> newListMap = new HashMap<>();
        //节点值与新节点的映射
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        que.addLast(node);
        while (!que.isEmpty()) {
            Node tmp = que.pollFirst();
            if (tmp == null) continue;
            if (!nodeMap.containsKey(tmp.val))
                nodeMap.put(tmp.val, new Node(tmp.val));
            //源节点的邻居列表
            List<Node> oriNeighbors = tmp.neighbors;
            //当前节点的邻居列表
            ArrayList<Node> curNodeNeighbors = new ArrayList<>();
            oriListMap.put(tmp.val, oriNeighbors);

            for (Node n : oriNeighbors) {
                if (!oriListMap.containsKey(n.val)) {
                    que.addLast(n);
                }
                if (!nodeMap.containsKey(n.val)) nodeMap.put(n.val, new Node(n.val));
                curNodeNeighbors.add(nodeMap.get(n.val));
            }
            nodeMap.get(tmp.val).neighbors = curNodeNeighbors;
            //newListMap.put(tmp.val, curNodeNeighbors);
        }
//        for (Node n : nodeMap.values()) {
//            n.neighbors = newListMap.get(n.val);
//        }
        return nodeMap.get(1);
    }
}
