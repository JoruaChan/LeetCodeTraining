package cn.joruachan.leetcode;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 *
 * @author JoruaChan
 * @grade 中等
 * @solution
 */
public class $017LetterCombinationsOfPhoneNumber {
    // 我的思路：用map存储数字与字母对应关系，然后两两组合

    private final static Map<Integer, List<String>> MAP = new HashMap<>();

    static {
        MAP.put(2, Arrays.asList("a", "b", "c"));
        MAP.put(3, Arrays.asList("d", "e", "f"));
        MAP.put(4, Arrays.asList("g", "h", "i"));
        MAP.put(5, Arrays.asList("j", "k", "l"));
        MAP.put(6, Arrays.asList("m", "n", "o"));
        MAP.put(7, Arrays.asList("p", "q", "r", "s"));
        MAP.put(8, Arrays.asList("t", "u", "v"));
        MAP.put(9, Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        // 如果长度为0, 直接返回
        if (digits.length() == 0) return new ArrayList<>();

        // 如果长度为1, 从map中取即可
        if (digits.length() == 1) return MAP.get(digits.charAt(0) - '0');

        // 初始化下数据
        List<String> last = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            if (i == 0) {
                // 第一次就初始化下
                last.addAll(MAP.get(digits.charAt(0) - '0'));
                continue;
            }

            List<String> strings = MAP.get(digits.charAt(i) - '0');

            List<String> newStrings = new ArrayList<>(strings.size() * last.size());
            for (String s0 : strings) {
                for (String s1 : last) {
                    newStrings.add(s1 + s0);
                }
            }
            last = newStrings;
        }
        return last;
    }

    public static void main(String[] args) {
        System.out.println(new $017LetterCombinationsOfPhoneNumber().letterCombinations("2689"));
    }
}
