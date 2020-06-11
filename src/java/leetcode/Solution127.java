package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by HAOYUXING on 2020/6/10.
 */
public class Solution127 {

    /**
     * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
     *
     * 每次转换只能改变一个字母。
     * 转换过程中的中间单词必须是字典中的单词。
     * 说明:
     *
     * 如果不存在这样的转换序列，返回 0。
     * 所有单词具有相同的长度。
     * 所有单词只由小写字母组成。
     * 字典中不存在重复的单词。
     * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
     * 示例 1:
     *
     * 输入:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * 输出: 5
     *
     * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     *      返回它的长度 5。
     * 示例 2:
     *
     * 输入:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     *
     * 输出: 0
     *
     * 解释: endWord "cog" 不在字典中，所以无法进行转换。
     *
     * 链接：https://leetcode-cn.com/problems/word-ladder
     */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int res = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (Iterator<String> iterator = wordList.iterator(); iterator.hasNext(); ) {
                    String next = iterator.next();
                    // 找到所有相邻的节点
                    if (canTransfer(word, next)) {
                        if (next.equals(endWord)) {
                            // 找到就提前返回了，路数要+1
                            return res + 1;
                        }
                        // 加到队列里
                        queue.offer(next);
                        // 删除值避免重复
                        iterator.remove();

                    }
                }
            }
        }
        // 走到这里说明,前面没找到值，并且剩下的元素都不和图相连，所以不会找到了
        if (wordList.size() > 0) {
            res = 0;
        }
        return res;
    }


    // 两个节点是否联通， 是否只有一个字母不同
    private boolean canTransfer(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    /**
     * 最短路径问题 一般都可以使用 图的广度优先搜索（无权图） 解决
     */

    public static void main(String[] args) {
        Solution127 solution127 = new Solution127();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("czg");
        System.out.println(solution127.ladderLength("hit", "czg", list));
    }
}
