package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by HAOYUXING on 2020/5/18.
 */
public class Solution20 {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     *
     * 输入: "()"
     * 输出: true
     * 示例 2:
     *
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     *
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     *
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     *
     * 输入: "{[]}"
     * 输出: true
     *
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     */

    public boolean isValid(String s) {
        Map<String, String> map = new HashMap();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String val = s.charAt(i) + "";
            String s1 = map.get(val);
            // map不存在，说明是左括号
            if (s1 == null) {
                stack.push(val);
            } // 右括号
            else if (stack.isEmpty() || !s1.equals(stack.pop())) {
                //栈为空 ，一定是非法   栈不为空，判断是否匹配
                return false;
            }
        }
        return stack.isEmpty();
    }
}
