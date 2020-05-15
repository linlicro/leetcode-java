package me.icro.problems.t11_maxarea;

/**
 * 双指针
 *
 * @author lin
 * @version v 0.1 2020/5/15
 **/
public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int tmpArea = (j - i) * Math.min(height[i], height[j]);
            if (tmpArea > maxArea) {
                maxArea = tmpArea;
            }
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxArea;
    }

//    private int[] getTop2Index(int[] height) {
//        int maxOneIndex = height[0] > height[1] ? 0 : 1;
//        int maxTwoIndex = 0 == maxOneIndex ? 1 : 0;
//        for (int i = 2; i < height.length; i++) {
//            if (height[maxOneIndex] < height[i]) {
//                maxTwoIndex = maxOneIndex;
//                maxOneIndex = i;
//            } else if (height[maxTwoIndex] < height[i]) {
//                maxTwoIndex = i;
//            }
//        }
//        return new int[]{maxOneIndex, maxTwoIndex};
//    }

//    private int[] getTop2Index(int[] height) {
//        int[] indexs = new int[]{0, 1};
//        int tmpArea = Math.min(height[0], height[1]);
//        for (int i = 2; i < height.length; i++) {
//            // 计算 index[0] ~ i 的面积, 为 area1
//            int area1 = Math.min(height[indexs[0]], height[i]) * (i - indexs[0]);
//            // 计算 index[1] ~ i 的面积，为area2
//            int area2 = Math.min(height[indexs[1]], height[i]) * (i - indexs[1]);
//            // 比较 area1, area2, tmpArea 哪个面积大，面积大的两点为 最新的两个点
//            if (area1 > Math.max(area2, tmpArea)) {
//                indexs[1] = i;
//                tmpArea = area1;
//                continue;
//            }
//            if (area2 > Math.max(area1, tmpArea)) {
//                indexs[0] = indexs[1];
//                indexs[1] = i;
//                tmpArea = area2;
//            }
//        }
//        return indexs;
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(new Solution().maxArea(new int[]{1, 8}));
//        [2,3,10,5,7,8,9]
        System.out.println(new Solution().maxArea(new int[]{2, 3, 10, 5, 7, 8, 9}));
    }
}
