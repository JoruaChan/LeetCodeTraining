package cn.joruachan.leetcode;

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数 myAtoi(string s) 的算法如下：
 * <p>
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * <p>
 * 注意：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * <p>
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 *
 * @author JoruaChan
 * @grade 中等
 */
public class $008StringToIntegerAtoi {
    // 我的思路：遍历每个字符即可
    // 总结：可以利用图表的方式，画出状态机；了解全部状态流转后再去编写代码；
    // 如果要保证integer不溢出，可以使用long变量来控制并判断；

    public int myAtoi(String s) {
        char[] chars = s.toCharArray();

        boolean lessThanZero = false;
        boolean init = false;
        long value = 0;

        for (char aChar : chars) {
            if (!init && aChar == ' ') {
                // 忽略掉开头的全部空格
                continue;
            } else if (!init && (aChar == '+' || aChar == '-')) {
                // 忽略掉开头的空格后，第一个字符是+-
                lessThanZero = aChar == '-';
                init = true;
            } else if (Character.isDigit(aChar)) {
                init = true;

                int tempValue = (aChar - '0');
                value = value * 10 + tempValue;

                if (lessThanZero && value - 1 > (long) Integer.MAX_VALUE) {
                    // 因为都按照正数计算的，因为Integer.MIN_VALUE是-2^31，而最大值是2^31-1。
                    // 所以要判断值-1是否超过最大值即可
                    return Integer.MIN_VALUE;
                } else if (!lessThanZero && value > (long) Integer.MAX_VALUE) {
                    // 判断是否大于最大值
                    return Integer.MAX_VALUE;
                }
            } else {
                // 其他情况，则退出
                break;
            }
        }

        return (int) (lessThanZero ? -value : value);
    }

    public static void main(String[] args) {
        System.out.println(new $008StringToIntegerAtoi().myAtoi("20000000000000000000"));
    }
}
