package cn.lzr.LeetCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
	// 组合总和 https://leetcode-cn.com/problems/combination-sum/
	static List<List<Integer>> res;
	static List<Integer> path;

	public static void main(String[] args) {
		int[] ints = {2,3,6,7};
		System.out.println(combinationSum(ints, 7));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		res = new ArrayList<>();
		path = new ArrayList<>();

		Arrays.sort(candidates);
		bt(candidates, 0,0, target);
		return res;
	}

	public static void bt(int[] candidates, int begin, int curSum, int target){
		if (curSum > target) return;
		if (curSum == target) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = begin; i < candidates.length; i++) {
			curSum += candidates[i];
			if (curSum > target) {
				curSum -= candidates[i];
				return;
			}
			path.add(candidates[i]);
			// 注意这里组合中的数字可以重复，但不允许出现排列的情况，所以传入的是i
			// 如果这里每个组合中数字不允许重复，则传入的是i+1
			bt(candidates, i, curSum, target);
			curSum -= candidates[i];
			path.remove(path.size() -1);
		}
	}
}
