package cn.lzr.LeetCodes;

import java.util.*;

public class Solution90 {
	// 子集② https://leetcode-cn.com/problems/subsets-ii/
	public static void main(String[] args) {
		int[] ints = {1,2,2};
		System.out.println(subsetsWithDup2(ints));
	}

	static List<List<Integer>> lists ;
	static Deque<Integer> deque ;

	// 方法一：使用集合自带的去重
	public static List<List<Integer>> subsetsWithDup1(int[] nums) {
		Arrays.sort(nums);
		lists =  new ArrayList<>();
		deque = new ArrayDeque<>();
		lists.add(new ArrayList<>());
		bt1(nums, 0);
		return lists;
	}

	public static void bt1(int[] nums, int startIndex){
		if (startIndex == nums.length) {
			return;
		}

		for (int i = startIndex; i < nums.length; i++){
			deque.addLast(nums[i]);
			ArrayList<Integer> list = new ArrayList<>(deque);
			if (!lists.contains(list)) {
				lists.add(list);
			}
			bt1(nums, i+1);
			deque.removeLast();
		}
	}

	// 方法二：使用记忆数组flag
	static boolean[] flag ;

	public static List<List<Integer>> subsetsWithDup2(int[] nums) {
		Arrays.sort(nums);
		lists =  new ArrayList<>();
		deque = new ArrayDeque<>();
		flag = new boolean[nums.length];
		lists.add(new ArrayList<>());
		bt2(nums, 0);
		return lists;
	}

	public static void bt2(int[] nums, int startIndex){
		if (startIndex == nums.length) {
			return;
		}

		for (int i = startIndex; i < nums.length; i++){
			// i > 0 且与前一个元素相等时，且前一个元素flag为false时直接跳过
			if (i > 0 && nums[i-1] == nums[i] && !flag[i-1]){
				continue;
			}

			deque.add(nums[i]);
			flag[i] = true;
			// 确保每一种情况都要加入到集合中，所以lists的添加放在for循环中
			lists.add(new ArrayList<>(deque));
			bt2(nums, i + 1);
			deque.removeLast();
			flag[i] = false;
		}
	}
}
