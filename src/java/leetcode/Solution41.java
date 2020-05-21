package leetcode;

/**
 * Created by HAOYUXING on 2020/5/20.
 */
public class Solution41 {

    /**
     *给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [1,2,0]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [3,4,-1,1]
     * 输出: 2
     * 示例 3:
     *
     * 输入: [7,8,9,11,12]
     * 输出: 1
     *  
     *
     * 提示：
     *
     * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
     *
     * 链接：https://leetcode-cn.com/problems/first-missing-positive
     */

    // 空间复杂度 O(n)
    public int firstMissingPositive(int[] nums) {
        // 创建一样大的数组， 将正数放到对应的位置上(从1开始), 则 newArr[i] = i + 1
        int[] newArr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                continue;
            }
            newArr[nums[i] - 1] = nums[i];
        }

        int res = newArr.length + 1;
        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] == 0) {
                res = i + 1;
                break;
            }
        }
        return res;
    }

    /**
     * 解析：
     * https://www.cnblogs.com/apeway/p/10764597.html
     *
     *     // 原地查找 空间复杂度 O(1)
     *     public int firstMissingPositive(int[] nums) {
     *         // 表示边界，合法的最大值。 比right大的数，就表示该数不合法，应该被丢掉
     *         // 随着数组元素被处理，每遇到一个不合法的元素，就应将right减1
     *         int r = nums.length;
     *
     *         // 索引，[0,l] 表示整理好的数据
     *         int l = 0;
     *
     *         while(l < r){
     *             if(nums[l] == l + 1){
     *                 l++;
     *             }else if(nums[l] < l + 1 || nums[l] > r || nums[l] == nums[nums[l] - 1]){
     *                 r--;
     *                 nums[l] = nums[r];
     *             }else{
     *                 // swap
     *                 int j = nums[l] - 1;
     *                 int t = nums[l];
     *                 nums[l] = nums[j];
     *                 nums[j] = t;
     *             }
     *         }
     *         return l + 1;
     *     }
     *
     */


}
