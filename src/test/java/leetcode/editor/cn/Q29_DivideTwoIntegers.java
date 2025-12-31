//给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。 
//
// 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。 
//
// 返回被除数 dividend 除以除数 divisor 得到的 商 。 
//
// 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−2³¹, 231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 2
//31 − 1 ；如果商 严格小于 -2³¹ ，则返回 -2³¹ 。 
//
// 
//
// 示例 1: 
//
// 
//输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = 3.33333.. ，向零截断后得到 3 。 
//
// 示例 2: 
//
// 
//输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= dividend, divisor <= 2³¹ - 1 
// divisor != 0 
// 
//
// Related Topics 位运算 数学 👍 1323 👎 0


package leetcode.editor.cn;

/**
 * 两数相除
 * @author Jingchong TU
 * @date 2025-12-31 09:57:23
 */
public class Q29_DivideTwoIntegers{
    public static void main(String[] args) {
        // main function for test
        Solution solution = new Q29_DivideTwoIntegers().new Solution();
    }

    // leetcode solution
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            int flag = 2;
            if (dividend > 0) {
                dividend = -dividend;
                flag--;
            }
            if (divisor > 0) {
                divisor = -divisor;
                flag--;
            }
            boolean negative = flag == 1;
            int result = 0;
            while (dividend <= divisor) {
                int quotient = 1, value = divisor;
                // 注意这里要比较的是 2 倍 value 的值和 dividend
                while (value >= 0xc0000000 && dividend <= value + value) {
                    value += value;
                    quotient += quotient;
                }
                dividend -= value;
                result += quotient;
            }
            return negative ? -result : result;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
