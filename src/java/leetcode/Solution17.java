package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HAOYUXING on 2020/5/15.
 */
public class Solution17 {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * 2 abc
     * 3 def
     * 4 ghi
     * 5 jkl
     * 6 mno
     * 7 pqrs
     * 8 tuv
     * 9 wxyz
     *
     * 示例:
     *
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * 说明:
     * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     *
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     */

    public List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }

        search(0, digits, "", res, map);
        return res;
    }

    // 深度优先搜索 DFS ， 满足条件返回 或者 继续搜索
    private void search(int m, String digits, String prefix, List<String> list, Map<Integer, String> map) {
        if (prefix.length() == digits.length()) {
            list.add(prefix);
            return;
        }
        Integer val = Integer.valueOf(digits.charAt(m) + "");
        String str = map.get(val);
        for (int i = 0; i < str.length(); i++) {
            search(m + 1, digits, prefix + str.charAt(i), list, map);
        }
    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        System.out.println(solution17.letterCombinations("23"));
    }
}
