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
            String longestPalindromic = "";
            if (s.length() == 1) {
                return s;
            }
            for (int i = 0, j = 1; j < s.length(); j++) {
                if (j > 1 && s.charAt(j) == s.charAt(j - 2)) {
                    int n = 1;
                    while ((n < j - i - 1) && (n <= s.length() - j) && s.charAt(j + n - 1) == s.charAt(j - n - 1)) {
                        if (n * 2 + 1 > longestPalindromic.length()) {
                            longestPalindromic = s.substring(j - n - 1, j + n);
                        }
                        n++;
                    }
                    i = j - n - 1;
                    j = j + n -1;
                } else if (s.charAt(j) == s.charAt(j - 1)) {
                    int n = 0;
                    while ((n < j - i) && (n < s.length() - j) && s.charAt(j - n - 1) == s.charAt(j + n)) {
                        if ((n + 1) * 2 > longestPalindromic.length()) {
                            longestPalindromic = s.substring(j - n - 1, j + n + 1);
                        }
                        n++;
                    }
                    i = j - n;
                    j = j + n -1;
                }
            }
            return longestPalindromic.length() > 0 ? longestPalindromic : s.substring(0, 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}