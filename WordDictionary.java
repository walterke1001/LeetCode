import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class WordDictionary {
    class Node {
        Node[] children;
        boolean isEnd;

        Node() {
            children = new Node[27];
            isEnd = false;
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) node.children[idx] = new Node();
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int idx, Node node) {
        if (idx == word.length()) return node.isEnd;
        char ch = word.charAt(idx);
        if (Character.isLetter(ch)) {
            int childIdx = ch - 'a';
            return node.children[childIdx] != null && dfs(word, idx + 1, node.children[childIdx]);
        } else {
            for (int i = 0; i < 26; i++)
                if (node.children[i] != null && dfs(word, idx + 1, node.children[i]))
                    return true;
        }
        return false;
    }
}
