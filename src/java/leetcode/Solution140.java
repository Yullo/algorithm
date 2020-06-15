package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HAOYUXING on 2020/6/15.
 */
public class Solution140 {

    /**
     * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
     *
     * 说明：
     *
     * 分隔时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     * 示例 1：
     *
     * 输入:
     * s = "catsanddog"
     * wordDict = ["cat", "cats", "and", "sand", "dog"]
     * 输出:
     * [
     *   "cats and dog",
     *   "cat sand dog"
     * ]
     * 示例 2：
     *
     * 输入:
     * s = "pineapplepenapple"
     * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
     * 输出:
     * [
     *   "pine apple pen apple",
     *   "pineapple pen apple",
     *   "pine applepen apple"
     * ]
     * 解释: 注意你可以重复使用字典中的单词。
     * 示例 3：
     *
     * 输入:
     * s = "catsandog"
     * wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出:
     * []
     *
     * 链接：https://leetcode-cn.com/problems/word-break-ii
     */


    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        wordBreak(s, wordDict, new ArrayList<>(), res);
        return res;

    }


    private void wordBreak(String s, List<String> wordDict, List<String> temp, List<String> res) {
        if (s.length() == 0) {
            res.add(String.join(" ", temp));
            return;
        }

        for (int i = 0; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            // 回溯法，会超出时间限制， 这里先按照139题判断一下能否拆分，可以通过
            if (wordDict.contains(sub) && wordBreak2(s, wordDict)) {
                temp.add(sub);
                wordBreak(s.substring(i), wordDict, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean wordBreak2(String s, List<String> wordDict) {
        return wordBreak2(s, wordDict, new HashMap<>());
    }

    private boolean wordBreak2(String s, List<String> wordDict, Map<String, Boolean> map) {
        if (s.length() == 0) {
            return true;
        }

        if (map.get(s) != null) {
            return map.get(s);
        }

        // 回溯法
        for (int i = 0; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (wordDict.contains(sub)) {
                if (wordBreak2(s.substring(i), wordDict, map)) {
                    return true;
                }
            }
        }
        // 备忘录优化重复子问题
        map.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        Solution140 solution140 = new Solution140();
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        list.add("applepen");
        list.add("pine");
        list.add("pineapple");

        System.out.println(solution140.wordBreak("pineapplepenapple", list));
    }

}
