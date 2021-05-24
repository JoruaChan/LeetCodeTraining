package cn.joruachan.leetcode;

/**
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 *
 * @author JoruaChan
 * @grade 中等
 */
public class $002AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 思路：从尾部开始相加，如果大于10，则表示下一位要加一；
        // 要注意两个链表的长度可能不一致，而且也有可能一样长但是在最后进一位

        ListNode nextOfL1 = l1, nextOfL2 = l2;
        ListNode resultNode = null, tempNode = null;

        boolean over = false;
        while (nextOfL1 != null || nextOfL2 != null || over) {
            // 每一位计算的临时值
            int tempSum = (nextOfL1 == null ? 0 : nextOfL1.val) +
                    (nextOfL2 == null ? 0 : nextOfL2.val) + (over ? 1 : 0);

            ListNode node;
            if (over = tempSum > 9) {
                // 需要进位
                node = new ListNode(tempSum - 10);
            } else {
                node = new ListNode(tempSum);
            }

            if (resultNode == null) {
                // 初始化指定头结点
                resultNode = tempNode = node;
            } else {
                tempNode.next = node;
                tempNode = node;
            }

            nextOfL1 = nextOfL1 == null ? null : nextOfL1.next;
            nextOfL2 = nextOfL2 == null ? null : nextOfL2.next;
        }

        return resultNode;
    }
}
