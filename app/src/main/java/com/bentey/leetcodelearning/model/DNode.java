package com.bentey.leetcodelearning.model;

/**
 * yinyu
 * 2024/8/5
 */
public class DNode {

    public DNode pre;

    public DNode next;

    public int key;

    public int value;

    public DNode() {

    }

    public DNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
