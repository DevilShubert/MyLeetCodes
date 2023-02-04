package cn.lzr.LeetCodes;

import java.util.HashMap;

public class Solution1 {
	// 两数之和 https://leetcode-cn.com/problems/two-sum/
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int index = 0;
		int resIndex1 = -1;
		int resIndex2 = -1;
		for (int curInt : nums) {
			if (!map.containsKey(curInt)) {
				map.put(target-curInt, index++);
			} else {
				resIndex1 = map.get(curInt);
				resIndex2 = index;
				break;
			}
		}
		int[] res = {resIndex1, resIndex2};
		return  res;
	}
}
