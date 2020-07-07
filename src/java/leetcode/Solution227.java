package leetcode;

import java.util.Stack;

/**
 * Created by HAOYUXING on 2020/7/7.
 */
public class Solution227 {

    /**
     * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
     *
     * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
     *
     * 示例 1:
     *
     * 输入: "3+2*2"
     * 输出: 7
     * 示例 2:
     *
     * 输入: " 3/2 "
     * 输出: 1
     * 示例 3:
     *
     * 输入: " 3+5 / 2 "
     * 输出: 5
     * 说明：
     *
     * 你可以假设所给定的表达式都是有效的。
     * 请不要使用内置的库函数 eval。
     *
     * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
     */

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        s = s.trim();
        int num = 0;
        char pc = '+'; // 保存上一个操作符，转变成后缀表达式
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c >= '0' && c <= '9') {
                num = 10 * num + (c - '0');
            }
            if (c < '0' || c > '9' || i == s.length() - 1) {
                if (pc == '+') {
                    stack.push(num);
                } else if (pc == '-') {
                    stack.push(-num);
                } else if (pc == '*') {
                    stack.push(stack.pop() * num);
                } else if (pc == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                pc = c;
            }
        }
        int res = 0;
        // 栈中的数字只进行加减
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution227 solution227 = new Solution227();
        System.out.println(solution227.calculate("3 / 2 "));
    }
}
