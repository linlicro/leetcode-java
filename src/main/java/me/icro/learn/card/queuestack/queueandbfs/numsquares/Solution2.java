package me.icro.learn.card.queuestack.queueandbfs.numsquares;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述:
 *
 * BFS 基础算法，抓住如下几点即可轻松写出不易错的 baseline:
 *
 * * BFS 算法组成的 3 元素：队列，入队出队的节点，已访问的集合。
 *  - 队列：先入先出的容器；
 *  - 节点：最好写成单独的类，比如本例写成 (value,step) 元组。也可写成 (value,visited)，看自己喜好和题目；
 *  - 已访问集合：为了避免队列中插入重复的值
 *
 * * BFS算法组成的套路：
 *  - 初始化三元素：Node = node(n) queue = [Node] visited = set([Node.value])
 *  - 操作队列 —— 弹出队首节点：vertex = queue.pop(0)
 *  - 操作弹出的节点 —— 根据业务生成子节点（一个或多个）
 *  - 判断这些节点 —— 符合业务条件，则return，不符合业务条件，且不在已访问集合，则追加到队尾，并加入已访问集合
 *
 * @author Lin
 * @since 2019-10-02 8:21 PM
 */
public class Solution2 {
    private class Node {
        int val;
        int step;

        public Node(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }

    public int numSquares(int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 1));
        boolean record[] = new boolean[n];
        while (!queue.isEmpty()) {
            int val = queue.peek().val;
            int step = queue.peek().step;
            queue.remove();
            // 每一层的广度遍历
            for (int i = 1;; i++) {
                int nextVal = val - i * i;
                // 说明已到最大平方数
                if (nextVal < 0)
                    break;

                // 由于是广度遍历，所以当遍历到0时，肯定是最短路径
                if(nextVal == 0)
                    return step;

                // 当再次出现时没有必要加入，因为在该节点的路径长度肯定不小于第一次出现的路径长
                if(!record[nextVal]){
                    queue.add(new Node(nextVal,step + 1));
                    record[nextVal] = true;
                }
            }
        }
        return -1;
    }
}
