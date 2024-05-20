//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 3988 👎 0


package leetcode.editor.cn;

/**
 * 整数反转
 * @author Jingchong TU
 * @date 2024-05-19 13:44:16
 */
public class Q7_ReverseInteger{
	 public static void main(String[] args) {
	 	 // main function for test
	 	 // Solution solution = new Q7_ReverseInteger().new Solution();
	 }
	 
    // leetcode solution
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int positiveMaxComp = Integer.MAX_VALUE / 10;
            int positiveMaxRest = Integer.MAX_VALUE % 10;
            int negativeMaxComp = Integer.MIN_VALUE / 10;
            int negativeMAxRest = Integer.MIN_VALUE % 10;

            int result = 0;
            while (x != 0) {
                int rest = x % 10;
                if (result > positiveMaxComp
                        || result < negativeMaxComp
                        || (result == positiveMaxComp && rest > positiveMaxRest)
                        || (result == negativeMaxComp && rest < negativeMAxRest)) {
                    return 0;
                }
                result = result * 10 + rest;
                x = x / 10;
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}