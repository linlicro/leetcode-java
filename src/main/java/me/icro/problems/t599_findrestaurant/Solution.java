package me.icro.problems.t599_findrestaurant;

import java.util.*;

/**
 * @author lin
 * @version v 0.1 2020/5/29
 **/
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<Integer, List<String>> map = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        // 遍历 list1，生成字典 - string&index
        Map<String, Integer> stringIntegerMap = new HashMap<>(list1.length);
        for (int i = 0; i < list1.length; i++) {
            stringIntegerMap.put(list1[i], i);
        }
        // 遍历 list2，记录相同喜爱的餐厅 及索引和，并且记录最小索引和
        for (int i = 0; i < list2.length; i++) {
            if (stringIntegerMap.containsKey(list2[i])) {
                Integer index = stringIntegerMap.get(list2[i]) + i;
                if (index < minIndex) {
                    minIndex = index;
                }
                if (map.containsKey(index)) {
                    map.get(index).add(list2[i]);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(list2[i]);
                    map.put(index, list);
                }
            }
        }
        // 返回最小索引和的餐厅list
        return Integer.MAX_VALUE == minIndex ? new String[0] : map.get(minIndex).toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
        System.out.println(Arrays.toString(new Solution().findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"})));
    }
}
