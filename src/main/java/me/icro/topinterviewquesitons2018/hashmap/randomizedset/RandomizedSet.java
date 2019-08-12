package me.icro.topinterviewquesitons2018.hashmap.randomizedset;

import java.util.HashMap;
import java.util.Random;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-08-12 7:10 PM
 */
class RandomizedSet {

    private HashMap<Integer, Integer> map;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (has(val))
            return false;
        map.put(val, val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!has(val))
            return false;
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Object[] keys = map.keySet().toArray();
        if (0 == keys.length)
            return -1;
        return map.get(keys[new Random().nextInt(keys.length)]);
    }

    private boolean has(int val) {
        return this.map.containsKey(val);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
