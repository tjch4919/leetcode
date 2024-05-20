//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10130 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 * @author Jingchong TU
 * @date 2024-05-08 11:25:51
 */
public class Q3_LongestSubstringWithoutRepeatingCharacters{
	 public static void main(String[] args) {
	 	 // main function for test
	 	 // Solution solution = new Q3_LongestSubstringWithoutRepeatingCharacters().new Solution();
	 }
	 
    // leetcode solution
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            if (n == 0) {
                return 0;
            }
            // 这个map存的是某个字符的最大下标 + 1
            HashMap<Character, Integer> map = new HashMap<>();
            int max = 0;
            for (int i = 0, j = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    // i 为上次发生重复事件时第一个重复字符的下标 + 1
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                map.put(s.charAt(j), j + 1);
                max = Math.max(max, j - i + 1);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}