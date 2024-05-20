//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 7199 👎 0


package leetcode.editor.cn;

/**
 * 最长回文子串
 * @author Jingchong TU
 * @date 2024-05-09 10:59:31
 */
public class Q5_LongestPalindromicSubstring{
	 public static void main(String[] args) {
	 	 // main function for test
         // Solution solution = new Q5_LongestPalindromicSubstring().new Solution();
         //  System.out.println(solution.longestPalindrome("ccc"));
	 }
	 
    // leetcode solution
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() == 0) {
                return s;
            }
            int maxLength = 0;
            String longestPalindrome = "";
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int oddRadius = getLongestPalindromeRadiusOfCenter(chars, i, i);
                if (2 * oddRadius - 1 > maxLength) {
                    maxLength = 2 * oddRadius - 1;
                    longestPalindrome = s.substring(i - oddRadius + 1, i + oddRadius);
                }
                int pairRadius = i == chars.length - 1 ? 0 : getLongestPalindromeRadiusOfCenter(chars, i, i + 1);
                if (2 * pairRadius > maxLength) {
                    maxLength = 2 * pairRadius;
                    longestPalindrome = s.substring(i - pairRadius + 1, i + pairRadius + 1);
                }
            }
            return longestPalindrome;
        }

        private int getLongestPalindromeRadiusOfCenter(char[] s, int leftIndex, int rightIndex) {
            int length = 0;
            for (int i = 0; leftIndex - i >=0 && rightIndex + i < s.length; i++) {
                if (s[leftIndex - i] == s[rightIndex + i]) {
                    length++;
                } else {
                    break;
                }
            }
            return length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}