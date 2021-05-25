package cn.joruachan.leetcode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 *
 * @author JoruaChan
 * @grade 困难
 */
public class $023MergeKSortedLists {
    // 我的思路：分治法，两两比较，最后合并结果

    // TODO:使用分治法+迭代
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        $021MergeTwoSortedLists mergeTwoSortedLists = new $021MergeTwoSortedLists();
        ListNode node = mergeTwoSortedLists.mergeTwoLists(lists[0], lists[1]);

        for (int i = 2; i < lists.length; i++) {
            node = mergeTwoSortedLists.mergeTwoLists(node, lists[i]);
        }

        return node;
    }

    public static void main(String[] args) {
        ListNode node = new $023MergeKSortedLists().mergeKLists(new ListNode[]{});
        while ((node = node.next) != null) {
            System.out.print(node.val + " ");
        }
    }
}
