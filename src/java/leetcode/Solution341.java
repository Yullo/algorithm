package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by HAOYUXING on 2020/7/21.
 */
public class Solution341 {

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    /**
     * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
     *
     * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [[1,1],2,[1,1]]
     * 输出: [1,1,2,1,1]
     * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
     *
     * 示例 2:
     *
     * 输入: [1,[4,[6]]]
     * 输出: [1,4,6]
     * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
     *
     * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
     */

    public class NestedIterator implements Iterator<Integer> {

        private List<Integer> list = new ArrayList<>();

        private int idx = 0;

        public NestedIterator(List<NestedInteger> nestedList) {
            initValues(nestedList);
        }

        private void initValues(List<NestedInteger> nestedList) {
            for (int i = 0; i < nestedList.size(); i++) {
                NestedInteger value = nestedList.get(i);
                if (value.isInteger()) {
                    list.add(value.getInteger());
                } else {
                    initValues(value.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return list.get(idx++);
        }

        @Override
        public boolean hasNext() {
            return idx < list.size();
        }
    }

}
