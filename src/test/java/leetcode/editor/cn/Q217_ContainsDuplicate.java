//给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,3,1] 
// 
//
// 输出：true 
//
// 解释： 
//
// 元素 1 在下标 0 和 3 出现。 
//
// 示例 2： 
//
// 
// 输入：nums = [1,2,3,4] 
// 
//
// 输出：false 
//
// 解释： 
//
// 所有元素都不同。 
//
// 示例 3： 
//
// 
// 输入：nums = [1,1,1,3,3,4,3,2,4,2] 
// 
//
// 输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 排序 👍 1114 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 * @author Jingchong TU
 * @date 2025-02-18 22:21:41
 */
public class Q217_ContainsDuplicate{
	 public static void main(String[] args) {
	 	 // main function for test
	 	 // Solution solution = new Q217_ContainsDuplicate().new Solution();
	 }
	 
    // leetcode solution
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}