package cn.joruachan.leetcode;

/**
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 *
 * @author JoruaChan
 * @grade 简单
 */
public class $027RemoveElement {
    // 我的思路：和26题一样，用快慢双指针来解决.
    // 慢指针指着已经处理过的，快指针就正常遍历
    public int removeElement(int[] nums, int val) {
        int fast, slow = -1;
        for (fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
