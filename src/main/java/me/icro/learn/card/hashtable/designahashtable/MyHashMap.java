package me.icro.learn.card.hashtable.designahashtable;

import java.util.LinkedList;

/**
 * 描述: https://leetcode-cn.com/explore/learn/card/hash-table/203/design-a-hash-table/800/
 *
 * @author Lin
 * @since 2019-12-05 2:36 PM
 */
public class MyHashMap {

    LinkedList[] linkedLists;

    /** Initialize your data structure here. */
    public MyHashMap() {
        linkedLists = new LinkedList[10000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = key % 10000;
        if (null == linkedLists[hash]) {
            linkedLists[hash] = new LinkedList();
        }
        for (int i = linkedLists[hash].size() - 1; i >= 0; i--) {
            Node node = (Node) linkedLists[hash].get(i);
            if (node.getKey() == key) {
                node.setValue(value);
                return;
            }
        }
        linkedLists[hash].addFirst(new Node(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = key % 10000;
        if (null == linkedLists[hash]) {
            return -1;
        }
        for (int i = linkedLists[hash].size() - 1; i >= 0; i--) {
            Node node = (Node) linkedLists[hash].get(i);
            if (node.getKey() == key) {
                return node.getValue();
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key % 10000;
        if (null == linkedLists[hash]) {
            return;
        }
        for (int i = linkedLists[hash].size() - 1; i >= 0; i--) {
            Node node = (Node) linkedLists[hash].get(i);
            if (node.getKey() == key) {
                linkedLists[hash].remove(i);
                break;
            }
        }
    }

    static class Node {
        final int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
    }
}
