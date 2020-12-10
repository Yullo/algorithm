package sort;

/**
 * Created by HAOYUXING on 2020/12/10.
 *
 * 归并排序, 思想：将待排序序列分为若干个子序列，先对每个子序列进行排序，等每个子序列都有序后，再将有序子序列合并为整体的有序序列. 分治法应用
 */
public class MergeSort implements Sort {

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(arr, 0, mid);
            sort(arr, mid + 1, right);
            merge(arr, 0, mid, mid + 1, right);
        }
    }

    private void merge(int[] arr, int ls, int le, int rs, int re) {
        int[] data = new int[re + 1];
        int idx = 0;
        int t = ls;

        while (ls <= le && rs <= re) {
            if (arr[ls] < arr[rs]) {
                data[idx] = arr[ls++];
            } else {
                data[idx] = arr[rs++];
            }
            idx++;
        }
        while (ls <= le) {
            data[idx++] = arr[ls++];
        }
        while (rs <= re) {
            data[idx++] = arr[rs++];
        }
        // 将数据拷贝到原数组
        for (int i = 0; i < data.length; i++) {
            arr[t++] = data[i];
        }
    }
}
