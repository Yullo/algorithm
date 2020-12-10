package sort;

/**
 * Created by HAOYUXING on 2020/12/10.
 *
 * 希尔排序： 首先按照一个增量分组，对每组使用插入排序算法排序， 之后减小增量， 重复上述步骤，直至增量减少到1，所有数据被分为一组
 * 时间复杂度突破了 O(n ^ 2) ,平均为 O( n ^ 1.3)
 */
public class ShellSort implements Sort {

    @Override
    public void sort(int[] arr) {
        int d = arr.length / 2;

        while (d > 0) {
            // 对每组进行插入排序 , 从d开始， 交替对每组进行插入排序
            for (int i = d; i < arr.length; i++) {
                int val = arr[i];

                int idx = i - d;

                while (idx >= 0 && val < arr[idx]) {
                    arr[idx + d] = arr[idx];
                    idx = idx - d;
                }
                arr[idx + d] = val;
            }
            // 减小增量
            d = d / 2;
        }
    }
}
