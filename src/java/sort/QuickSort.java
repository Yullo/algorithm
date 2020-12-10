package sort;

/**
 * Created by painsolace on 2017/4/26.
 *
 * 快速排序，思想： 选一个基准值，每次排序把大的数放在右边，把小的数放在左边。之后，对两个子数组执行相同的操作
 */
public class QuickSort implements Sort {

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);
            // 基准值两边的数组各自作为一个新的数组处理
            quickSort(list, low, middle - 1);
            quickSort(list, middle + 1, high);
        }
    }

    private int getMiddle(int[] list, int low, int high) {
        //数组的第一个作为基准值
        int tmp = list[low];
        while (low < high) {
            // 从后向前比较
            while (low < high && list[high] >= tmp) {
                high--;
            }
            // 找到第一个比基准值小的，交换
            list[low] = list[high];
            // 再从前往后比较
            while (low < high && list[low] <= tmp) {
                low++;
            }
            // 找到第一个比基准值大的，交换
            list[high] = list[low];
            // 循环迭代，最后，所有比基准值小的都在左边，大的都在右边
        }
        // 将基准值放到新的位置，返回这个位置
        list[low] = tmp;
        return low;
    }

}
