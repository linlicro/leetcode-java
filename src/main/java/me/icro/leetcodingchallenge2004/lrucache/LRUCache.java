package me.icro.leetcodingchallenge2004.lrucache;

import java.util.HashMap;

/**
 * @author lin
 * @version v 0.1 2020/4/24
 **/
public class LRUCache {

    //双向链表构建，双向链表的尾部为最近最少使用结点
    class Data{
        int key;
        int value;
        Data pre;
        Data next;
    }

    //每次将新结点加入双向链表头部
    private void addData(Data data){
        data.next = head.next;
        data.pre = head;
        head.next.pre = data;
        head.next = data;
    }

    //删除指定结点
    private void removeData(Data data){
        Data pre = data.pre;
        Data next = data.next;
        pre.next = next;
        next.pre = pre;
        data.pre = null;
        data.next = null;
    }

    //将指定结点转移至链表头部
    private void moveToHead(Data data){
        removeData(data);
        addData(data);
    }

    //将尾部元素（LRU结点）删除并返回
    private Data popTail(){
        Data data = tail.pre;
        removeData(data);
        return data;
    }

    //成员参数设置
    private HashMap<Integer , Data> cacheMap;
    private int capacity;
    private int size;
    Data head;
    Data tail;

    public LRUCache(int capacity) {
        cacheMap = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        head = new Data();
        tail = new Data();

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(cacheMap.containsKey(key)){
            moveToHead(cacheMap.get(key));
            return cacheMap.get(key).value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(!cacheMap.containsKey(key)){
            if(size == capacity){
                Data data = popTail();
                cacheMap.remove(data.key);
                size--;
            }
            Data data = new Data();
            data.key = key;
            data.value = value;
            addData(data);
            cacheMap.put(key, data);
            size++;
        }else{
            Data data = cacheMap.get(key);
            data.value = value;
            moveToHead(data);
        }
    }
}
