package cn.joruachan.leetcode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 *
 * @author JoruaChan
 */
public class $019RemoveNthNodeFromEndOfList {

    // 我的思路：压到栈中，然后拿出来
    // 另外一个思路是看了标签提示想到：双指针，一个指针A在头部，另一个指针B间隔N个.当B到尾部的时候，A的位置就是倒数N的元素

    public ListNode removeNthFromEnd(ListNode head, int n) {
//        return selfSolution(head, n);

        ListNode dummy = new ListNode(0, head);

        // 先将第一个指针移到n的位置
        ListNode firstNode = head;
        ListNode secondNode = dummy;
        for (int i = 0; i < n; i++) {
            firstNode = firstNode.next;
        }

        while (firstNode != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        secondNode.next = secondNode.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    // 没完全解决出来
    private ListNode selfSolution(ListNode head, int n) {
        ListNode first = head, second = head;

        // first先遍历n次，second再遍历
        int index = 1;
        while (first != null) {
            if (index >= n) {
                second = second.next;
            }

            first = first.next;
        }


//        ListNode cycleNode = head;
//        ListNode pointNode = null;
//
//        int index = 1;
//        for (; cycleNode != null; index++) {
//            if (index == n + 1) {
//                // 必须要n+1，因为你要到找到前一个
//                pointNode = head;
//            }
//
//            cycleNode = cycleNode.next;
//            if (index > n + 1) {
//                pointNode = pointNode.next;
//            }
//        }
//
//        if (pointNode == null) {
//            if (index == n){
//                // 如果就是最后一个
//            }
//            // 说明index还没达到n+1就结束了
//            return null;
//        }
//
        ListNode deleteNode = second.next;
        second.next = deleteNode.next;
        deleteNode = null;

        return head;
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

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode node = new $019RemoveNthNodeFromEndOfList().removeNthFromEnd(node1, 5);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
