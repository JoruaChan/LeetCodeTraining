package cn.joruachan.leetcode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 *
 * @author JoruaChan
 * @grade 中等
 */
public class $024SwapNodesInPairs {
    // 我的思路：用几个引用循环交换; 或者两两一组交换

    // TODO: 递归解法
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;

        ListNode tail = null;
        ListNode node0 = head, node1;
        while (node0 != null) {
            node1 = node0.next;

            if (node1 == null) {
                // 只有一个元素，不需要交换了
                if (tail == null) {
                    // 第一次赋值, 并且没有后继结点了, 说明只有一个节点, 直接返回即可
                    return head;
                } else {
                    // tail不为空说明前面有两个成功交换的，指针需要接到node0
                    tail.next = node0;
                    return head;
                }
            } else {
                // 需要交换
                ListNode temp = node1.next;
                node1.next = node0;
                node0.next = temp;

                if (tail == null) {
                    // 第一次赋值，有两个元素，则node1作为头节点
                    head = node1;
                } else {
                    // tail不为空说明前面有两个成功交换的，指针指到node1
                    tail.next = node1;
                }

                // 更新指针到node0,作为完成交换的尾结点
                tail = node0;

                node0 = node0.next;
            }
        }

        return head;
    }
}
