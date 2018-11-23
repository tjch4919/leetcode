package com.priv.test.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

public class MedianOfTwoSortedArray {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Map<Integer, int[]> mapLength = new HashMap<Integer, int[]>();
        mapLength.put(nums1.length, nums1);
        mapLength.put(nums2.length, nums2);
        int maxLen = Math.max(nums1.length, nums2.length);
        int minLen = Math.min(nums1.length, nums2.length);
        Map<Double, int[]> mapMedian = new HashMap<Double, int[]>();
        double median1 = getMiddleNUmFromOneSortedArray(nums1);
        double median2 = getMiddleNUmFromOneSortedArray(nums2);
        mapMedian.put(median1, nums1);
        mapMedian.put(median2, nums2);
        double maxMedian = Math.max(median1, median2);
        double minMedian = Math.min(median1, median2);
        int[] bigMedianArr = mapMedian.get(maxMedian);
        int[] smallMedianArr = mapMedian.get(minMedian);
        if(median1 == median2) {
        	return median1;
        } else if (bigMedianArr[0]>=smallMedianArr[smallMedianArr.length-1]) {
        	return getMiddleNUmFromOneSortedArray((int[])ArrayUtils.addAll(smallMedianArr,bigMedianArr));
        }
        
        return 0.0;
    }
    
    public double getMiddleNUmFromOneSortedArray (int[] nums) {
        int length =nums.length;
        if (length%2==0){
            double a = nums[length/2-1];
            double b = nums[length/2];
            return (a+b)/2;
        } else {
            return nums[(length-1)/2];
        }
    }
}
