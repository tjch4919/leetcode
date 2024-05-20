//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 示例 1： 
//
// 
//输入：s = "aa", p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa", p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab", p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 20 
// s 只包含从 a-z 的小写字母。 
// p 只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
//
// Related Topics 递归 字符串 动态规划 👍 3896 👎 0


package leetcode.editor.cn;

/**
 * 正则表达式匹配
 * @author Jingchong TU
 * @date 2024-05-19 15:27:25
 */
public class Q10_RegularExpressionMatching{
	 public static void main(String[] args) {
	 	 // main function for test
	 	 Solution solution = new Q10_RegularExpressionMatching().new Solution();
          solution.isMatch("aa", "a*");
	 }
	 
    // leetcode solution
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            char[] sChars = s.toCharArray();
            char[] pChars = p.toCharArray();
            // 选择动态规划策略，f下记录的是给定s和p，字符串s中前i个字符组成的字符子串对于p正则中前j个字符组成的子正则表达式是否匹配
            // 最终结果为f[sChars.length][pChars.length]，即全长
            boolean[][] f = new boolean[sChars.length + 1][pChars.length + 1];
            for (int i = 0; i <= sChars.length; i++) {
                for (int j = 0; j <= pChars.length; j++) {
                    if (j == 0) {
                        /*
                         * 对于pattern长度为0的情况，只有当s长度也为0时我们认为可以完全匹配，否则赢认为不匹配，
                         * 很好理解：s为“qb”，而p为空，由此固然为false
                         */
                        f[i][j] = i == 0;
                    } else if (i == 0) {
                        /*
                         * 对于s长度为0，而pattern不为0的情况，应做如下考虑：s为“”，而只有如下情况应考虑为可匹配：
                         * 1. pattern字符串在双数位j（下标+1）为‘*’时，它的前置位（f[0][j-2]）也为true则这一位f[0][j]为true
                         * 2. 其他情况则认为为false
                         * 考虑以下例子：
                         * s=“” p=“a*b*ccd*”
                         * f[0][0]为true，f[0][1]为false，f[0][2]为true（a*可以代指0个即空字符串）
                         * 同理f[0][3]为false，f[0][4]为true，
                         * f[0][5]为false，但是在第6位为‘c’，所以它强制要求了必须要有“cc”出现，这导致了之后所有位为false
                         * 所以f[0][6]为false，f[0][7]为false，f[0][8]本来符合双数位为‘*’的规定，但它的前置位f[0][6]为false
                         * 它也只能为false
                         */
                        f[i][j] = j % 2 == 0 && f[i][j - 2] && pChars[j - 1] == '*';
                    } else {
                        if (pChars[j - 1] == '*') {
                            /*
                             * 当对比到当前位置pattern以‘*’结尾时，我们可以首先看它的前置位f[i][j - 2]，并结合当前位置看，分以下情况：
                             * 1. 如果pattern的前一位与s的当前位字符匹配（‘.’默认认为绝对匹配），那么应考虑结合s除去最后一位的子串与当前pattern
                             * 的匹配性f[i - 1][j]再并上前置位f[i][j - 2]匹配性
                             * 2. 如果pattern的前一位与s的当前位字符不匹配，那么它只能寄希望于当前字符串与前置位f[i][j - 2]匹配，否则就不匹配
                             *
                             * 如以下例子：
                             * s=“abcc”，p=“abc*d*”，它等价于匹配s=“abcc”，p=“abc*”（f[4][6]<=>f[4][4]，因为s[3]！=p[4]）
                             * 再考虑f[4][4]，因为s[3]==p[2]==‘c’，所以要结合f[3][4]和f[4][2]考虑，f[3][4]对应s=“abc”，p=“abc*”
                             * 又因为s[2]==p[2]==‘c’.所以要结合f[2][4]和f[3][2]考虑，f[2][4]对应s=“ab”，p=“abc*”，由于s[1]！=p[2]
                             * 所以f[2][4]的值为f[2][2]的值，即s=“ab”，p=“ab”，容易看出二者匹配，f[2][2]=true -> f[2][4]=true
                             * -> f[3][4]=true -> f[4][4]=true -> f[6][4]=true
                             */
                            f[i][j] = f[i][j - 2];
                            if (pChars[j - 2] == '.' || sChars[i - 1] == pChars[j - 2]) {
                                f[i][j] = f[i][j] || f[i - 1][j];
                            }
                        } else {
                            /*
                             * 若当前位置pattern不以‘*’结尾时，我们则应该比较s与p的最后一位，如果二者不等，则不匹配，如果相当，则
                             * f[i][j] = f[i - 1][j - 1];
                             */
                            if (pChars[j - 1] == '.' || sChars[i - 1] == pChars[j - 1]) {
                                f[i][j] = f[i - 1][j - 1];
                            } else {
                                f[i][j] = false;
                            }
                        }
                    }
                }
            }
            return f[sChars.length][pChars.length];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}