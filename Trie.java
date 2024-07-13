public class Trie {
    class Node {
        Node[] children;
        boolean isEnd;

        Node() {
            children = new Node[26];
            isEnd = false;
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) node.children[idx] = new Node();
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Node node = searchPre(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node node = searchPre(prefix);
        return node != null;
    }

    public Node searchPre(String tar) {
        Node node = root;
        for (int i = 0; i < tar.length(); i++) {
            int idx = tar.charAt(i) - 'a';
            if (node.children[idx] == null) return null;
            node = node.children[idx];
        }
        return node;
    }

}
