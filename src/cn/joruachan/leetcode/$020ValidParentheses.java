package cn.joruachan.leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 * <p>
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 *
 * @author JoruaChan
 * @grade 简单
 * @solution
 */
public class $020ValidParentheses {
    // 错误思路：感觉和回文字符串类似。再审题，括号肯定有左右，所以必定偶数。从中间的字符向两边校验即可。 问题：括号是对称的，而非相等。
    // 正确思路：用栈来接收，FILO，匹配上了则移除，匹配不上则入栈
    public boolean isValid(String s) {
        // 不是偶数，肯定不对称了
        if (s.length() % 2 != 0) return false;

        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            // 当上一个和这个字符能成括号，则移除
            if (stack.isEmpty()) {
                stack.push(aChar);
            } else {
                char lastChar = stack.peek();
                if (aChar == ']' && lastChar == '[') {
                    stack.pop();
                } else if (aChar == '}' && lastChar == '{') {
                    stack.pop();
                } else if (aChar == ')' && lastChar == '(') {
                    stack.pop();
                } else {
                    // 其他情况则入栈
                    stack.push(aChar);
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new $020ValidParentheses().isValid("()[]{}"));
    }
}
