package me.icro.lcof.o52getintersectionnode;

import lombok.Data;

/**
 * 描述:
 *
 * @author Lin
 * @since 2019-05-06 2:10 PM
 */
@Data
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
