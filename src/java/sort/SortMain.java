package sort;

import java.util.Arrays;

/**
 * Created by HAOYUXING on 2020/12/10.
 */
public class SortMain {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 5, 2, 3, 1};

        Sort sort = new BubbleSort();
        sort = new InsertSort();
        sort = new QuickSort();
        sort = new ShellSort();
        sort = new MergeSort();
        sort = new BucketSort();

        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
