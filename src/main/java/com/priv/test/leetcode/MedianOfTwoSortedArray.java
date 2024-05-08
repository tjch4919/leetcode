package com.priv.test.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MedianOfTwoSortedArray {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1.length==0) return getMiddleNUmFromOneSortedArray(nums2);
		if(nums2.length==0) return getMiddleNUmFromOneSortedArray(nums1);
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
        	int[] result = new int[maxLen+minLen];
        	System.arraycopy(smallMedianArr, 0, result, 0, smallMedianArr.length);
        	System.arraycopy(bigMedianArr, 0, result, smallMedianArr.length, bigMedianArr.length);
        	return getMiddleNUmFromOneSortedArray(result);
        }
        boolean flag = false;
        int i;
        int smallBeginIndex = (int) Math.ceil(smallMedianArr.length/2.0);
        int bigBeginIndex = (int) Math.floor(bigMedianArr.length/2.0)-1;
        int[] a = new int[2];
        int[] b = new int[2];
        for(i = 0; i<Math.floor(minLen/2.0); i++) {
        	int m = smallMedianArr[smallBeginIndex+i];
        	int n = bigMedianArr[bigBeginIndex-i];
        	if (m==n) {
        		return m;
        	} else if(m>n) {
        		flag=true;
        		a[0] = smallMedianArr[smallBeginIndex+i-1];
        		a[1] = m;
        		b[0] = n;
        		b[1] = bigMedianArr[bigBeginIndex-i+1];
        		break;
        	}
        }
        if(flag) {
        	if((maxLen+minLen)%2==0) {
        		return (Math.max(a[0], b[0])+Math.min(a[1], b[1]))/2.0;
        	} else if(smallMedianArr.length%2==0) {
        		return Math.min(a[1], b[1]);
        	} else {
        		return Math.max(a[0], b[0]);
        	}
        } else {
        	if(mapLength.get(maxLen)==smallMedianArr) {
        		int len = (int) Math.floor(bigMedianArr.length/2.0);
        		if((maxLen+minLen)%2==0) {
        			int small = smallMedianArr[smallBeginIndex+len-1];
        			int big = Math.min(smallMedianArr[smallBeginIndex+len], bigMedianArr[0]);
        			return (small+big)/2.0;
        		} else {
        			return Math.min(smallMedianArr[smallBeginIndex+len], bigMedianArr[0]);
        		}
        	} else {
        		int len = (int) Math.floor(smallMedianArr.length/2.0);
        		if((maxLen+minLen)%2==0) {
        			int big = bigMedianArr[bigBeginIndex-len+1];
        			int small = Math.max(bigMedianArr[bigBeginIndex-len], smallMedianArr[minLen-1]);
        			return (small+big)/2.0;
        		} else {
        			return Math.max(bigMedianArr[bigBeginIndex-len+1], smallMedianArr[minLen-1]);
        		}
        	}
        }
    }
    
    public static double getMiddleNUmFromOneSortedArray (int[] nums) {
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
