package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HAOYUXING on 2020/6/17.
 */
public class Solution149 {

    /**
     * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
     *
     * 示例 1:
     *
     * 输入: [[1,1],[2,2],[3,3]]
     * 输出: 3
     * 解释:
     * ^
     * |
     * |        o
     * |     o
     * |  o  
     * +------------->
     * 0  1  2  3  4
     * 示例 2:
     *
     * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
     * 输出: 4
     * 解释:
     * ^
     * |
     * |  o
     * |     o        o
     * |        o
     * |  o        o
     * +------------------->
     * 0  1  2  3  4  5  6
     *
     * 链接：https://leetcode-cn.com/problems/max-points-on-a-line
     */


    // 这个题有个大坑，相同的坐标算不同点
    public int maxPoints(int[][] points) {
        // 只有两个点必然在一条线
        if (points.length <= 2) {
            return points.length;
        }

        int res = 0;
        // 遍历每个点
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int dump = 0;
            // 斜率 -> 点的个数
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                System.out.println("检查" + Arrays.toString(point) + " 和 " + Arrays.toString(points[j]));

                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                // 两个数相同
                if (x == 0 && y == 0) {
                    dump++;
                    continue;
                }
                // 找到公约数约分
                int gcd = x > y ? gcd(x, y) : gcd(x, y);
                x = x / gcd;
                y = y / gcd;

                String key = x + "#" + y;
                // 默认值为0 是因为可能由于相同点提前返回，这里就无法赋值了，所以需要在外面单独赋值
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int max = 0;
            for (Integer value : map.values()) {
                max = Math.max(max, value);
            }
            // 斜率相同最多的个数， 再加 这个点 和 相同的点
            max += dump + 1;
            // 结果
            res = Math.max(res, max);
        }

        return res;
    }

    // 获取最大公约数
    private int gcd(int a, int b) {
        //a = Math.abs(a);
        //b = Math.abs(b);

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }


    public static void main(String[] args) {
        Solution149 solution149 = new Solution149();
        System.out.println(solution149.maxPoints(new int[][]{{1, 1}, {1, 1}, {1, 1}}));
    }
    //{1,1},{0,0},{1,1},{3,4},{4,5},{5,6},{7,8},{8,9}}


    /**
     * 固定一个点，遍历其他点，和这个点组成直线，统计斜率相同的个数
     *
     * 如何计算斜率? 直接除法会有精度问题，使用分数化简， 3/6  =  1/2 ， 2/4 = 1/2 , 即找最大公约数
     *
     * 使用辗转相除法，可以计算最大公约数
     *
     * 大数除以小数，以除数和余数反复做除法运算，当余数为 0 时，取当前除数为最大公约数
     *
     *     public int maxPoints(int[][] points) {
     *         if (points.length < 3) {
     *             return points.length;
     *         }
     *         int res = 0;
     *         //遍历每个点
     *         for (int i = 0; i < points.length; i++) {
     *             int duplicate = 0;
     *             int max = 0;//保存经过当前点的直线中，最多的点
     *             HashMap<String, Integer> map = new HashMap<>();
     *             for (int j = i + 1; j < points.length; j++) {
     *                 //求出分子分母
     *                 int x = points[j][0] - points[i][0];
     *                 int y = points[j][1] - points[i][1];
     *                 if (x == 0 && y == 0) {
     *                     duplicate++;
     *                     continue;
     *
     *                 }
     *                 //进行约分
     *                 int gcd = gcd(x, y);
     *                 x = x / gcd;
     *                 y = y / gcd;
     *                 String key = x + "@" + y;
     *                 map.put(key, map.getOrDefault(key, 0) + 1);
     *                 max = Math.max(max, map.get(key));
     *             }
     *             //1 代表当前考虑的点，duplicate 代表和当前的点重复的点
     *             res = Math.max(res, max + duplicate + 1);
     *         }
     *         return res;
     *     }
     */
}
