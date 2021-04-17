package cn.joruachan.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符：I，V，X，L，C，D和M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * 输入: 3
 * 输出: "III"
 * <p>
 * 示例 2:
 * 输入: 4
 * 输出: "IV"
 * <p>
 * 示例 3:
 * 输入: 9
 * 输出: "IX"
 * <p>
 * 示例 4:
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * <p>
 * 示例 5:
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *  
 * <p>
 * 提示：
 * 1 <= num <= 3999
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 *
 * @author JoruaChan
 * @grade 中等
 * @solution 官方解法：贪心算法，就是每次都按照小于这个数的最大值匹配；通过设定好的数组来依次比对大小即可；
 */
public class $012IntegerToRoman {
    private static final Map<Integer, String> IntegerRomanMap;

    static {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        IntegerRomanMap = Collections.unmodifiableMap(map);
    }

    // 需要判断每一位的数字是多少，如果是1,4,5,9可以定下具体多少，否则需要再分解
    // 再分解的话，依旧是按照1,4,5,9拆分
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        int pow = 3;
        while (pow >= 0) {
            int powValue = (int) Math.pow(10, pow);
            int val = num / powValue;
            if (val != 0) {
                if (pow == 3) {
                    // 就按照n个1000来
                    for (int i = 0; i < val; i++) {
                        sb.append(IntegerRomanMap.get(powValue));
                    }
                } else {
                    // 需要拆分
                    int tem = val;
                    while (tem > 0) {
                        if (tem == 9) {
                            sb.append(IntegerRomanMap.get(9 * powValue));
                            tem = 0;
                        } else if (tem >= 5) {
                            // 拆成5+n
                            sb.append(IntegerRomanMap.get(5 * powValue));
                            tem -= 5;
                        } else if (tem == 4) {
                            sb.append(IntegerRomanMap.get(4 * powValue));
                            tem = 0;
                        } else {
                            for (int i = 0; i < tem; i++) {
                                sb.append(IntegerRomanMap.get(powValue));
                            }
                            tem = 0;
                        }
                    }
                }
                num -= val * powValue;
            }
            // 一位处理结束
            --pow;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new $012IntegerToRoman().intToRoman(1994));
    }
}
