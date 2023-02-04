package cn.lzr.LeetCodes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution78 {
	// 子集 https://leetcode-cn.com/problems/subsets/
	public static void main(String[] args) {
		int[] ints = {1,2,3};
		System.out.println(subsets(ints));
	}
	static List<List<Integer>> lists ;
	static Deque<Integer> deque ;

	public static List<List<Integer>> subsets(int[] nums) {
		lists =  new ArrayList<>();
		deque = new ArrayDeque<>();
		lists.add(new ArrayList<>());
		bt(nums, 0);
		return lists;
	}

	public static void bt(int[] nums, int startIndex){
		if (startIndex == nums.length) {
			return;
		}

		for (int i = startIndex; i < nums.length; i++){
			deque.addLast(nums[i]);
			lists.add(new ArrayList<>(deque));
			bt(nums, i+1);
			deque.removeLast();
		}
	}

}
