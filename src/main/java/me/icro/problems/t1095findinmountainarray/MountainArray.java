package me.icro.problems.t1095findinmountainarray;

/**
 * @author lin
 * @version v 0.1 2020/9/23
 **/
public class MountainArray {

    private int[] arr;

    public MountainArray(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        return arr[index];
    }

    public int length() {
        return arr.length;
    }
}
