package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAOYUXING on 2020/6/11.
 */
public class Solution131 {

    /**
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     *
     * 返回 s 所有可能的分割方案。
     *
     * 示例:
     *
     * 输入: "aab"
     * 输出:
     * [
     *   ["aa","b"],
     *   ["a","a","b"]
     * ]
     *
     * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
     */

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        cutString(s, new ArrayList<>(), res);
        return res;
    }

    private void cutString(String s, List<String> list, List<List<String>> res) {
        System.out.println(s);
        // 字符串都遍历完了
        if (s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 从左至右移动指针，指针将字符串分割成两部分，先判断前半段是不是回文，如果是，进行选择，把下半段交给递归
        // 下半段处理完成之后，撤销选择，继续下一轮指针移动
        for (int i = 0; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (isHuiWen(sub)) {
                list.add(sub);
                cutString(s.substring(i), list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * 心得：
     * 回溯法，在做完选择，操作完成之后，一定要撤销当前的选择
     */

    private boolean isHuiWen(String s) {
        if (s.length() == 0) return false;
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution131 solution131 = new Solution131();
        System.out.println(solution131.partition("cbbbcc"));
    }


}
