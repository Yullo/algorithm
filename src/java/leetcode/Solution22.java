package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by HAOYUXING on 2020/5/18.
 */
public class Solution22 {

    /**
     * 22. 括号生成
     *
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     *  
     *
     * 示例：
     *
     * 输入：n = 3
     * 输出：[
     *        "((()))",
     *        "(()())",
     *        "(())()",
     *        "()(())",
     *        "()()()"
     *      ]
     *
     * 链接：https://leetcode-cn.com/problems/generate-parentheses
     */

    // 括号插空法
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        if (n == 1) {
            res.add("()");
            return res;
        }
        // 计算过程会使用上一层的结果，使用递归
        List<String> lastRes = generateParenthesis(n - 1);
        for (int i = 0; i < lastRes.size(); i++) {
            String s = lastRes.get(i);
            for (int j = 0; j < s.length(); j++) {
                res.add(s.substring(0, j) + "()" + s.substring(j));
            }
        }
        Set<String> set = new HashSet<>(res);
        res.clear();
        res.addAll(set);
        res.sort(Comparator.naturalOrder());
        return res;
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        System.out.println(solution22.generateParenthesisV2(3));
    }

    /**
     * 回溯算法框架:
     *
     * def backtrack(路径, 选择列表):
     *     if 满足结束条件:
     *         result.add(路径)
     *         return
     *
     *     for 选择 in 选择列表:
     *         做选择
     *         backtrack(路径, 选择列表)
     *         撤销选择
     */
    public List<String> generateParenthesisV2(int n) {
        List<String> list = new ArrayList<>();
        dfs(n, n, "", list);
        return list;
    }

    // l r 表示剩余括号的个数
    private void dfs(int l, int r, String s, List<String> list) {
        if (l == 0 && r == 0) {
            list.add(s);
            return;
        }
        // 拼 左括号
        if (l > 0) {
            dfs(l - 1, r, s + "(", list);
        }
        // 当剩余右括号大于左括号个数时 拼接
        if (r > l) {
            dfs(l, r - 1, s + ")", list);
        }
    }
}
