package cn.joruachan.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 *
 * @author JoruaChan
 * @grade 中等
 */
public class $003LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
//        return exhaustive(s);
        return slidingWindow(s);
    }

    /**
     * 穷举
     *
     * @param s
     * @return
     */
    public int exhaustive(String s) {
        // 思路：从第一个字符开始，然后从前往后遍历
        // 使用HashSet来判断有没有重复字符
        if (s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int longestLength = 0;

        char[] sCharArray = s.toCharArray();

        Set<Character> hashSet = new HashSet<>();
        for (int i = 0; i < sCharArray.length; i++) {
            hashSet.add(sCharArray[i]);

            int temp = 1;
            for (int j = i + 1; j < sCharArray.length; j++) {
                if (hashSet.contains(sCharArray[j])) {
                    // 已经包含这个元素了
                    break;
                }

                // 不一样，就++
                temp++;
                hashSet.add(sCharArray[j]);
            }

            if (longestLength < temp) {
                longestLength = temp;
            }
            hashSet.clear();
        }

        return longestLength;
    }

    /**
     * 在上一次循环里找到了最长结果，下一次循环的时候可以在上次循环的基础上向后查找，
     * 从而减少循环次数。但是要记住，下一次循环的时候的下标已经被i++了。
     *
     * @param s
     * @return
     */
    public int slidingWindow(String s) {
        if (s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int longestLength = 0;
        char[] chars = s.toCharArray();

        int lastestLength = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (i != 0) {
                set.remove(chars[i - 1]);
            }

            lastestLength = lastestLength == 0 ? 0 : lastestLength - 1;

            // 判断i+lastestLength, 其实满足在上一轮循环的不重复，最后一个字符需要判断
            while (i + lastestLength < chars.length && !set.contains(chars[i + lastestLength])) {
                set.add(chars[i + lastestLength]);
                lastestLength++;
            }

            longestLength = longestLength < lastestLength ? lastestLength : longestLength;
        }

        return longestLength;
    }

    public static void main(String[] args) {
        System.out.println(new $003LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }
}
