package me.icro.lcof.o29spiralorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author lin
 * @version v 0.1 2020/12/23
 **/
public class Solution {
    int[] res;
    int index = 0;

    public List<Integer> spiralOrder(int[][] matrix)  {
        if (0 == matrix.length || 0 == matrix[0].length) {
            return new ArrayList<>();
        }
        int x = matrix.length, y = matrix[0].length;
        res = new int[x * y];
        int len = (Math.min(x, y) & 1) == 1 ? Math.min(x, y) / 2 + 1 : Math.min(x, y);
        for (int i = 0, beginX = 0, beginY = 0; i < len; i++, beginX++, beginY++) {
            spiralOneO(matrix, beginX, beginY, x - beginX, y - beginY);
        }
        return IntStream.of(res).boxed().collect(Collectors.toList());
    }

    private void spiralOneO(int[][] matrix, int beginX, int beginY, int x, int y) {
        // →
        for (int i = beginY; i < y && index < res.length; i++) {
            res[index++] = matrix[beginX][i];
        }

        // ↓
        for (int i = beginX + 1; i < x && index < res.length; i++) {
            res[index++] = matrix[i][y - 1];
        }

        // ←
        for (int i = y - 1 - 1; i >= beginY && index < res.length; i--) {
            res[index++] = matrix[x - 1][i];
        }

        // ↑
        for (int i = x - 1 - 1; i >= beginX + 1 && index < res.length; i--) {
            res[index++] = matrix[i][beginY];
        }
    }

}
