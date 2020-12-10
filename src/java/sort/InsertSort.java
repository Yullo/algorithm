package sort;

/**
 * Created by HAOYUXING on 2020/12/10.
 *
 * 插入排序， 思想： 将数据分成两个部分（有序，无序），将无序的元素依次插入有序的队列中. eg: 抓扑克牌
 */
public class InsertSort implements Sort {

    public void sort(int[] arr) {

        // 第一个元素是有序的， 从第二个元素开始扫描
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            // 从后向前扫描有序的数组
            int idx = i - 1;

            while (idx >= 0 && val < arr[idx]) {
                // 如果候选数比扫描到的数字小
                // 将扫描到的数字往后移动，空出可能插入的位置
                arr[idx + 1] = arr[idx];
                idx--;
            }
            // 插入到合适的位置
            arr[idx + 1] = val;
        }
    }
}
