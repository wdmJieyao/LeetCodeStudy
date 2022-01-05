package com.lijieyao.rabbitmq.hello;

import java.util.HashMap;
import java.util.Map;

/**
 * 力扣第15题
 */
public class LeetCode_0015 {

    public static void main(String[] args) {
//        ListNode a5 = new ListNode(5);
//        ListNode a4 = new ListNode(4,a5);
//        ListNode a3 = new ListNode(3,a4);
        ListNode a2 = new ListNode(2);
        ListNode a1 = new ListNode(1,a2);

        ListNode head = removeNthFromEnd(a1, 2);
        ListNode curr = head;
        while (true) {
            System.out.println(curr.val);
            curr = curr.next;
            if (curr == null) {
                return;
            }
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head.next == null) {
            return null;
        }

        // 序号，当前节点
        Map<Integer, ListNode> map = new HashMap<>();
        int curr = 0;
        ListNode current = head;
        while (true) {
            map.put(curr, current);

            if (current.next == null){
                break;
            }

            current = current.next;
            curr++;
        }
        if (map.size() < n) {
            return null;
        }

        int index = map.size() - n;
        int preIndex = map.size() - n - 1;

        if (index == 0){
            return head.next;
        }

        // 前一个节点
        ListNode pre = map.get(preIndex);
        // 当前节点
        ListNode cur = map.get(index);
        // 节点置换
        pre.next = cur.next;
        return head;
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

    /**
     * 大佬优化方案
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int traverse = traverse(head, n);
        if (traverse == n)
            return head.next;
        return head;
    }

    private int traverse(ListNode node, int n) {
        if (node == null)
            return 0;
        int num = traverse(node.next, n);
        if (num == n)
            node.next = node.next.next;
        return num + 1;
    }
}
