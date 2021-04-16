package cn.joruachan.leetcode;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例 2：
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * <p>
 * 示例 4：
 * <p>
 * 输入：height = [1,2,1]
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 *
 * @author JoruaChan
 * @grade 中等
 * @solution 通过双指针的方式，但是需要明白值小的指针往另一侧移动的推理过程
 */
public class $011ContainerWithMostWater {
    // 两个指针，指向头尾，然后将指针对应的值较小的那个指针往另个指针方向移动；
    // 至于为什么将值小的指针移动，可以假定移动值大的一边，会发现【移动后的结果肯定比之前的小】

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int result = 0;
        while (left != right) {

            int area;
            if (height[left] >= height[right]) {
                // 左边大, 移动右边
                area = height[right] * (right - left);
                --right;
            } else {
                // 右边大，移动左边
                area = height[left] * (right - left);
                ++left;
            }

            if (result < area) result = area;
        }
        return result;
    }
}
