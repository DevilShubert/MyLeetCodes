package cn.lzr.LeetCodes;

public class Solution33 {
	// 33. 搜索旋转排序数组 https://leetcode.cn/problems/search-in-rotated-sorted-array/
	public static void main(String[] args) {
		int[] ints = {4, 5, 6, 7, 0, 1, 2};
		System.out.println(search(ints, 0));
		//  0, 1, 2, 3, 4, 5, 6
	}

	public static int search(int[] nums, int target) {
		int len = nums.length;
		if (len == 0) return -1;
		int left = 0, right = len - 1;

		while (left <= right) {
			// 1. 首先明白，旋转数组后，从中间划分，一定有一边是有序的
			int gap = right - left;
			gap = gap >> 1;
			int mid = left +  gap;

			// 3.最后通过二分法找到目标值；注意：中间值可能就等于目标值
			if(nums[mid] == target) return mid;

			// 2. 由于一定有一边是有序的，所以根据有序的两个边界值来判断目标值在有序一边还是无序一边
			if (nums[mid] < nums[right]) {
				// 此时说明右边有序
				if(target > nums[mid] && target <= nums[right]){
					// 目标值就在右边
					left = mid + 1;
					// 虽然右边有序，但是目标值在左边，所以更新right
				}else{
					right = mid - 1;
				}
			} else {
				// 此时说明左边有序
				if(target >= nums[left] && target < nums[mid]){
					// 目标值在左边
					right = mid - 1;
				}else{
					// 虽然左边有序，但是目标值在右边，所以更新left
					left = mid + 1;
				}
			}
		}
		return -1;
	}
}
