//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 3127 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最长公共前缀
 * @author Jingchong TU
 * @date 2024-05-25 15:03:49
 */
public class Q14_LongestCommonPrefix{
	 public static void main(String[] args) {
	 	 // main function for test
	 	 // Solution solution = new Q14_LongestCommonPrefix().new Solution();
	 }
	 
    // leetcode solution
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String firstStr = strs[0];
            StringBuilder sb = new StringBuilder();
            int index = 0;
            boolean stopFlag = false;
            while (!stopFlag) {
                if (index == firstStr.length()) {
                    stopFlag = true;
                } else {
                    char c = firstStr.charAt(index);
                    if (isOtherStringWithSameChar(strs, c, index)) {
                        sb.append(c);
                        index++;
                    } else {
                        stopFlag = true;
                    }
                }
            }

            return sb.toString();
        }

        private boolean isOtherStringWithSameChar(String[] strs, char c, int index) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() == index) {
                    return false;
                }
                if (strs[i].charAt(index) != c) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}