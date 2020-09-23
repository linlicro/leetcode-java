package me.icro.problems.t1095findinmountainarray;

/**
 * @author lin
 * @version v 0.1 2020/9/23
 **/
public class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = getPeakIndex(mountainArr);
        if (target == mountainArr.get(peakIndex)) {
            return peakIndex;
        }
        // 查左坡
        int res = findLeft(target, mountainArr, 0, peakIndex - 1);
        if (res != -1) {
            return res;
        }

        // 查右坡
        return findRight(target, mountainArr, peakIndex + 1, mountainArr.length() - 1);
    }

    private int findLeft(int target, MountainArray mountainArr, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            }
            if (mountainArr.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int findRight(int target, MountainArray mountainArr, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            }
            if (mountainArr.get(mid) > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int getPeakIndex(MountainArray mountainArr) {
        int left = 0, right = mountainArr.length() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == left && mid == right) {
                return mid;
            }
            if (mid == left || mid == right) {
                return mountainArr.get(left) > mountainArr.get(right) ? left : right;
            }
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        MountainArray mountainArr = new MountainArray(new int[]{1, 2, 4, 5, 3, 1});
        System.out.println(new Solution().findInMountainArray(3, mountainArr));

        mountainArr = new MountainArray(new int[]{1, 2, 3, 4, 5, 3, 1});
        System.out.println(new Solution().findInMountainArray(3, mountainArr));

        mountainArr = new MountainArray(new int[]{1, 2, 4, 5, 1});
        System.out.println(new Solution().findInMountainArray(3, mountainArr));

        mountainArr = new MountainArray(new int[]{0, 5, 3, 1});
        System.out.println(new Solution().findInMountainArray(1, mountainArr));
    }
}
