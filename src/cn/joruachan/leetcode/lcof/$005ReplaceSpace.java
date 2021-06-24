package cn.joruachan.leetcode.lcof;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 *
 * @author JoruaChan
 * @grade 简单
 */
public class $005ReplaceSpace {
    // 我的思路：循环替换就是咯。。。
    public String replaceSpace(String s) {
        char[] newChar = new char[s.length() * 3];

        int writeIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                newChar[writeIndex++] = '%';
                newChar[writeIndex++] = '2';
                newChar[writeIndex++] = '0';
            } else {
                newChar[writeIndex++] = s.charAt(i);
            }
        }
        return new String(newChar, 0, writeIndex);
    }
}
