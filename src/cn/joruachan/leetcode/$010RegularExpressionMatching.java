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

    // 更新思路：从尾部开始检测, 遇到.*, 再从正向判断；一直到全部字符验证过

    // TODO: 未解决
    public boolean isMatch(String s, String p) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new $010RegularExpressionMatching().isMatch("aaa", "a*a"));
    }

//    /**
//     * 两个指针，一个指针指向校验规则，一个指针指向比对的字符串<br>
//     * 从尾部循环，如果
//     *
//     * @param s 比对字符串
//     * @param p 校验规则
//     */
//    private boolean recycleFromTail(String s, String p) {
//        int sIndex = s.length() - 1, pIndex = p.length() - 1;
//        while (pIndex >= 0 && sIndex >= 0) {
//            if (p.charAt(pIndex) == '*') {
//                if (pIndex <= 0) {
//                    // 无法比对
//                    continue;
//                }
//
//                if (p.charAt(pIndex - 1) == '.') {
//                    // ".*"的情况
//                    sIndex = matchDotAndStar(s, p, sIndex, pIndex);
//                    pIndex -= 2;
//                } else {
//                    // "字符*"的情况
//                    sIndex = matchCharAndStar(s, p, sIndex, pIndex);
//                    pIndex -= 2;
//                }
//            } else if (p.charAt(pIndex) == '.') {
//                // .的情况
//                --sIndex;
//                --pIndex;
//            } else {
//                // 普通字符
//                if (p.charAt(pIndex) != s.charAt(sIndex)) return false;
//
//                --sIndex;
//                --pIndex;
//            }
//        }
//
//        // 都比对结束了
//        if (pIndex == 0 && sIndex == 0) return true;
//    }
//
//    /**
//     * 如果pIndex为*号,前个字符为普通字符, 后续比对的逻辑写在此
//     *
//     * @param s      比对字符串
//     * @param p      规则字符串
//     * @param sIndex 开始比对的下标
//     * @param pIndex 规则的下标
//     * @return 返回的是: <strong>比对字符不满足*前的下标;</strong>
//     */
//    private int matchCharAndStar(String s, String p, int sIndex, int pIndex) {
//        // *前面一个字符
//        char c = p.charAt(pIndex - 1);
//
//        // 普通字符, 则判断s前面有几个这样的字符
//        while (sIndex >= 0) {
//            if (s.charAt(sIndex) != c) return sIndex;
//            --sIndex;
//        }
//        return sIndex;
//    }
//
//    /**
//     * 如果pIndex为"*",前个字符为".", 后续比对的逻辑写在此
//     *
//     * @param s      比对字符串
//     * @param p      规则字符串
//     * @param sIndex 开始比对的下标
//     * @param pIndex 规则的下标
//     * @return 返回的是: <strong>比对字符不满足*前的下标;</strong>
//     */
//    private int matchDotAndStar(String s, String p, int sIndex, int pIndex) {
//        if (pIndex == 1) {
//            // .*开头, 其实不需要管了
//            return -1;
//        }
//
//        // .*前面的字符
//        char c = p.charAt(pIndex - 2);
//        if (c == '*') {
//            // 判断下前两个是否还是".*", 即连着的'.*', 其实就是一个.*
//            if (pIndex >= 3 && p.charAt(pIndex - 3) == '.') return sIndex;
//
//
//        } else if (c == '.'){
//
//        } else {
//            // 普通字符
//        }
//    }
}
