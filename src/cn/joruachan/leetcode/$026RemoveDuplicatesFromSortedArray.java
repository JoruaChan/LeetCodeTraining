package cn.joruachan.leetcode;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 *
 * @author JoruaChan
 * @grade 简单
 */
public class $026RemoveDuplicatesFromSortedArray {
    // 我的思路：不能使用SortedSet，那就只能一个个判断了啊..但是不太方便赋值，而且数组是有序的！

    // 官方解法：通过双指针，一个指针遍历，另一个指针用来表示排完序且无重复字段
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;

        int fast, slow = 0;
        for (fast = 1; fast < nums.length; fast++) {
            // slow指针指的是完成去重了的下标
            if (nums[fast] == nums[slow]) {
                // 一样，则slow不动
            } else {
                // 不一样，slow后移一位，并赋值
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;

//        int last = nums[0], duplicateStartIndex = -1, duplicateLength = 0;
//        for (int index = 1; index < nums.length; index++) {
//            if (nums[index] == last) {
//                if (duplicateStartIndex == -1) {
//                    duplicateStartIndex = index;
//                }
//
//                duplicateLength++;
//            } else {
//                if (duplicateStartIndex != -1) {
//                    // 前面字符重复了, 截断这些重复字符
//
//                }
//
//                duplicateStartIndex = -1;
//                duplicateLength = 0;
//            }
//        }
    }

}
