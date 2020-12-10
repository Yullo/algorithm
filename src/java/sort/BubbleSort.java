package sort;

/**
 * Created by painsolace on 2017/4/26.
 *
 * 冒泡排序, 思想: 依次比较相邻的两个元素，大的放在后面
 */
public class BubbleSort implements Sort {

    public void sort(int[] arr){
        // N个数两两比较， 需要 N-1 趟 （最后一个元素不需要比较）
        for (int i = 0; i < arr.length - 1; i++) {
            // 每次排序后，都会将本次最大的数放在最后，所以长度可操作的数越来越少
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }

}
