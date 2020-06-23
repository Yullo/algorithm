package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HAOYUXING on 2020/6/23.
 */
public class Solution166 {

    /**
     * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
     *
     * 如果小数部分为循环小数，则将循环的部分括在括号内。
     *
     * 示例 1:
     *
     * 输入: numerator = 1, denominator = 2
     * 输出: "0.5"
     * 示例 2:
     *
     * 输入: numerator = 2, denominator = 1
     * 输出: "2"
     * 示例 3:
     *
     * 输入: numerator = 2, denominator = 3
     * 输出: "0.(6)"
     *
     * 链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
     */


    public String fractionToDecimal(int numerator, int denominator) {
        long mod = numerator % denominator;
        // 如果没有余数，直接返回结果即可
        if (mod == 0) {
            return String.valueOf((long) numerator / denominator);
        }
        // 整数部分
        long div = numerator / denominator;

        String res = Math.abs(div) + ".";

        // 保存余数，有循环的条件是余数出现了重复，这里保存出现的余数与出现时结果长度的对应关系
        Map<String, Integer> modMap = new HashMap<>();
        modMap.put(mod + "", res.length());

        // 处理异号
        boolean neg = (denominator ^ numerator) < 0;
        // 用 long 处理避免超过范围
        long longdenominator = denominator;

        // 异号 或者 都为负数，转成正数计算
        if (mod < 0 || neg) {
            mod = Math.abs(mod);
            longdenominator = Math.abs(longdenominator);
        }

        while (mod > 0) {
            mod *= 10;
            div = mod / longdenominator;
            mod = mod % longdenominator;

            Integer idx = modMap.get(mod + "");
            // 余数重复了，在第一次出现的地方，插入括号，终止循环
            if (idx != null) {
                res = res.substring(0, idx) + "(" + res.substring(idx);
                res = res + div + ")";
                break;
            } else {
                // 没有重复，加上结果
                res += div;
                modMap.put(mod + "", res.length());
            }
        }
        return neg ? "-" + res : res;
    }

}
