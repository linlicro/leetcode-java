package me.icro.leetcodingchallenge2004.leftmostcolumnwithone;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lin
 * @version v 0.1 2020/4/21
 **/
public class BinaryMatrix {

    private int[][] mat;

    public BinaryMatrix(int[][] mat) {
        this.mat = mat;
    }

    int get(int x, int y) {
        return mat[x][y];
    }

    List<Integer> dimensions() {
        List<Integer> list = new ArrayList<>(2);
        list.add(mat.length);
        list.add(mat[0].length);
        return list;
    }
}
