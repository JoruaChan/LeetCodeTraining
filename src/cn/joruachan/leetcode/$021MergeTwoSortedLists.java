package cn.joruachan.leetcode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例 1：
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 *
 * @author JoruaChan
 * @grade 简单
 */
public class $021MergeTwoSortedLists {
    // 我的思路，就是一个个连起来

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;

        while (l1 != null || l2 != null) {
            ListNode nextNode;
            if (l1 == null && l2 != null) {
                nextNode = l2;
                l2 = nextNode.next;
            } else if (l2 == null && l1 != null) {
                nextNode = l1;
                l1 = nextNode.next;
            } else {
                if (l1.val > l2.val) {
                    nextNode = l2;
                    l2 = nextNode.next;
                } else {
                    nextNode = l1;
                    l1 = nextNode.next;
                }
            }

            if (head == null) {
                head = tail = nextNode;
            } else {
                tail.next = nextNode;
                tail = nextNode;
            }
        }

        return head;
    }

    public static void main(String[] args) {
//        l1 = [1,2,4], l2 = [1,3,4]

        ListNode node1_3 = new ListNode(4, null);
        ListNode node1_2 = new ListNode(2, node1_3);
        ListNode node1_1 = new ListNode(1, node1_2);

        ListNode node2_3 = new ListNode(4, null);
        ListNode node2_2 = new ListNode(3, node2_3);
        ListNode node2_1 = new ListNode(1, node2_2);

        ListNode head = new $021MergeTwoSortedLists().mergeTwoLists(node1_1, node2_1);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
