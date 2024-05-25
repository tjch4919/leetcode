//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 6887 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 三数之和
 * @author Jingchong TU
 * @date 2024-05-25 15:31:22
 */
public class Q15_ThreeSum{
	 public static void main(String[] args) {
	 	 // main function for test
	 	 Solution solution = new Q15_ThreeSum().new Solution();
          solution.threeSum(new int[]{-1,0,1,2,-1,-4});
	 }
	 
    // leetcode solution
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            int length = nums.length;
            //先排序，然后双指针
            Arrays.sort(nums);
            if (nums[0] > 0 || nums[length - 1] <0) {
                return Collections.emptyList();
            }
            List<List<Integer>> list = new ArrayList<>();
            // i 代表第一个数下标，nextK代表当i后移一位后最大值下标应为哪个数，lastIVal表示上一个循环
            // 的i下标对应的值
            int i = 0, nextK = length - 1, lastIVal = Integer.MAX_VALUE;
            while (i < length - 2) {
                // 遍历i，如果当前i下标对应的值已经出现，则直接往后移动i指针
                if (lastIVal == nums[i]) {
                    i++;
                    continue;
                }
                // j 为中间数对应的下标，每次循环考虑i的后一位，k则设立为上一个循环确立的nextK值
                // lastJVal 表示上一个内循环处理过的j下标对应的值
                int j = i + 1, k = nextK, lastJVal = Integer.MAX_VALUE;
                while (j < k) {
                    // 如果当前j下标对应的值在上一轮内循环处理过，则应该后移j指针
                    if (nums[j] == lastJVal) {
                        j++;
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] > 0) {
                        // 对于三者之和大于0的情况，我们可以把k指针前移一位
                        k--;
                    } else if (nums[i] + nums[j] + nums[k] == 0) {
                        // 对于三者之和等于0的情况，我们首先把三个元素加入结果中
                        list.add(List.of(nums[i], nums[j], nums[k]));
                        if (j - i == 1) {
                            // 如果j指针是初始位置，则确认下一个外循环的k值为当前k指针前一位，因为
                            // 下一轮i指针和j指针对应的数之和一定比当前的nums[i]+nums[j]大，所以应该前移一位
                            nextK = k - 1;
                        }
                        // 记录下移动j指针前处理过的j指针对应值
                        lastJVal = nums[j];
                        j++;
                        // 因为j指针后移，ums[i] + nums[j]变大 所以k指针应该前移一位
                        k--;
                    } else {
                        if (j - i == 1) {
                            // 对于三者之和小于0的情况，由k指针移动方向确定，在上一次j指针移动之后的几轮内循环一定
                            // 都是nums[i] + nums[j] + nums[k] > 0 的情况，所以如果 当前j为内循环初始位，则下一轮
                            // 外循环时的k初始值应该比k+1小，且必须考虑第k位正好在下一个i确定时能匹配上
                            nextK = k;
                        }
                        // 因为k指针再往前移一定都是小于0的情况，所以应该将j指针后移，并记录移动前j指针对应的值
                        lastJVal = nums[j];
                        j++;
                    }
                }
                // 一次外循环即将结束，在移动i指针前记录下对应的值
                lastIVal = nums[i];
                i++;
            }
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}