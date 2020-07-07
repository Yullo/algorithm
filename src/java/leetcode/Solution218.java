package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by HAOYUXING on 2020/6/30.
 */
public class Solution218 {

    /**
     * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。现在，假设您获得了城市风光照片（图A）上显示的所有建筑物的位置和高度，请编写一个程序以输出由这些建筑物形成的天际线（图B）。
     *
     *
     *
     * 每个建筑物的几何信息用三元组 [Li，Ri，Hi] 表示，其中 Li 和 Ri 分别是第 i 座建筑物左右边缘的 x 坐标，Hi 是其高度。可以保证 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX 和 Ri - Li > 0。您可以假设所有建筑物都是在绝对平坦且高度为 0 的表面上的完美矩形。
     *
     * 例如，图A中所有建筑物的尺寸记录为：[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] 。
     *
     * 输出是以 [ [x1,y1], [x2, y2], [x3, y3], ... ] 格式的“关键点”（图B中的红点）的列表，它们唯一地定义了天际线。关键点是水平线段的左端点。请注意，最右侧建筑物的最后一个关键点仅用于标记天际线的终点，并始终为零高度。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
     *
     * 例如，图B中的天际线应该表示为：[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]。
     *
     * 说明:
     *
     * 任何输入列表中的建筑物数量保证在 [0, 10000] 范围内。
     * 输入列表已经按左 x 坐标 Li  进行升序排列。
     * 输出列表必须按 x 位排序。
     * 输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
     *
     * 链接：https://leetcode-cn.com/problems/the-skyline-problem
     */

    // 这个题完全不会
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        // {x, h, id}
        ArrayList<int[]> es = new ArrayList<int[]>();

        // 左端点高度正数表示， 右端点高度负数表示
        for (int i = 0; i < n; ++i) {
            es.add(new int[]{buildings[i][0], buildings[i][2], i});
            es.add(new int[]{buildings[i][1], -buildings[i][2], i});
        }

        es.sort((e1, e2) -> {
            return e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0];
        });


        List<List<Integer>> ans = new ArrayList<>();

        // 优先队列的最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1); // 最大堆
        // 记录之前的高度
        int prev = 0;

        for (int[] e : es) {
            int x = e[0];
            int h = e[1];
            int id = e[2];

            Boolean entering = h > 0;
            h = Math.abs(h);

/*            if (entering) {
                if (h > heap.max()) {
                    ans.add(new int[]{x, h});
                }
                heap.add(h, id);
            } else {
                heap.remove(id);
                if (h > heap.max()) {
                    ans.add(new int[]{x, heap.max()});
                }
            }*/

            // 左端点入堆
            if (entering) {
                queue.offer(h);
            } else {  // 右端点出堆
                queue.remove(h);
            }
            Integer cur = queue.peek() == null ? 0 : queue.peek(); // 获取最大堆的当前顶点，当null时置为0
            if (prev != cur) {
                ans.add(new ArrayList<Integer>() {{
                    add(x);
                    add(cur);
                }});
                prev = cur;
            }

        }

        return ans;
    }

    /**
     * 解析： 扫描线算法
     *
     * https://www.bilibili.com/video/BV1hb411c7Q4
     *
     *
     *
     *     // 线扫描法
     *     public List<List<Integer>> getSkyline2(int[][] buildings) {
     *         // 创建返回值
     *         List<List<Integer>> res = new ArrayList<>();
     *         // 保存所有的可能拐点
     *         Set<Pair<Integer, Integer>> pairs = new TreeSet<>(
     *             (o1, o2) -> !o1.getKey().equals(o2.getKey()) ? o1.getKey() - o2.getKey() : o1.getValue() - o2.getValue()); // 二元组
     *         // 将每一个建筑分成两个部分
     *         for (int[] build : buildings) {
     *             pairs.add(new Pair<>(build[0], -build[2]));
     *             pairs.add(new Pair<>(build[1], build[2]));
     *         }
     *         // 优先队列的最大堆
     *         PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1); // 最大堆
     *         // 记录之前的高度
     *         int prev = 0;
     *         // 遍历
     *         for (Pair<Integer, Integer> pair : pairs) {
     *             if (pair.getValue() < 0) queue.offer(-pair.getValue()); // 左端点 高度入堆
     *             else queue.remove(pair.getValue()); // 右端点 高度出堆
     *             Integer cur = queue.peek() == null ? 0 : queue.peek(); // 获取最大堆的当前顶点，当null时置为0
     *             if (prev != cur) {
     *                 res.add(new ArrayList<Integer>() {{
     *                     add(pair.getKey());
     *                     add(cur);
     *                 }});
     *                 prev = cur;
     *             }
     *         }
     *         return res;
     *     }
     */


}
