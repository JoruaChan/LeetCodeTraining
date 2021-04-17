package cn.joruachan.leetcode;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 *
 * @author JoruaChan
 * @grade 简单
 * @solution 官方优秀解法：排序+双指针
 */
public class $015ThreeSum {
    // 我的思路，既然三数之和为0，必须有正有负，那么就先排序。
    // 先从负的选出来一个，必须从正的那边选一个

    // TODO: 官方解法

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();

        List<Integer> less0Nums = new ArrayList<>();
        List<Integer> more0Nums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) less0Nums.add(nums[i]);
            else more0Nums.add(nums[i]);
        }

        // 先得到负负、正正两个数的结果；
        Map<Integer, Set<List<Integer>>> map = new HashMap<>();
        sumOfEachOther(map, less0Nums);
        sumOfEachOther(map, more0Nums);

        // 循环数组的每个元素, 再从map中取出来即可
        Set<List<Integer>> results = new HashSet<>();
        for (int num : nums) {
            Set<List<Integer>> groups = map.get(-num);
            if (groups != null) {
                for (List<Integer> group : groups) {
                    List<Integer> result = new ArrayList<>(group);
                    result.add(num);
                    results.add(result);
                }
            }
        }
        return new ArrayList<>(results);
    }

    // 将数组中的元素两两相加
    private void sumOfEachOther(Map<Integer, Set<List<Integer>>> map, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                Integer integer = list.get(i) + list.get(j);
                Set<List<Integer>> lists = map.get(integer);
                if (lists == null) {
                    lists = new HashSet<>();
                    map.put(integer, lists);
                }
                lists.add(Arrays.asList(list.get(i), list.get(j)));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new $015ThreeSum().threeSum(new int[]{-1,0,1,0}));
    }
}
