package leetcode.others;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by HAOYUXING on 2020/5/29.
 */
public class LuckyNum {

    /**
     * 给定一个数组。如果数组内数字出现的次数和这个数字相等，则是幸运数字， 如果有多个，返回最大的数字，没有返回 -1
     */

    public int findLuckyNum(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) {
                Integer value = map.getOrDefault(num, 0);
                map.put(num, value + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return -1;
    }


    public int findLuckyNumV2(int[] nums) {
        Arrays.sort(nums);

        if (nums.length == 1 && nums[0] == 1) {
            return 1;
        }

        int startIdx = 0;
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num <= 0) {
                continue;
            }
            if (nums[startIdx] != num) {
                if (i - startIdx == nums[startIdx]) {
                    max = nums[startIdx];
                }
                startIdx = i;

                if (num > nums.length - i) {
                    break;
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        LuckyNum num = new LuckyNum();
        System.out.println(num.findLuckyNumV2(new int[]{1}));
    }


}
