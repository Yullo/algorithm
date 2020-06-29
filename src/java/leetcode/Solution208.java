package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAOYUXING on 2020/6/29.
 */
public class Solution208 {

    /**
     * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
     *
     * 示例:
     *
     * Trie trie = new Trie();
     *
     * trie.insert("apple");
     * trie.search("apple");   // 返回 true
     * trie.search("app");     // 返回 false
     * trie.startsWith("app"); // 返回 true
     * trie.insert("app");
     * trie.search("app");     // 返回 true
     * 说明:
     *
     * 你可以假设所有的输入都是由小写字母 a-z 构成的。
     * 保证所有输入均为非空字符串。
     *
     * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
     */

    class Trie {

        Node root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            List<Node> nodes = root.getNext();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                Node findNode = null;
                for (Node node : nodes) {
                    if (node.getC() == c) {
                        findNode = node;
                        break;
                    }
                }
                if (findNode != null) {
                    if (word.length() - 1 == i) {
                        findNode.setEndWord(true);
                    }
                } else {
                    Node node = new Node();
                    node.setC(c);
                    if (i == word.length() - 1) {
                        node.setEndWord(true);
                    }
                    nodes.add(node);

                    findNode = node;
                }
                nodes = findNode.getNext();
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            List<Node> nodes = root.getNext();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                Node findNode = null;
                for (Node node : nodes) {
                    if (node.getC() == c) {
                        findNode = node;
                        break;
                    }
                }

                if (findNode == null) {
                    return false;
                }

                if (word.length() - 1 == i && findNode.isEndWord()) {
                    return true;
                }

                nodes = findNode.getNext();
            }
            return false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            List<Node> nodes = root.getNext();
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);

                Node findNode = null;
                for (Node node : nodes) {
                    if (node.getC() == c) {
                        findNode = node;
                        break;
                    }
                }

                if (findNode == null) {
                    return false;
                }

                if (prefix.length() - 1 == i) {
                    return true;
                }

                nodes = findNode.getNext();
            }
            return false;
        }

    }

    public class Node {
        char c;
        boolean endWord = false;
        List<Node> next = new ArrayList<>();

        public char getC() {
            return c;
        }

        public void setC(char c) {
            this.c = c;
        }

        public boolean isEndWord() {
            return endWord;
        }

        public void setEndWord(boolean endWord) {
            this.endWord = endWord;
        }

        public List<Node> getNext() {
            return next;
        }

        public void setNext(List<Node> next) {
            this.next = next;
        }
    }


    public static void main(String[] args) {
        Solution208 solution208 = new Solution208();
        Trie trie = solution208.new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("app");
        trie.search("app");     // 返回 true

    }
}
