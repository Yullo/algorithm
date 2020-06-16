package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HAOYUXING on 2020/6/16.
 */
public class Solution146 {

    /**
     * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
     *
     * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
     * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     *
     *  
     *
     * 进阶:
     *
     * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
     *
     *  
     *
     * 示例:
     *
     * LRUCache cache = new LRUCache( 2 // 缓存容量  );
     *
     * cache.put(1,1);
     * cache.put(2,2);
     * cache.get(1);       // 返回  1
     * cache.put(3,3);    // 该操作会使得关键字 2 作废
     * cache.get(2);       // 返回 -1 (未找到)
     * cache.put(4,4);    // 该操作会使得关键字 1 作废
     * cache.get(1);       // 返回 -1 (未找到)
     * cache.get(3);       // 返回  3
     * cache.get(4);       // 返回  4
     *
     * 链接：https://leetcode-cn.com/problems/lru-cache
     */

    class LRUCache {

        Map<Integer, Node> map;
        int capacity;
        int size;
        // 两个虚拟节点，方便插入删除节点
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            // 删除原节点
            remove(node);
            // 重新插入
            put(node.key, node.value);
            return node.value;
        }

        public void put(int key, int value) {
            // 重复插入
            if (map.get(key) != null) {
                remove(map.get(key));
            }
            // 满了就删掉队尾
            if (size == capacity) {
                Node node = tail.pre;
                remove(node);
            }
            // 插入头节点后面
            Node node = new Node(key, value);
            node.pre = head;
            node.next = head.next;
            head.next = node;
            node.next.pre = node;

            map.put(key, node);
            size++;
        }

        private void remove(Node node) {
            map.remove(node.key);
            size--;

            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
        }
    }


    class Node {
        int key;
        int value;
        Node next;
        Node pre;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.pre = null;
        }
    }

}
