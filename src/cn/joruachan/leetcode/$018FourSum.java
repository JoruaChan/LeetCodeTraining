package cn.joruachan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：答案中不可以包含重复的四元组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 *
 * @author JoruaChan
 * @grade 中等
 * @solution
 */
public class $018FourSum {
    // 我的思路：跟三数之和类似，先排序，经过两轮


    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 先排序
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();
        for (int i0 = 0; i0 < nums.length - 3; i0++) {
            if (i0 > 0 && nums[i0] == nums[i0 - 1]) {
                // 和前一个重复了
                continue;
            }

            if (nums[i0] + nums[i0 + 1] + nums[i0 + 2] + nums[i0 + 3] > target) {
                // 最开始的4个已经大于target
                continue;
            }

            if (nums[i0] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                // 和尾部3个相加都小于target
                continue;
            }

            for (int i1 = i0 + 1; i1 < nums.length - 2; i1++) {
                if (nums[i1] == nums[i1 - 1]) {
                    // 和前一个重复了
                    continue;
                }

                int numi0i1 = nums[i0] + nums[i1];
                if (numi0i1 + nums[i1 + 1] + nums[i1 + 2] > target) {
                    // 头2已经大于target
                    continue;
                }

                if (numi0i1 + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    // 尾部2个相加都小于target
                    continue;
                }

                int left = i1 + 1, right = nums.length - 1;
                int lValue, rValue;
                while (left < right) {
                    lValue = nums[left];
                    rValue = nums[right];

                    int sum = numi0i1 + lValue + rValue;
                    if (sum > target) {
                        // 右指针向左移，直到找到不一样的
                        while (nums[--right] == rValue) {
                        }
                    } else if (sum < target) {
                        // 左指针向右移，直到找到不一样的
                        while (nums[++left] == lValue) {
                        }
                    } else {
                        List<Integer> result = new ArrayList<>();
                        result.add(i0);
                        result.add(i1);
                        result.add(left);
                        result.add(right);

                        results.add(result);
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(new $018FourSum().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
