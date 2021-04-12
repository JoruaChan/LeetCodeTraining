package cn.joruachan.leetcode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 *
 * @author JoruaChan
 * @grade 中等
 * @date 2021-04-09 下午11:52
 */
public class $005LongestPalindrome {

    // 理解：回文子串，要求左右子串对称；可以利用栈的特点，先进栈再出栈；
    // 直到遇到栈中有重复的元素再出栈

    public String longestPalindrome(String s) {
        // TODO: 待解决
        return exhaustive(s);
    }

    /**
     * 穷举法解决, 以每个字符为中心, 判断最长的回文字符。
     *
     * @param s
     * @return
     */
    private String exhaustive(String s) {
        if (s.length() == 1) {
            return s;
        }

        String result = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int cycleCount = 0;

            // 先看下是不是跟右边的元素一样
            if (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                // 跟右边元素一致，则按照无中间元素判断
                while (i - cycleCount >= 0 && i + cycleCount + 1 < chars.length &&
                        chars[i - cycleCount] == chars[i + cycleCount + 1]) {
                    // 下标不越界，并且左右两边相等
                    ++cycleCount;
                }

                --cycleCount;

                String temp = s.substring(i - cycleCount, i + cycleCount + 2);
                if (temp.length() > result.length()) {
                    result = temp;
                }
            } else {
                // 跟右边的元素不一致，则以这个元素为中间元素，判断左边是否等于右边
                while (i - cycleCount >= 0 && i + cycleCount < chars.length &&
                        chars[i - cycleCount] == chars[i + cycleCount]) {
                    // 下标不越界，并且左右两边相等
                    ++cycleCount;
                }

                --cycleCount;

                String temp = s.substring(i - cycleCount, i + cycleCount + 1);
                if (temp.length() > result.length()) {
                    result = temp;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new $005LongestPalindrome().longestPalindrome("cbbd"));
    }
}
