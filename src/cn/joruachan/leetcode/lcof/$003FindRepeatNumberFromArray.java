package cn.joruachan.leetcode.lcof;

/**
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 *
 * @author JoruaChan
 * @grade 简单
 */
public class $003FindRepeatNumberFromArray {
    // 我的思路：hash(集合)遍历一次即可;
    // 优化思路：由于所有数字都在0~n-1之间，那就再建个数组
//    public int findRepeatNumber(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            if (set.contains(num)) {
//                return num;
//            }
//
//            set.add(num);
//        }
//        return -1;
//    }

    public int findRepeatNumber(int[] nums) {
        int[] ints = new int[nums.length];
        // ints数组元素0表示没有数字，1表示有了。下标表示这个数字大小
        for (int num : nums) {
            if (ints[num] == 1) {
                return num;
            }
            ints[num] = 1;
        }
        return -1;
    }
}
