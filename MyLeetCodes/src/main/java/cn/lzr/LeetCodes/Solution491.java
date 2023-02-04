package cn.lzr.LeetCodes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution491 {
	// 递增子序列 https://leetcode-cn.com/problems/increasing-subsequences/
	static List<List<Integer>> res;
	static ArrayDeque<Integer> path;

	public static void main(String[] args) {
		int[] ints = {4,6,7,7};
		System.out.println(findSubsequences(ints));
	}

	public static List<List<Integer>> findSubsequences(int[] nums) {
		res = new ArrayList<>();
		path = new ArrayDeque<>();
		bt(nums,0);
		return res;
	}

	public static void bt(int[] nums, int start) {
		// 保证所有大于2个的递增子序列都能找到
		if (path.size() > 1) {
			res.add(new ArrayList<>(path));
		}

		// 注意记忆数组只在树状遍历的当前层内，也就是说不会影响下一层
		int[] used = new int[201];

		for (int i = start; i < nums.length; i++) {

			// 会进入if的三种情况，重点在于逻辑的困难
			if (!path.isEmpty() && path.peekLast() > nums[i] || (used[nums[i] + 100] == 1)) {
				// 情况一：path不为空且要加入的num[i] >= peekLast
				// 情况二：path为空，只要当前这个元素没有出现过则依旧可以假如
				// 情况三：path不为空，要加入的num[i] < peekLast(||前为false)，并且元素nums[i]出现过
				continue;
			}
			path.addLast(nums[i]);
			// 记忆数组的作用是记忆出现过的元素，而不是出现的索引
			used[nums[i] + 100] = 1;
			bt(nums, i+1);
			path.removeLast();
		}
	}
	static void backtracking (int[] nums, int start) {
		if (path.size() > 1) {
			res.add(new ArrayList<>(path));
		}

		int[] used = new int[201];
		for (int i = start; i < nums.length; i++) {
			if (!path.isEmpty() && nums[i] < path.peekLast() ||
					(used[nums[i] + 100] == 1)) continue;
			used[nums[i] + 100] = 1;
			path.addLast(nums[i]);
			backtracking(nums, i + 1);
			path.remove(path.size() - 1);
		}
	}

}
