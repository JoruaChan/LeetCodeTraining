package cn.joruachan.leetcode;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 示例 4：
 * <p>
 * 输入：x = -101
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * -2^31 <= x <= 2^31 - 1
 * <p>
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 *
 * @author JoruaChan
 * @grade 简单
 */
public class $009PalindromeNumber {
    // 第一思路：只需要判断正数；然后看一共多少位； 再从中间扩散判断是否为回文数字
    // TODO: 官方解决办法

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0 || x < 10) return true;

        int length = Integer.valueOf(x).toString().length();

        // i表示首位，j表示末位
        int count = 0;
        int left = 0, right = 0;
        while (count <= length / 2) {
            int l = (int) (x / Math.pow(10, length - count - 1));
            int r = (int) (x % Math.pow(10, count + 1));

            if (l - left * 10 != (r - right) / Math.pow(10, count)) return false;

            left = l;
            right = r;

            count++;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new $009PalindromeNumber().isPalindrome(1001));
    }
}
