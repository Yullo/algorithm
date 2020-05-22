package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HAOYUXING on 2020/5/22.
 */
public class Solution49 {
    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 示例:
     *
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     * 说明：
     *
     * 所有输入均为小写字母。
     * 不考虑答案输出的顺序。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/group-anagrams
     */

    public List<List<String>> groupAnagrams(String[] strs) {

        // 质数相乘不会重复 （正整数唯一分解定理）
        // 定理： 任何一个大于1的自然数N，如果N不为素数，那么，N就能被 唯一 的分解为有限个素数的乘积
        // 那么反过来， 有限个素数的乘积的值是 唯一的，某个正整数
        int[] primes = {2, 3, 5, 7, 11, 13, 17,
            19, 23, 29, 31, 37, 41, 43,
            47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101};

        Map<Integer, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int t = 1;
            for (int i = 0; i < str.length(); i++) {
                t *= primes[str.charAt(i) - 'a'];
            }
            map.computeIfAbsent(t, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
