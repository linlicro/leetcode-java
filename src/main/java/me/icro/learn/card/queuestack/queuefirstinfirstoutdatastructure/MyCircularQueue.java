package me.icro.learn.card.queuestack.queuefirstinfirstoutdatastructure;

import java.util.Arrays;
import java.util.List;

/**
 * 描述: https://leetcode-cn.com/explore/learn/card/queue-stack/216/queue-first-in-first-out-data-structure/865/
 *
 * @author Lin
 * @since 2019-09-30 8:49 PM
 */
public class MyCircularQueue {

    private int[] data;
    private int length;
    private int index_head;
    private int index_tail;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        length = k;
        data = new int[k];
        index_head = index_tail = -1;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        if (-1 == index_tail) {
            // init
            index_head = index_tail = 0;
        } else {
            index_tail = (index_tail + 1) % length;
        }
        data[index_tail] = value;
        //index_tail = (index_tail + 1) % length;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty())
            return false;
        data[index_head] = 0;
        if (index_head == index_tail) {
            index_head = index_tail = -1;
        } else {
            index_head = (index_head + 1) % length;
        }
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty())
            return -1;
        return data[index_head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty())
            return -1;
        return data[index_tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return -1 == index_tail;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        if (index_head == index_tail)
            return false;
        if (index_tail > index_head) {
            return length == (index_tail - index_head + 1);
        }
        return length == ((length - index_head) + index_tail + 1);
    }

    public static void main(String[] args) {
        /**
         * Your MyCircularQueue object will be instantiated and called as such:
         * MyCircularQueue obj = new MyCircularQueue(k);
         * boolean param_1 = obj.enQueue(value);
         * boolean param_2 = obj.deQueue();
         * int param_3 = obj.Front();
         * int param_4 = obj.Rear();
         * boolean param_5 = obj.isEmpty();
         * boolean param_6 = obj.isFull();
         */
        //MyCircularQueue obj = new MyCircularQueue(3);
        //System.out.println(obj.enQueue(1));
        //System.out.println(obj.enQueue(2));
        //System.out.println(obj.enQueue(3));
        //System.out.println(obj.enQueue(4));
        //System.out.println(obj.Rear());
        //System.out.println(obj.isFull());
        //System.out.println(obj.deQueue());
        //System.out.println(obj.enQueue(4));
        //System.out.println(obj.Rear());
        //System.out.println(obj.isFull());

        MyCircularQueue.test(Arrays.asList("MyCircularQueue", "enQueue", "isFull", "enQueue", "enQueue", "isFull", "enQueue", "enQueue", "enQueue", "Front", "Front", "Rear", "enQueue", "Rear", "enQueue", "Rear", "Front", "enQueue", "enQueue", "Front", "enQueue", "enQueue", "Rear", "enQueue", "isEmpty", "Rear", "Front", "Rear", "enQueue", "Front", "enQueue", "Rear", "isEmpty", "Rear", "enQueue", "Front", "Front", "deQueue", "enQueue", "Front", "enQueue", "enQueue", "deQueue", "enQueue", "isFull", "Front", "enQueue", "deQueue", "enQueue", "isEmpty", "isEmpty", "enQueue", "Front", "Front", "Rear", "deQueue", "Front", "enQueue", "Rear", "enQueue", "Rear", "Rear", "Front", "deQueue", "enQueue", "deQueue", "Rear", "enQueue", "Front", "enQueue", "enQueue", "deQueue", "enQueue", "Front", "enQueue", "deQueue", "enQueue", "Front", "Front", "enQueue", "enQueue", "enQueue", "Front", "enQueue", "enQueue", "Rear", "deQueue", "enQueue", "Front", "enQueue", "enQueue", "Rear", "enQueue", "enQueue", "Rear", "isFull", "enQueue", "Rear", "enQueue", "deQueue", "Rear", "enQueue"),
                new int[]{30, 71, 0, 32, 1, 0, 32, 8, 6, 0, 0, 0, 8, 0, 3, 0, 0, 56, 41, 0, 14, 6, 0, 25, 0, 0, 0, 0, 44, 0, 84, 0, 0, 0, 59, 0, 0, 0, 4, 0, 40, 11, 0, 94, 0, 0, 72, 0, 19, 0, 0, 20, 0, 0, 0, 0, 0, 58, 0, 54, 0, 0, 0, 0, 65, 0, 0, 59, 0, 26, 10, 0, 14, 0, 2, 0, 37, 0, 0, 46, 63, 42, 0, 84, 30, 0, 0, 49, 0, 79, 46, 0, 97, 83, 0, 0, 76, 0, 79, 0, 0, 44});
    }

    private static void test(List<String> ops, int[] values) {
        MyCircularQueue circularQueue = new MyCircularQueue(0);
        for (int i = 0; i < ops.size(); i++) {
            String op = ops.get(i);
            int out = 0;
            int value = values[i];
            if ("MyCircularQueue".equals(op)) {
                circularQueue = new MyCircularQueue(value);
            } else if ("enQueue".equals(op)) {
                out = circularQueue.enQueue(value) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                //System.out.println(out);
            } else if ("deQueue".equals(op)) {
                out = circularQueue.deQueue() ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                //System.out.println();
            } else if ("Front".equals(op)) {
                out = circularQueue.Front();
                //System.out.println();
            } else if ("Rear".equals(op)) {
                out = circularQueue.Rear();
                //System.out.println();
            } else if ("isEmpty".equals(op)) {
                out = circularQueue.isEmpty() ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                //System.out.println();
            } else if ("isFull".equals(op)) {
                out = circularQueue.isFull() ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                //System.out.println();
            } else {
                System.out.println("Illegal op.");
            }
            System.out.print(Integer.MAX_VALUE == out ? "true"
                    : (Integer.MIN_VALUE == out ? "false" : String.valueOf(out)));
            System.out.print(",");
        }
    }

}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */