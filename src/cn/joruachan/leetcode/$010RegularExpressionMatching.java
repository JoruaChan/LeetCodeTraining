package cn.joruachan.leetcode;

/**
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例 2:
 * <p>
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 * <p>
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * <p>
 * 示例 5：
 * <p>
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length<= 20
 * 0 <= p.length<= 30
 * s可能为空，且只包含从a-z的小写字母。
 * p可能为空，且只包含从a-z的小写字母，以及字符.和*。
 * 保证每次出现字符* 时，前面都匹配到有效的字符
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 *
 * @author JoruaChan
 * @grade 困难
 * @date 2021-04-14 下午10:25
 */
public class $010RegularExpressionMatching {
    // 我的思路：一段段拆分，判断是否满足，直到不满足的
    // 尽最大可能满足，直到不满足则截断；

    // TODO: 未解决
    public boolean isMatch(String s, String p) {
        char[] sChars = s.toCharArray();
        int sIndex = 0;

        char[] pChars = p.toCharArray();
        int pIndex = 0;
        while (sIndex < sChars.length && pIndex < pChars.length) {
            if (sChars[sIndex] == pChars[pIndex]) {
                // 相等则继续下一个
                sIndex++;
                pIndex++;
            } else if (pChars[pIndex] == '.') {
                // 如果不相等，但是校验字符是.
                sIndex++;
                pIndex++;
            } else if (pChars[pIndex] == '*') {
                if (pIndex - 1 < 0) {
                    return false;
                }

                if (pIndex + 1 < pChars.length) {

                }

                // 如果不相等，但是校验字符是*。需要看下校验规则的前置字符
                // 前置字符不相等的话，由于*可以代表0个，所以也可以放过；
                if (pChars[pIndex - 1] == sChars[sIndex]) {
                    // 满足规则*前面的字符
                    sIndex++;
                } else if (pChars[pIndex - 1] == '.') {
                    // 如果后面只是.*，则没事
                    // 但是如果.*后面还有，则麻烦了
                    if (pIndex == pChars.length - 1) {
                        // 说明前面的都校验过了，然后校验规则末尾两个字符是：.*
                        return true;
                    } else if (sIndex == sChars.length - 1) {
                        // 虽然校验规则的字符没到末尾，但是被校验的字符到末尾了，不合格
                        return false;
                    } else {
                        // TODO: 如果.*后面还有，怎么处理
                        System.out.println("TODO");
                        sIndex++;
                    }
                } else {
                    // 因为*可以表示0个，所以让过，但是被校验的字符指针不能变
                    pIndex++;
                }
            } else {
                // 不相等，但是也不是./*, 看下校验规则是不是[某个字符]*
                if (pIndex + 1 < pChars.length && pChars[pIndex + 1] == '*') {
                    // 让他判断是不是满足*
                    pIndex++;
                } else {
                    return false;
                }
            }
        }

        // 能到这里说明，要么规则字符结束了，要么比较字符结束了。
        // 或者最后校验规则最后为*
        return sIndex == sChars.length && (pIndex == pChars.length || (pIndex == pChars.length - 1 && pChars[pIndex] == '*'));
    }

    public static void main(String[] args) {
        System.out.println(new $010RegularExpressionMatching().isMatch("aaa", "a*a"));
    }
}
