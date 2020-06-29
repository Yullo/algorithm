package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAOYUXING on 2020/6/29.
 */
public class Solution212 {

    /**
     * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
     *
     * 示例:
     *
     * 输入:
     * words = ["oath","pea","eat","rain"] and board =
     * [
     *   ['o','a','a','n'],
     *   ['e','t','a','e'],
     *   ['i','h','k','r'],
     *   ['i','f','l','v']
     * ]
     *
     * 输出: ["eat","oath"]
     * 说明:
     * 你可以假设所有输入都由小写字母 a-z 组成。
     *
     * 提示:
     *
     * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
     * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
     *
     * 链接：https://leetcode-cn.com/problems/word-search-ii
     *
     * 相似题目： 79 , 208
     */

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<String> list = new ArrayList<>();
        // 矩阵中组成的单词，去搜索数中查找是否存在
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                search(board, i, j, trie, "", list);
            }
        }
        return list;
    }

    private void search(char[][] board, int i, int j, Trie trie, String temp, List<String> result) {
        // 判断是否越界或回头
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '*') {
            return;
        }

        // 选择，并记录走过的路径
        temp = temp + board[i][j];

        // 先判断是否存在前缀
        Node node = trie.startsWith(temp);
        if (node == null) {
            return;
        }

        // 判断是否存在单词，结果不重复
        if (node.isEndWord() && !result.contains(temp)) {
            result.add(temp);
        }

        // 用占位符替换当前选择
        board[i][j] = '*';

        // 上下左右四个方向找下一个字符组成的单词
        search(board, i + 1, j, trie, temp, result);
        search(board, i - 1, j, trie, temp, result);
        search(board, i, j + 1, trie, temp, result);
        search(board, i, j - 1, trie, temp, result);

        //撤销选择
        board[i][j] = temp.charAt(temp.length() - 1);
        temp = temp.substring(0, temp.length() - 1);

    }

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

        // 改造搜索方法，直接返回前缀节点，在此基础上判断是否是单词
        public Node startsWith(String prefix) {
            if (prefix.length() == 0) {
                return null;
            }
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
                    return null;
                }

                if (prefix.length() - 1 == i) {
                    return findNode;
                }

                nodes = findNode.getNext();
            }
            return null;
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

}
