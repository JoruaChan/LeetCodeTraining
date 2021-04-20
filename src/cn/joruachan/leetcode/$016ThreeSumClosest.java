package cn.joruachan.leetcode;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 *
 * @author JoruaChan
 * @grade 中等
 * @solution
 */
public class $016ThreeSumClosest {
    // 我的思路：既然前面算过三数之和了，那就类似使用排序+双指针；

    public int threeSumClosest(int[] nums, int target) {
        // 先排序
        Arrays.sort(nums);

        int result = 10000000;
        for (int i = 0; i < nums.length - 2; i++) {
            // nums.length - 2是因为三个数, 最后两个数可以忽略循环
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 重复就继续下一个，因为重复判断了
                continue;
            }

            for (int m = i + 1, n = nums.length - 1; m < n; ) {
                if (m > i + 1 && nums[m] == nums[m - 1]) {
                    // 重复了，结束掉
                    ++m;
                    continue;
                }

                if (n < nums.length - 1 && nums[n] == nums[n + 1]) {
                    // 重复了，结束掉
                    --n;
                    continue;
                }

                int temp = nums[i] + nums[m] + nums[n];
                if (temp == target) {
                    // 直接等于结果
                    return target;
                }

                System.out.println(Math.abs(result-target));
                System.out.println(Math.abs(temp-target));
                if (Math.abs(result - target) > Math.abs(temp - target)) {
                    result = temp;
                }

                if (temp > target) {
                    // 大于的话，则将n-1
                    --n;
                } else {
                    // 小于的话，则将m+1
                    ++m;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new $016ThreeSumClosest().threeSumClosest(new int[]{-3,-2,-5,3,-4}, -1));
    }
}
