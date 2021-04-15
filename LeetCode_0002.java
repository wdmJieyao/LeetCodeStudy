package com.qhee.ztt.entity;

/**
 * @author LiJieYao
 * @description LeetCode Problem  2
 * @date 2021/4/15 18:59
 */
public class LeetCode_0002 {

    /*
    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

    请你将两个数相加，并以相同形式返回一个表示和的链表。

    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    输入：l1 = [2,4,3], l2 = [5,6,4]
    输出：[7,0,8]
    解释：342 + 465 = 807.

   思路： 指针 + 进位
    */


    public static void main(String[] args) {
        // 链表1
        ListNode oneC = new ListNode(1);
        ListNode oneB = new ListNode(1, oneC);
        ListNode oneA = new ListNode(1, oneB);

        // 链表2
        ListNode towC = new ListNode(1);
        ListNode towB = new ListNode(1, towC);
        ListNode towA = new ListNode(1, towB);

        ListNode node = addTwoNumbers(oneA, towA);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int ten = 0;
        ListNode A = l1;
        ListNode B = l2;
        // 根节点
        ListNode rootNode = null;
        // 当前遍历节点
        ListNode current = null;
        ListNode zero = new ListNode(0);
        while (A != null || B != null) {
            A = A == null ? zero : A;
            B = B == null ? zero : B;
            int temp = 0;
            // 进位
            if (ten != 0) {
                temp = ten;
                ten = 0;
            }
            temp += (A.val + B.val);
            // 计算进位
            if (temp / 10 > 0) {
                ten = temp / 10;
                temp = temp % 10;
            }
            ListNode currentNode = new ListNode(temp);
            if (rootNode == null) {
                rootNode = currentNode;
                current = currentNode;
                // 继续遍历下一个节点
                A = A.next;
                B = B.next;
                continue;
            }
            // 设置上一个节点的下一个节点
            current.next = currentNode;
            // 设置当前节点
            current = currentNode;
            // 继续遍历下一个节点
            A = A.next;
            B = B.next;
        }
        // 补充进位节点
        if (ten != 0) {
            current.next = new ListNode(ten);
        }
        return rootNode;
    }

    static class ListNode {
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
