package yzh.algorithm.toutiao;

import java.util.HashMap;

/**
 * @author yongzh
 * @date 2020/5/2
 */
public class LRUCache {

    class InnerNode {
        int value;
        int key;
        InnerNode prev;
        InnerNode suc;

        InnerNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private InnerNode head = null;
    private InnerNode tail = null;

    private int capacity;

    private int size;
    private HashMap<Integer, InnerNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>(capacity);

        head = new InnerNode(-1, -1);
        tail = new InnerNode(-1, -1);
        head.suc = tail;
        tail.prev = head;
    }

    public int get(int key) {
        InnerNode node = map.get(key);
        if (node != null) {
            removeNode(node);
            addNode(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        InnerNode node = map.get(key);
        if (node == null) {
            node = new InnerNode(key, value);
            if (size < capacity) {
                addNode(node);
                size++;
            } else {
                map.remove(tail.prev.key);
                removeNode(tail.prev);
                addNode(node);
            }
        } else {
            removeNode(node);
            addNode(node);
            node.value = value;
        }
        map.put(key, node);
    }

    private void addNode(InnerNode node) {
        head.suc.prev = node;
        node.suc = head.suc;
        head.suc = node;
        node.prev = head;
    }


    private void removeNode(InnerNode node) {
        InnerNode pre = node.prev;
        InnerNode suc = node.suc;

        pre.suc = node.suc;
        suc.prev = node.prev;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));
        cache.get(1);       // 返回 -1 (未找到)
        System.out.println(cache.get(3));
        cache.get(3);       // 返回  3
        System.out.println(cache.get(4));
        cache.get(4);       // 返回  4
    }

}
