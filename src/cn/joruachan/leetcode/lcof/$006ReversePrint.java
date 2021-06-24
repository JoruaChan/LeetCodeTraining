package cn.joruachan.leetcode.lcof;

import cn.joruachan.leetcode.ListNode;

import java.util.List;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制： 0 <= 链表长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 *
 * @author JoruaChan
 * @grade 简单
 */
public class $006ReversePrint {
    // 我的思路：将节点反转或者获取值再反转。
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];

        ListNode dummy = new ListNode(0, head);

        int length = 1;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            ListNode nextNext = nextNode.next;

            ListNode node = dummy.next;
            if (node == head) {
                // 把原先的链给清掉
                head.next = null;
            }

            nextNode.next = node;
            dummy.next = nextNode;
            nextNode = nextNext;

            length++;
        }

        nextNode = dummy.next;
        int index = 0;
        int[] values = new int[length];
        while (nextNode != null) {
            values[index++] = nextNode.val;
            nextNode = nextNode.next;
        }
        return values;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(2, null);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println(new $006ReversePrint().reversePrint(node1));
    }
}
