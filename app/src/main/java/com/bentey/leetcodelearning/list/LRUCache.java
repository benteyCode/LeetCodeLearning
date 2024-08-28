package com.bentey.leetcodelearning.list;

import com.bentey.leetcodelearning.model.DNode;

import java.util.HashMap;

/**
 * yinyu
 * 2024/8/5
 */
public class LRUCache {

    private int capacity;

    private int size;

    private DNode head;

    private DNode tail;

    private HashMap<Integer, DNode> container = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        head = new DNode();
        tail = new DNode();

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DNode dNode = container.get(key);
        if (dNode == null) {
            return -1;
        }
        moveToHead(dNode);
        return dNode.value;
    }

    private void moveToHead(DNode dNode) {
        removeCurrentNode(dNode);
        addToHead(dNode);
    }

    private void addToHead(DNode dNode) {
        dNode.pre = head;
        dNode.next = head.next;
        head.next.pre = dNode;
        head.next = dNode;
    }

    private void removeCurrentNode(DNode dNode) {
        dNode.pre.next = dNode.next;
        dNode.next.pre = dNode.pre;
    }

    public void put(int key, int value) {
        DNode dNode = container.get(key);
        if (dNode == null) {
            DNode newNode = new DNode(key, value);
            container.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                DNode last = cutLastNode();
                container.remove(last.key);
                size--;
            }
        } else {
            dNode.value = value;
            moveToHead(dNode);
        }
    }

    private DNode cutLastNode() {
        DNode last = tail.pre;
        removeCurrentNode(last);
        return last;
    }
}
