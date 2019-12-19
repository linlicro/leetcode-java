package me.icro.topinterviewquesitons2018.heapstackqueue.decodeString.floodfill;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 描述: https://leetcode-cn.com/explore/learn/card/queue-stack/220/conclusion/891/
 *
 * @author Lin
 * @since 2019-12-19 3:31 PM
 */
public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (0 == image.length)
            return image;

        LinkedList<Pair<Integer, Integer>> linkedList = new LinkedList<>();
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        linkedList.addFirst(new Pair<>(sr, sc));
        set.add(linkedList.peekFirst());
        while (!linkedList.isEmpty()) {
            Pair<Integer, Integer> cur = linkedList.pollLast();
            Integer pix = image[cur.getKey()][cur.getValue()];
            // 上、下、左、右
            if (0 <= cur.getKey() - 1 && image[cur.getKey() - 1][cur.getValue()] == pix && !set.contains(new Pair<>(cur.getKey() - 1, cur.getValue()))) {
                linkedList.addFirst(new Pair<>(cur.getKey() - 1, cur.getValue()));
                set.add(linkedList.peekFirst());
            }
            if (image.length > cur.getKey() + 1 && image[cur.getKey() + 1][cur.getValue()] == pix && !set.contains(new Pair<>(cur.getKey() + 1, cur.getValue()))) {
                linkedList.addFirst(new Pair<>(cur.getKey() + 1, cur.getValue()));
                set.add(linkedList.peekFirst());
            }
            if (0 <= cur.getValue() - 1 && image[cur.getKey()][cur.getValue() - 1] == pix && !set.contains(new Pair<>(cur.getKey(), cur.getValue() - 1))) {
                linkedList.addFirst(new Pair<>(cur.getKey(), cur.getValue() - 1));
                set.add(linkedList.peekFirst());
            }
            if (image[0].length > cur.getValue() + 1 && image[cur.getKey()][cur.getValue() + 1] == pix && !set.contains(new Pair<>(cur.getKey(), cur.getValue() + 1))) {
                linkedList.addFirst(new Pair<>(cur.getKey(), cur.getValue() + 1));
                set.add(linkedList.peekFirst());
            }
            image[cur.getKey()][cur.getValue()] = newColor;
        }
        return image;
    }

    public class Pair<K,V>{

        /**
         * Key of this <code>Pair</code>.
         */
        private K key;

        /**
         * Gets the key for this pair.
         * @return key for this pair
         */
        public K getKey() { return key; }

        /**
         * Value of this this <code>Pair</code>.
         */
        private V value;

        /**
         * Gets the value for this pair.
         * @return value for this pair
         */
        public V getValue() { return value; }

        /**
         * Creates a new pair
         * @param key The key for this pair
         * @param value The value to use for this pair
         */
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * <p><code>String</code> representation of this
         * <code>Pair</code>.</p>
         *
         * <p>The default name/value delimiter '=' is always used.</p>
         *
         *  @return <code>String</code> representation of this <code>Pair</code>
         */
        @Override
        public String toString() {
            return key + "=" + value;
        }

        /**
         * <p>Generate a hash code for this <code>Pair</code>.</p>
         *
         * <p>The hash code is calculated using both the name and
         * the value of the <code>Pair</code>.</p>
         *
         * @return hash code for this <code>Pair</code>
         */
        @Override
        public int hashCode() {
            // name's hashCode is multiplied by an arbitrary prime number (13)
            // in order to make sure there is a difference in the hashCode between
            // these two parameters:
            //  name: a  value: aa
            //  name: aa value: a
            return key.hashCode() * 13 + (value == null ? 0 : value.hashCode());
        }

        /**
         * <p>Test this <code>Pair</code> for equality with another
         * <code>Object</code>.</p>
         *
         * <p>If the <code>Object</code> to be tested is not a
         * <code>Pair</code> or is <code>null</code>, then this method
         * returns <code>false</code>.</p>
         *
         * <p>Two <code>Pair</code>s are considered equal if and only if
         * both the names and values are equal.</p>
         *
         * @param o the <code>Object</code> to test for
         * equality with this <code>Pair</code>
         * @return <code>true</code> if the given <code>Object</code> is
         * equal to this <code>Pair</code> else <code>false</code>
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Pair) {
                Pair pair = (Pair) o;
                if (key != null ? !key.equals(pair.key) : pair.key != null) return false;
                if (value != null ? !value.equals(pair.value) : pair.value != null) return false;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[] {1, 1, 1},
                new int[] {1, 1, 0},
                new int[] {1, 0, 1}
        };
        new Solution().floodFill(matrix, 1, 1, 2);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
