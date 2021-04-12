package cn.joruachan.leetcode;

import java.util.Stack;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * <p>
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * <p>
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * <p>
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 *
 * @author JoruaChan
 * @grade 简单
 */
public class $007ReverseInteger {
    // 第一直觉，用栈实现。但是空间复杂度以及时间复杂度都不是很好；
    // TODO: 直接进行数据计算即可；

    public int reverse(int x) {
        return solveByStack(x);
    }

    private int solveByStack(int x) {
        if (x == 0) return 0;

        String s = x + "";

        // 先push到栈里
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        // 再出栈
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        s = result.toString();
        if (result.charAt(result.length() - 1) == '-') {
            // 负的
            result.deleteCharAt(result.length() - 1);
            s = "-" + result.toString();
        }

        // 反转后可能超过Integer最大值
        Long l = new Long(s);
        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) return 0;
        return l.intValue();
    }

    public static void main(String[] args) {
        System.out.println(new $007ReverseInteger().reverse(-2147483648));
    }
}
