package com.priv.test.leetCode;

import java.util.HashMap;
import java.util.Map;

public class MedianOfTwoSortedArray {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
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
        int smallBeginIndex = (int) Math.ceil(mapMedian.get(minMedian).length/2.0);
        int bigBeginIndex = (int) Math.floor(mapMedian.get(maxMedian).length/2.0)-1;
        int[] a = new int[2];
        int[] b = new int[2];
        for(i = 0; i<Math.floor(minLen/2.0); i++) {
        	int m = mapMedian.get(minMedian)[smallBeginIndex+i];
        	int n = mapMedian.get(maxMedian)[bigBeginIndex-i];
        	if (m==n) {
        		return m;
        	} else if(m>n) {
        		flag=true;
        		a[0] = mapMedian.get(minMedian)[smallBeginIndex+i-1];
        		a[1] = m;
        		b[0] = n;
        		b[1] = mapMedian.get(maxMedian)[bigBeginIndex-i];
        		break;
        	}
        }
        if(flag) {
        	if((maxLen+minLen)%2==0) {
        		return (Math.max(a[0], b[0])+Math.min(a[1], b[1]))/2.0;
        	} else if(minLen%2==0) {
        		return Math.min(a[1], b[1]);
        	} else {
        		return Math.max(a[0], b[0]);
        	}
        } else {
        	if(mapLength.get(maxLen)==mapMedian.get(minMedian)) {
        		int len = (int) Math.floor(mapMedian.get(maxMedian).length/2.0);
        		if((maxLen+minLen)%2==0) {
        			int small = mapMedian.get(minMedian)[smallBeginIndex+len-1];
        			int big = Math.max(mapMedian.get(minMedian)[smallBeginIndex+len], mapMedian.get(maxMedian)[0]);
        			return (small+big)/2.0;
        		} else {
        			return Math.max(mapMedian.get(minMedian)[smallBeginIndex+len], mapMedian.get(maxMedian)[0]);
        		}
        	} else {
        		int len = (int) Math.floor(mapMedian.get(minMedian).length/2.0);
        		if((maxLen+minLen)%2==0) {
        			int small = mapMedian.get(maxMedian)[bigBeginIndex-len+1];
        			int big = Math.max(mapMedian.get(maxMedian)[bigBeginIndex-len], mapMedian.get(minMedian)[minLen-1]);
        			return (small+big)/2.0;
        		} else {
        			return Math.max(mapMedian.get(maxMedian)[bigBeginIndex-len], mapMedian.get(minMedian)[minLen-1]);
        		}
        	}
        }
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
