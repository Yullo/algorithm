package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HAOYUXING on 2020/6/1.
 */
public class Solution76 {

    /**
     * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
     *
     * 示例：
     *
     * 输入: S = "ADOBECODEBANC", T = "ABC"
     * 输出: "BANC"
     * 说明：
     *
     * 如果 S 中不存这样的子串，则返回空字符串 ""。
     * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
     *
     * 链接：https://leetcode-cn.com/problems/minimum-window-substring
     */


    public String minWindow(String s, String t) {
        // 记录t中字符出现次数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer value = map.getOrDefault(c, 0);
            map.put(c, value + 1);
        }

        // 滑动窗口 , 初始不包括任何字符
        int l = 0;
        int r = -1;
        String res = "";
        // 窗口中包含了几个t的字符
        int count = 0;

        while (l < s.length()) {
            // 窗口没有完全包含t字符， 需要扩展
            if (count < t.length() && r + 1 < s.length()) {
                r++;
                char c = s.charAt(r);
                Integer value = map.get(c);
                // 是t中的字符
                if (value != null) {
                    // 先把剩余可使用个数减1
                    map.put(c, value - 1);
                    // 这里大于0 说明这个字符是窗口的有效字符，如果是小于0，说明s的重复字符已经把t中的消耗完了，窗口中必定有了满足的个数
                    if (value > 0) {
                        count++;
                    }
                }
            }
            // 窗口已经全部包含了，需要收缩左边
            else {
                char c = s.charAt(l);
                Integer value = map.get(c);
                // 最左边是t中的字符
                if (value != null) {
                    // 先把剩余使用个数加+1
                    map.put(c, value + 1);
                    // 如果小于0，说明窗口中有重复的字符，去掉这个仍然满足个数，
                    // 大于等于0说明这个字符是窗口的有效字符，去掉需要把窗口满足条件的字符数减1
                    if (value >= 0) {
                        count--;
                    }
                }
                l++;
            }
            // 截取
            if (count == t.length()) {
                //System.out.println(l + " " + r);
                String temp = s.substring(l, r + 1);
                if (res.length() == 0 || temp.length() < res.length()) {
                    res = temp;
                }
            }
        }
        return res;
    }

    /**
     * 滑动窗口套路 ，先向右扩展，直到窗口内满足要求，再收缩左边。 这个题因为t里的字符可能重复，所以用map记录个数辅助判断
     */


    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        System.out.println(solution76.minWindow("ADOBECODEBANC", "ABC"));
    }
}
