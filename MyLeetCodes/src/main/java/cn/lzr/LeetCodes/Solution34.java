package cn.lzr.LeetCodes;

public class Solution34 {
	// 34. 在排序数组中查找元素的第一个和最后一个位置   https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
	public int[] searchRange(int[] nums, int target) {
		// 简单解法
		int[] ints = new int[2];
		ints[0] = -1;
		ints[1] = -1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				ints[0] = i;
				ints[1] = i;
				while (i + 1 < nums.length && nums[i+1] == target){
					ints[1] = ++i;
				}
				return ints;
			}
		}
		return ints;
	}


	//先找>=target的第一个
	//再找>target的第一个
	public int[] searchRange2(int[] nums, int target) {
		int l=search(nums,target);
		int r=search(nums,target+1);
		if(l==nums.length||nums[l]!=target)
			return new int[]{-1,-1};
		return new int[]{l,r-1};
	}

	// 找>=target的第一个
	public int search(int[] nums,int target){
		int l=0,r=nums.length;
		while(l<r){
			int mid=(r+l)>>1;
			if(nums[mid]>=target)
				r=mid;
			else
				l=mid+1;
		}
		return l;
	}
}
