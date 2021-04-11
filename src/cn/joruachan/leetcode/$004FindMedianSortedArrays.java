package cn.joruachan.leetcode;

import java.util.Arrays;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * <p>
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * <p>
 * 示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 *
 * @author JoruaChan
 * @grade 困难
 * @date 2021-04-09 下午10:39
 */
public class $004FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        return copyAndSort(nums1, nums2);
        return compareAndMove(nums1, nums2);

        // TODO: 官方的解决方案
    }

    /**
     * 最简单的方式，利用JDK自带的方法，拷贝到新数组，再排序，最后取中间值
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private double copyAndSort(int[] nums1, int[] nums2) {
        int[] newArrays = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, newArrays, 0, nums1.length);
        System.arraycopy(nums2, 0, newArrays, nums1.length, nums2.length);

        Arrays.sort(newArrays);

        int half = newArrays.length / 2;
        if (newArrays.length % 2 == 0) {
            return (newArrays[half - 1] + newArrays[half]) / 2.;
        } else {
            return newArrays[half];
        }
    }

    /**
     * 两个数组都有一个指针，然后指针对应的元素两两判断，哪个指针的元素值小则向后移
     * 新建一个数组（大小可知）, 一直到移动了第(m+n)/2 + 1次.
     * 最后从数组中得出结果即可
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private double compareAndMove(int[] nums1, int[] nums2) {
        // 我的思路：找到第(m+n)/2个大的元素；
        // 两个数组都有一个指针，然后指针对应的元素两两判断，哪个指针的元素值小则向后移
        // 一直到移动了第(m+n)/2次.需要记录下上一次的值

        int p1 = 0, p2 = 0;

        int half = (nums1.length + nums2.length) / 2;
        int[] newArray = new int[half + 1];
        int index = 0;

        while (index <= half) {
            if (p1 == nums1.length || nums1[p1] >= nums2[p2]) {
                // nums1到最后了，则从p2后取出
                // p1大于p2的值，将p2后移
                // 相等的话，其实随便移动一个即可
                newArray[index++] = nums2[p2];
                p2++;
            } else if (p2 == nums2.length || nums1[p1] < nums2[p2]) {
                // nums2到最后了，则从p1后取出
                // p2大于p1的值，将p1后移
                newArray[index++] = nums1[p1];
                p1++;
            }
        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            return (newArray[half] + newArray[half - 1]) / 2.;
        } else {
            return newArray[half];
        }
    }

    public static void main(String[] args) {
        System.out.println(new $004FindMedianSortedArrays().compareAndMove(new int[]{1, 2}, new int[]{3, 4}));
    }
}