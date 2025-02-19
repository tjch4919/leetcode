//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1625 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * @author Jingchong TU
 * @date 2024-05-26 11:40:07
 */
public class Q16_ThreeSumClosest{
	 public static void main(String[] args) {
	 	 // main function for test
	 	 Solution solution = new Q16_ThreeSumClosest().new Solution();
          solution.threeSumClosest(new int[] {-1,-2,1,4}, 0);
	 }
	 
    // leetcode solution
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int result = 0, minDiff = Integer.MAX_VALUE, nextRight = nums.length - 1;
            for(int i = 0; i < nums.length - 2; i++) {
                int x = nums[i];
                // 跳过重复值
                if (i > 0 && x == nums[i - 1]) {
                    continue;
                }
                // 本轮循环下最小值
                int s = x + nums[i + 1] + nums[i + 2];
                if (s > target) {
                    // 后面无论怎么选，选出的三个数的和不会比 s 还小
                    if (s - target < minDiff) {
                        result = s; // 由于下面直接 break，这里无需更新 minDiff }
                    }
                    break;
                }

                // 双指针
                int left = i + 1;
                int right = nextRight;
                while(left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    // 判断三数之和是否等于target
                    if (sum == target) {
                        return sum;
                    }

                    // 本轮内循环下最小值
                    int min = nums[i] + nums[left] + nums[left + 1];
                    if (target < min) {
                        if (minDiff > (min - target)) {
                            result = min;
                            minDiff = min - target;
                        }
                        break;
                    }

                    // 本轮内循环下最大值
                    int max = nums[i] + nums[right] + nums[right - 1];
                    if (target > max) {
                        if(minDiff > (target - max)) {
                            result = max;
                            minDiff = target - max;
                        }
                        break;
                    }

                    if (sum > target) {
                        if (sum - target < minDiff) {
                            // sum 与 target 更近
                            minDiff = sum - target;
                            result = sum;
                        }
                        right--;
                        // 跳过重复值
                        while(left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else{
                        if (target - sum < minDiff) {
                            // sum 与 target 更近
                            minDiff = target - sum;
                            result = sum;
                        }
                        if (left - i == 1) {
                            nextRight = right;
                        }
                        left++;
                        // 跳过重复值
                        while(left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    }
                }
            }
            return result;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}