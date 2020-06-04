package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HAOYUXING on 2020/6/3.
 */
public class Solution91 {

    /**
     * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
     *
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
     *
     * 示例 1:
     *
     * 输入: "12"
     * 输出: 2
     * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
     *
     * 示例 2:
     *
     * 输入: "226"
     * 输出: 3
     * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     *
     * 链接：https://leetcode-cn.com/problems/decode-ways
     *
     * 相似题目：44
     */

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return s.charAt(0) - '0' > 0 ? 1 : 0;
        }
        int i = s.charAt(0) - '0';
        int j = s.charAt(1) - '0';

        if (i == 0) {
            return 0;
        }

        if (s.length() == 2 && i <= 2) {
            return (j > 0 && (i == 1 || (i == 2 && j < 7))) ? 2 : 1;
        }

        // 一个数肯定能匹配
        int cut = numDecodings(s.substring(1));

        // 如果后面的两个数满足条件，加上匹配两个数的结果
        if (i == 1 || (i == 2 && j < 7)) {
            cut = cut + numDecodings(s.substring(2));
        }
        return cut;
    }


    // 上面的方法由于重复子问题会超时， 使用备忘录优化
    public int numDecodingsV2(String s) {
        Map<String, Integer> map = new HashMap<>();
        return numDecodingsV2(s, map);
    }

    public int numDecodingsV2(String s, Map<String, Integer> map) {
        if (map.get(s) != null) {
            return map.get(s);
        }

        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return s.charAt(0) - '0' > 0 ? 1 : 0;
        }

        int i = s.charAt(0) - '0';
        int j = s.charAt(1) - '0';

        if (i == 0) {
            return 0;
        }

        if (s.length() == 2 && i <= 2) {
            return (j > 0 && (i == 1 || (i == 2 && j < 7))) ? 2 : 1;
        }

        int cut = numDecodingsV2(s.substring(1), map);
        if (i == 1 || (i == 2 && j < 7)) {
            cut = cut + numDecodingsV2(s.substring(2), map);
        }

        map.put(s, cut);
        return cut;
    }


    public static void main(String[] args) {
        Solution91 solution91 = new Solution91();
        System.out.println(solution91.numDecodingsV2("12111"));
    }
}
