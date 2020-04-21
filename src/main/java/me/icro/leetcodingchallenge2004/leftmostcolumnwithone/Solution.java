package me.icro.leetcodingchallenge2004.leftmostcolumnwithone;

import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/4/21
 **/
public class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int left = 0, right = dimensions.get(1) - 1;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(binaryMatrix, dimensions, mid) == 1) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    int check(BinaryMatrix binaryMatrix, List<Integer>  dimensions, int column) {
        for (int i = 0; i < dimensions.get(0); i++) {
            if (binaryMatrix.get(i, column) == 1) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().leftMostColumnWithOne(new BinaryMatrix(new int[][]{
                new int[]{0, 0},
                new int[]{1, 1}
        })));
        System.out.println(new Solution().leftMostColumnWithOne(new BinaryMatrix(new int[][]{
                new int[]{0, 0},
                new int[]{0, 1}
        })));
        System.out.println(new Solution().leftMostColumnWithOne(new BinaryMatrix(new int[][]{
                new int[]{0, 0},
                new int[]{0, 0}
        })));
        System.out.println(new Solution().leftMostColumnWithOne(new BinaryMatrix(new int[][]{
                new int[]{0,0,0,1},
                new int[]{0,0,1,1},
                new int[]{0,1,1,1}
        })));
    }
}
