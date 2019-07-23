package me.icro.topinterviewquesitons2018.linkedlist.copyrandomlist;

import java.util.HashMap;

/**
 * 描述:
 *  https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/265/linked-list/1145/
 *
 * 思路:
 *  * 使用哈希表，生成一份影子节点，key = 原节点，value = 新节点
 *  * 从头遍历，将影子节点按原节点的关联 连起来
 *
 * @author Lin
 * @since 2019-07-23 11:20 AM
 */
public class Solution {
    public Node copyRandomList(Node head) {
        if (null == head) return null;

        Node newNode = new Node();

        HashMap<Node, Node> map = new HashMap<>();
        Node copyHead = head;
        while (null != copyHead) {
            Node node = new Node(copyHead.val, null, null);
            map.put(copyHead, node);
            copyHead = copyHead.next;
        }

        copyHead = head;
        while (null != copyHead) {
            Node randomNode = map.get(copyHead);
            randomNode.next = map.get(copyHead.next);
            randomNode.random = map.get(copyHead.random);
            copyHead = copyHead.next;
        }

        return map.remove(head);
    }

}
