package cn.joruachan.leetcode;

/**
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 *
 * @author JoruaChan
 * @grade 困难
 */
public class $025ReverseNodesInKGroup {
    // 我的思路：分组，然后组内排序，全部排序完再结合一起
    // 或者遍历一次，记录一个子链，长度达到k后反转，没达到就算了

    // TODO: 实现完成
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummyNode = new ListNode(0, head);
        ListNode next = dummyNode;

        // 上一批的末位node
        ListNode finalNode = null;

        int length = 0;
        while ((next = next.next) != null) {


            if (++length == k) {
                // 长度达到了k，就继续下一段
            }
        }

        return dummyNode.next;
    }
}
