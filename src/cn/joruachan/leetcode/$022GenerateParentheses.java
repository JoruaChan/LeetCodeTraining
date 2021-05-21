package cn.joruachan.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *  
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 *
 * @author JoruaChan
 * @grade 中等
 */
public class $022GenerateParentheses {
    // 我的思路：n的结果其实可以根据n-1的结果来变种。
    // 如n=1, ()
    // 如n=2, 在1的结果左边加，得()(), 在1两边加得(())
    // 如n=3, 在2的结果左边加，得()()()和()(()), 右边加的()()()和(())(), 在两边加得(()())和((()))
    // (()()()) ()()()()

    // TODO: DFS解法？？
    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            List<String> list = new ArrayList<>();
            return list;
        } else if (n == 1) {
            List<String> list = new ArrayList<>();
            list.add("()");
            return list;
        }

        List<String> last = generateParenthesis(n - 1);
        List<String> result = new ArrayList<>();
        for (String string : last) {
            // 两边加
            result.add("(" + string + ")");

            // 左边加
            result.add("()" + string);

            // 右边加
            result.add(string + "()");
        }
        return result.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new $022GenerateParentheses().generateParenthesis(4));
    }
}
