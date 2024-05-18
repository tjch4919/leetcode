//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7107 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 寻找两个正序数组的中位数
 * @author Jingchong TU
 * @date  2024-05-08 20:35:50
 */
public class Q4_MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        // main function for test
        // Solution solution = new Q4_MedianOfTwoSortedArrays().new Solution();
        // int[] nums1 = {1, 3};
        // int[] nums2 = {2, 7};
        // System.out.println(solution.findMedianSortedArrays(nums1, nums2));

    }

    // leetcode solution
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            if (m > n) {
                return findMedianSortedArrays(nums2, nums1);
            }
            int iMin = 0, iMax = m;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                int j = (m + n + 1) / 2 - i;
                // i 由二分法获取， 但应该注意不能到边界
                if (i != m && j != 0 && nums2[j - 1] > nums1[i]) {
                    iMin = i + 1;
                } else if (i != 0 && j != n && nums1[i - 1] > nums2[j]) {
                    iMax = i - 1;
                } else {
                    int maxLeft = 0;
                    if (i == 0) {
                        maxLeft = nums2[j - 1];
                    } else if (j == 0) {
                        maxLeft = nums1[i - 1];
                    } else {
                        maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                    }
                    if ((m + n) % 2 != 0) {
                        return maxLeft;
                    }
                    int minRight = 0;
                    if (i == m) {
                        minRight = nums2[j];
                    } else if (j == n) {
                        minRight = nums1[i];
                    } else {
                        minRight = Math.min(nums1[i], nums2[j]);
                    }
                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0.0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}