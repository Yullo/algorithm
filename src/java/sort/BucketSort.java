package sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by HAOYUXING on 2020/12/10.
 *
 * 桶排序, 思想：每个桶存储一定范围的元素，对每个桶内的元素进行排序，最后非空桶的元素即为有序
 */
public class BucketSort implements Sort {

    @Override
    public void sort(int[] arr) {
        // 构建一个桶 （构建什么样的桶，桶的范围怎么定是桶排序的关键）
        List<List<Integer>> list = new ArrayList<>();
        // 这里准备3个桶， - - 2， 3 - 5， 6 - +
        for (int i = 0; i < arr.length; i++) {
            int idx = 0;
            if (arr[i] <= 2) {
                idx = 0;
            } else if (arr[i] <= 5) {
                idx = 1;
            } else {
                idx = 2;
            }
            List<Integer> bucket = list.get(idx);
            if (bucket == null) {
                bucket = new ArrayList<>();
            }
            bucket.add(arr[i]);
        }
        // 对每个桶进行排序
        for (List<Integer> bucket : list) {
            bucket.sort(Comparator.naturalOrder());
        }
        // 遍历排好序的桶，拷贝到原数组中
        int idx = 0;
        for (List<Integer> bucket : list) {
            for (Integer val : bucket) {
                arr[idx++] = val;
            }
        }
    }
}
