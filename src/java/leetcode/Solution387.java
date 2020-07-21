package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HAOYUXING on 2020/7/21.
 */
public class Solution387 {

    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     *  
     *
     * 示例：
     *
     * s = "leetcode"
     * 返回 0
     *
     * s = "loveleetcode"
     * 返回 2
     *  
     *
     * 提示：你可以假定该字符串只包含小写字母。
     *
     * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
     */

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        // 统计
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        // 遍历原字符串保证顺序
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
