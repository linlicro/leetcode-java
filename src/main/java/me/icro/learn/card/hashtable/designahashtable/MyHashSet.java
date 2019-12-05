package me.icro.learn.card.hashtable.designahashtable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述: https://leetcode-cn.com/explore/learn/card/hash-table/203/design-a-hash-table/799/
 *
 * @author Lin
 * @since 2019-12-05 11:40 AM
 */
public class MyHashSet {

    LinkedList[] linkedLists;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        linkedLists = new LinkedList[10000];
    }

    public void add(int key) {
        int hash = key % 10000;
        //Node node;
        if (null == linkedLists[hash]) {
            linkedLists[hash] = new LinkedList();
        }
        for (int i = linkedLists[hash].size() - 1; i >= 0; i--) {
            if (linkedLists[hash].get(i).equals(key)) {
                return;
            }
        }
        linkedLists[hash].addFirst(key);
    }

    public void remove(int key) {
        int hash = key % 10000;
        if (null == linkedLists[hash]) {
            return;
        }
        for (int i = linkedLists[hash].size() - 1; i >= 0; i--) {
            if (linkedLists[hash].get(i).equals(key)) {
                linkedLists[hash].remove(i);
                break;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int hash = key % 10000;
        if (null == linkedLists[hash]) {
            return false;
        }
        for (int i = linkedLists[hash].size() - 1; i >= 0; i--) {
            if (linkedLists[hash].get(i).equals(key)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2));
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));
    }

}
