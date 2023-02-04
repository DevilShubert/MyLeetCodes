package cn.lzr.LeetCodes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution46 {
	// 排列 https://leetcode-cn.com/problems/permutations/
	static List<List<Integer>> result ;
	static ArrayDeque<Integer> path ;
	static boolean[] used;
	public static List<List<Integer>> permute(int[] nums) {
		result = new ArrayList<>();
		path = new ArrayDeque<>();
		used = new boolean[nums.length];
		if (nums.length == 0){
			return result;
		}
		bt(nums);
		return result;
	}

	public static void bt(int[] nums){
		if (path.size() == nums.length){
			result.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) continue;
			path.addLast(nums[i]);
			used[i] = true;
			bt(nums);
			path.removeLast();
			used[i] = false;
		}
	}
}
