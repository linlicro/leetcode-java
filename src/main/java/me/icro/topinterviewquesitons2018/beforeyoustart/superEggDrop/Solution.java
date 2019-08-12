package me.icro.topinterviewquesitons2018.beforeyoustart.superEggDrop;

/**
 * 描述: https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/261/before-you-start/1110/
 * <p>
 *
 * 思考了两天, 尝试了二分法, 求根法, 最后坚持不住了, 参考: https://juejin.im/post/5b98785de51d450e71250aab
 *
 * 首先 分析2个鸡蛋100层楼的问题:
 *
 * 通过假设法, 得出 假设问题存在最优解(扔鸡蛋过程),这个解的最坏情况尝试次数是x次,那么,我们第一次扔鸡蛋该选择哪一层? 答案恰恰是从第x层开始扔,选择更高一层或是更低一层都不合适
 *
 * 归纳:
 *  * 如果第一次扔鸡蛋没有碎,我们的尝试消耗了一次,问题就转化成了两个鸡蛋在100-x层楼往下扔,要求尝试次数不得超过x-1次
 *  * 所以第二次尝试的楼层跨度是x-1层,绝对楼层是x+(x-1)层
 *  * 同理,如果鸡蛋还没有碎,第三次楼层跨度是x-2,第四次是x-3
 *  * 最后 可以列出一个楼层数的方程式: x + (x-1) + (x-2) + ... + 1 = 100
 *
 *  ==> (x+1)*x/2 = 100
 *
 * @author Lin
 * @since 2019-05-27 1:44 PM
 */
public class Solution {
    public int superEggDrop(int K, int N) {
        //if (1 == K)
        //    return N;
        //if (1 == N)
        //    return N;
        //int count = 0;
        //while (K > 1 && N > 1) {
        //    N /= 2;
        //    count++;
        //    K--;
        //}
        //return count + (1 == N ? 1: (N - 1));

        if (1 == K) {
            return N;
        }

        int count = 0;
        while (N > 1) {
            count++;
            N /= 2;
            K--;
            if (1 == K)
                return count + N - 1;
        }
        return count + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().superEggDrop(1, 2));
        System.out.println(new Solution().superEggDrop(2, 6));
        System.out.println(new Solution().superEggDrop(3, 14));

        System.out.println(new Solution().superEggDrop(2, 1));
        System.out.println(new Solution().superEggDrop(2, 2));
    }
}
