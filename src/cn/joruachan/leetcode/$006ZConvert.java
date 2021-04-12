package cn.joruachan.leetcode;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *  
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * <p>
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 *
 * @author JoruaChan
 * @grade 中等
 */
public class $006ZConvert {
    // 题目理解：就是将字符串最终在二维数组中，按照字符顺序从纵向看过去的话，形成Z形

    public String convert(String s, int numRows) {
        return violentSolve(s, numRows);

        // TODO: 官方解法
    }

    /**
     * 暴力解法
     * 初始化二维数组，纵向处理完，处理横向，再处理纵向，循环；
     *
     * @param s
     * @param numRows
     * @return
     */
    private String violentSolve(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        char[] chars = s.toCharArray();

        // 计算一共多少列
        int m = chars.length / (2 * numRows - 2) * (numRows - 1);
        int n = chars.length % (2 * numRows - 2);
        if (n != 0) {
            if (n <= numRows) {
                m++;
            } else {
                m += (n - numRows + 1);
            }
        }

        // 初始化二维数组
        char[][] martix = new char[m][numRows];
        for (int i = 0; i < martix.length; i++) {
            for (int j = 0; j < martix[0].length; j++) {
                martix[i][j] = '-';
            }
        }

        int index = -1, x = 0;
        while (index < chars.length) {
            // 布置纵向的
            index = vertical(martix, x, numRows, chars, index);
            if (index == chars.length - 1) {
                // 结束了
                break;
            }

            if (numRows > 2) {
                // 布置横向的，只有大于两行的才需要布置横向的
                index = horizon(martix, x, numRows, chars, index);
                if (index == chars.length - 1) {
                    // 结束了
                    break;
                }
            }
            x += numRows - 1;
        }

        String result = "";

        // 二维数组int[a][b],理解成：一个数组下的元素又是一个数组；
        // a表示二维数组的数组长度；b表示元素数组的长度；
        // 图形化的理解：纵向的是一个元素数组，而横向的是二维数组的数组；
        for (int i = 0; i < martix[0].length; i++) {
            for (int j = 0; j < martix.length; j++) {
                if (martix[j][i] != '-') {
                    result += martix[j][i];
                }
            }
        }
        return result;
    }

    /**
     * 布置二维矩阵的纵向某列全部元素
     *
     * @param martix
     * @param x
     * @param numRows
     * @param chars
     * @param startIndex
     */
    private int vertical(char[][] martix, int x, int numRows, char[] chars, int startIndex) {
        int y = 0;
        while (startIndex < chars.length - 1 && y < numRows) {
            martix[x][y++] = chars[++startIndex];
        }
        return startIndex;
    }

    /**
     * 布置二维矩阵的横向斜线全部元素
     *
     * @param martix
     * @param x
     * @param numRows
     * @param chars
     * @param startIndex
     */
    private int horizon(char[][] martix, int x, int numRows, char[] chars, int startIndex) {
        int y = numRows - 2;

        while (startIndex < chars.length - 1 && y > 0) {
            martix[++x][y--] = chars[++startIndex];
        }
        return startIndex;
    }

    public static void main(String[] args) {
        System.out.println(new $006ZConvert().convert("PAYPALISHIRING", 4));
    }
}
