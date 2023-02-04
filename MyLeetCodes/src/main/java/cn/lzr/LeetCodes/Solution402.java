package cn.lzr.LeetCodes;

import java.util.ArrayDeque;

public class Solution402 {
	// 402. 移掉 K 位数字 https://leetcode-cn.com/problems/remove-k-digits/

	public static void main(String[] args) {
		System.out.println(removeKdigits("100", 1));
	}

	public static String removeKdigits(String num, int k) {

		if (num.length() == k) return "0";
		int len = num.length();
		// 存储数组
		int[] nums = new int[len];
		for (int i = 0; i < len; i++) nums[i] = num.charAt(i) - '0';
		// 辅助计数
		int removeCount = 0;
		// 辅助存储
		ArrayDeque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < len; i++) {
			while (!deque.isEmpty() && deque.peekLast() > nums[i] && removeCount < k){
				deque.removeLast();
				removeCount++;
			}
			deque.addLast(nums[i]);
		}

		StringBuilder builder = new StringBuilder();

		while (!deque.isEmpty()) {
			Integer cur = deque.removeFirst();
			builder.append(cur);
		}

		String res = builder.substring(0, num.length() - k);
		while ( !"".equals(res) && '0' == res.charAt(0)){
			res = res.substring(1);
		}
		if ("".equals(res)) return "0";
		return res;
	}
}
