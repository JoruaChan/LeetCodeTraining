package cn.joruachan.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * 提示：
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 *
 * @author JoruaChan
 * @grade 简单
 * @solution 官方优秀解法：二叉查找，先找出数组中最短的长度，然后按照这个长度的一半去每个字符串看是否一致，如果一致继续往右边一半的一半看
 */
public class $014LongestCommonPrefix {
    // 我的思路：就是以第一个元素作为标准，一个个遍历看
    // TODO: 二叉查找
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < strs[0].length()) {
            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                String str = strs[i];

                if (index >= str.length()) return result.toString();
                if (str.charAt(index) != c) return result.toString();
            }

            result.append(c);
            index++;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new $014LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
