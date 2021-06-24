package cn.joruachan.leetcode.lcof;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 *
 * @author JoruaChan
 * @grade 中等
 */
public class $004FindNumberIn2DArray {
    // 我的思路：由于每列和每行都是有小到大的，那么从左下角的元素开始找，比它小则往上找，比它则往右找
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        return find(matrix, target, matrix.length - 1, 0);
    }

    private boolean find(int[][] matrix, int target, int m, int n) {
        if (m < 0 || n >= matrix[0].length) return false;

        if (matrix[m][n] == target) return true;

        if (matrix[m][n] > target) {
            m--;
        } else {
            n++;
        }

        return find(matrix, target, m, n);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[1][2];
        matrix[0] = new int[]{-1, 3};

        System.out.println(new $004FindNumberIn2DArray().findNumberIn2DArray(matrix, 3));
    }
}
