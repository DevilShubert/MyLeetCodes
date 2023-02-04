package cn.lzr.LeetCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
	// 三数之和 https://leetcode-cn.com/problems/3sum/
	public List<List<Integer>> threeSum(int[] nums) {
		ArrayList<List<Integer>> res = new ArrayList<>();
		if (nums.length < 3) return res;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			// 剪枝
			if (nums[i] > 0) break;
			if (i > 0 && nums[i - 1] == nums[i]) continue;
			int temp = 0 - nums[i];

			while (j < k) {
				int cur = nums[j] + nums[k];
				// 分情况移动指针，才能不遗漏所有情况
				if (cur > temp) {
					k--;
				} else if (cur < temp) {
					j++;
				} else {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j++]);
					list.add(nums[k--]);
					res.add(list);

					// 剪枝
					while (nums[j - 1] == nums[j] && j < k) j++;
					while (nums[k] == nums[k + 1] && j < k) k--;
				}
			}
		}
		return res;
	}
}
