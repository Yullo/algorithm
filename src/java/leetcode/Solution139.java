package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HAOYUXING on 2020/6/15.
 */
public class Solution139 {

    /**
     * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     *
     * 说明：
     *
     * 拆分时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     * 示例 1：
     *
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
     * 示例 2：
     *
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     *      注意你可以重复使用字典中的单词。
     * 示例 3：
     *
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     *
     * 链接：https://leetcode-cn.com/problems/word-break
     */

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, new HashMap<>());
    }

    public boolean wordBreak(String s, List<String> wordDict, Map<String, Boolean> map) {
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
                if (wordBreak(s.substring(i), wordDict, map)) {
                    return true;
                }
            }
        }
        // 备忘录优化重复子问题
        map.put(s, false);
        return false;
    }


    public static void main(String[] args) {
        Solution139 solution139 = new Solution139();
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aaa");

        System.out.println(solution139.wordBreak("aaaaaaa", list));
    }
}
