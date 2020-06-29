package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by HAOYUXING on 2020/6/29.
 */
public class Solution207 {

    /**
     *你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
     *
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
     *
     * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
     *
     *  
     *
     * 示例 1:
     *
     * 输入: 2, [[1,0]]
     * 输出: true
     * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
     * 示例 2:
     *
     * 输入: 2, [[1,0],[0,1]]
     * 输出: false
     * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
     *  
     *
     * 提示：
     *
     * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
     * 你可以假定输入的先决条件中没有重复的边。
     * 1 <= numCourses <= 10^5
     *
     * 链接：https://leetcode-cn.com/problems/course-schedule
     */

    // 只要图中有环则必然无法完成
    // 环的判断根据入度计算， 从入度为0的节点搜索，搜索完一个节点，把它从途中拿掉，因此后续节点的入度都减一 ，若最后所有节点入度都为0，则无环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 存储入度
        int[] innerNums = new int[numCourses];
        // 存储图的连接关系
        Map<Integer, List<Integer>> map = new HashMap<>();
        // base
        for (int[] prerequisite : prerequisites) {
            innerNums[prerequisite[1]]++;
            map.computeIfAbsent(prerequisite[0], k -> new ArrayList<>()).add(prerequisite[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        // 将所有入度为0的点放入队列中
        for (int i = 0; i < innerNums.length; i++) {
            if (innerNums[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<Integer> list = map.get(poll);
            if (list == null) {
                continue;
            }
            // 找到邻接的点，将入度减 1
            for (Integer next : list) {
                innerNums[next]--;

                // 如果已经减成0, 放到队列中
                if (innerNums[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for (int i = 0; i < innerNums.length; i++) {
            if (innerNums[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution207 solution207 = new Solution207();
        System.out.println(solution207.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
