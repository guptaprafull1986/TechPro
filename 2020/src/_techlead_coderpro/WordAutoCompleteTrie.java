package _techlead_coderpro;

import java.util.ArrayList;
import java.util.List;

public class WordAutoCompleteTrie {

    public static void main(String[] args) {
        String[] dictionary = {"dog", "dark", "cat", "door", "dodge"};
        List<String> list = autoCompleteWords(dictionary, "do");

        for (String word : list) {
            System.out.println(word);
        }
    }

    private static List<String> autoCompleteWords(String[] dictionary, String word) {
        List<String> list = new ArrayList();
        if (word == null) {
            return list;
        }
        if (word.isEmpty()) {
            for (String s : dictionary) {
                list.add(s);
            }
            return list;
        }

        TrieNode trie = prepareDict(dictionary);

        TrieNode current = trie;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return list;
            }
            current = current.children[index];
        }

        findWord(current, list);
        return list;
    }

    private static void findWord(TrieNode node, List<String> list) {
        if (node == null) return;
        if (node.isEoW) {
            list.add(node.word);
        }

        if (node.children != null) {
            for (TrieNode child : node.children) {
                findWord(child, list);
            }
        }
    }

    private static TrieNode prepareDict(String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isEoW = true;
            current.word = word;
        }
        return root;
    }

    static class TrieNode {
        boolean isEoW;
        TrieNode[] children;
        String word;

        TrieNode() {
            isEoW = false;
            children = new TrieNode[26];
            word = null;
        }
    }
}


