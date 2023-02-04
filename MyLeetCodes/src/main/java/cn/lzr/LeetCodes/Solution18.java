package cn.lzr.LeetCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {
	public static void main(String[] args) {
		Solution18 solution18 = new Solution18();
		int[] ints = {2,2,2,2};
		System.out.println(solution18.fourSum(ints, 8));
	}

	static List<List<Integer>> resList;
	// 四数之和 https://leetcode-cn.com/problems/4sum/
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		// 没有剪枝的版本，需要剪枝的话再修改
		resList = new ArrayList<>();

		Arrays.sort(nums);

		for (int p1 = 0; p1 < nums.length ; p1++) {
			for (int p2 = p1 + 1; p2 < nums.length ; p2++){
				int left = p2 + 1;
				int right = nums.length - 1;
				while (left < right) {
					int sum = nums[p1] + nums[p2] + nums[left] + nums[right];
					if (sum > target) {
						right--;
					} else if (sum < target) {
						left++;
					} else {

						resList.add(Arrays.asList(nums[p1], nums[p2], nums[left], nums[right]));

						// trimming
						while (left < right && nums[right] == nums[right-1]) right--;
						while (left < right && nums[left] == nums[left+1]) left++;

						right--;
						left++;
					}
				}
			}
		}

		return resList;
	}
}
