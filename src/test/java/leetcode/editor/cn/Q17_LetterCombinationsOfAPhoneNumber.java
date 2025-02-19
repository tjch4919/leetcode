//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2824 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 * @author Jingchong TU
 * @date 2024-05-26 14:16:33
 */
public class Q17_LetterCombinationsOfAPhoneNumber{
	 public static void main(String[] args) {
	 	 // main function for test
	 	 // Solution solution = new Q17_LetterCombinationsOfAPhoneNumber().new Solution();
	 }
	 
    // leetcode solution
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            Map<Character, String> phoneMap = Map.of(
                    '2', "abc",
                    '3', "def",
                    '4', "ghi",
                    '5', "jkl",
                    '6', "mno",
                    '7', "pqrs",
                    '8', "tuv",
                    '9', "wxyz"
            );
            List<String> combinations = new ArrayList<>();
            if (digits.length() == 0) {
                return combinations;
            }
            backtrack(combinations, phoneMap, digits, 0, new StringBuilder());
            return combinations;
        }

        private void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuilder combination) {
            if (index == digits.length()) {
                // when the combination is done it means no digit left
                combinations.add(combination.toString());
            } else {
                char digit = digits.charAt(index);
                String letters = phoneMap.get(digit);
                int lettersCount = letters.length();
                for (int i = 0; i < lettersCount; i++) {
                    combination.append(letters.charAt(i));
                    backtrack(combinations, phoneMap, digits, index + 1, combination);
                    // remove the last character
                    combination.deleteCharAt(index);
                }
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}