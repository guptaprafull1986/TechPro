package _techlead_coderpro;

import java.util.ArrayList;
import java.util.List;

public class UniqueLongestPrefix {
    public static void main(String[] args) {
        String[] arr = {"jon", "john", "jack", "techlead"};
        Trie trie = new Trie();
        trie.insert(arr);

        for (String s : arr) {
            System.out.println(trie.exist(s));
        }
        List<String> result = uniqueLongestPrefix(trie, arr);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static List<String> uniqueLongestPrefix(Trie trie, String[] arr) {
        List<String> list = new ArrayList<>();
        for (String word : arr) {
            String str = trie.getPrefix(word);
            if (str != null && !str.isEmpty()) {
                list.add(str);
            }
        }
        return list;
    }
}

class Trie {
    private TNode root;

    Trie() {
        root = new TNode();
    }

    String getPrefix(String word) {
        TNode current = root;
        String s = "";
        for (char c : word.toCharArray()) {
            int index = c - 'a';
//            if (current.child[index] == null) {
//                return null;
//            }
            if (current.count == 1) {
                return s;
            }
            current = current.child[index];
            s += c;
        }
        return s;
    }

    public void insert(String[] words) {
        for (String word : words) {
            insert(word);
        }
    }

    public boolean exist(String word) {
        TNode current = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.child[index] == null) {
                return false;
            }
            current = current.child[index];
            System.out.print(current.count + " ");
        }

        System.out.println();
        return current != null && current.count != 0;
    }

    public void insert(String word) {
        TNode current = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.child[index] == null) {
                current.child[index] = new TNode();
            }
            current = current.child[index];
            current.count += 1;
        }
    }

    class TNode {
        int count;
        TNode[] child;

        TNode() {
            count = 0;
            child = new TNode[26];
        }
    }
}

