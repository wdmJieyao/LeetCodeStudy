package com.lijieyao.studydemo.leetCode;

/**
 * @Description: 力扣第十二题
 * @Author: LiJieYao
 * @Date: 2022-01-07 16:51
 */
public class LeetCode_0021 {


    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);


        ListNode nodeC = new ListNode(6);
        ListNode nodeB = new ListNode(4,nodeC);
        ListNode nodeA = new ListNode(1,nodeB);

        ListNode node = mergeTwoLists(node1, nodeA);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }



    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
