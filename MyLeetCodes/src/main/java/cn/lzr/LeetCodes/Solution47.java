package cn.lzr.LeetCodes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {


	public static void main(String[] args) {
		int[] ints = {1,1,2};
		System.out.println(permuteUnique(ints));
	}

	static List<List<Integer>> res ;
	static ArrayDeque<Integer> path;
	static boolean[] used;

	public static List<List<Integer>> permuteUnique(int[] nums) {
		res = new ArrayList<>();
		path = new ArrayDeque<>();
		used = new boolean[nums.length];
		Arrays.sort(nums);
		bt(nums);
		return res;
	}
	public static void bt(int[] nums) {
		// 中止条件
		if (path.size() == nums.length) {
			res.add(new ArrayList<>(path));
			return;
		}

		// 单层逻辑
		for (int i = 0; i < nums.length; i++) {
			// 常规操作，!used[i-1]代表还没有置为true
			if (i > 0 && nums[i - 1] == nums[i] && !used[i-1]) {
				continue;
			}
			// 这里就是排列问题特殊的地方，以[1, 1, 2]为例，因为i是从0开始遍历，为了防止重复遍历，所以还需要!used[i]
			if (!used[i]) {
				path.add(nums[i]);
				used[i] = true;
				bt(nums);
				path.removeLast();
				used[i] = false;
			}
		}
	}
}
