package cn.lzr.LeetCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {
	// 组合总和② https://leetcode-cn.com/problems/combination-sum-ii/
	// 使用记忆数组有点过于技巧了
	static List<List<Integer>> res;
	static List<Integer> path;
	static boolean[] flags;

	public static void main(String[] args) {
		int[] ints = {10,1,2,7,6,1,5};
//		int[] ints = {2,5,2,1,2};
		System.out.println(combinationSum2(ints, 8));
	}
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		flags = new boolean[candidates.length];
		res = new ArrayList<>();
		path = new ArrayList<>();
		bt(candidates,0, 0, target);
		return res;
	}

	public static void bt(int[] candidates, int begin,  int curSum, int target){

		if (curSum == target) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = begin; i < candidates.length; i++) {
			// i > 0 且与前一个元素相等时，且前一个元素flag为false时直接跳过
			if (i > 0 && candidates[i - 1] == candidates[i] && !flags[i-1]) {
				continue;
			}
			curSum += candidates[i];
			if (curSum > target) {
				curSum -= candidates[i];
				return;
			}
			path.add(candidates[i]);
			flags[i] = true;
			bt(candidates, i + 1, curSum, target);
			curSum -= candidates[i];
			path.remove(path.size() - 1);
			flags[i] = false;
		}
	}
}
