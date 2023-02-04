package cn.lzr.LeetCodes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution32 {

	public static void main(String[] args) {
		Solution32 solution32 = new Solution32();
		solution32.longestValidParentheses(")()())");
	}
	// 32. 最长有效括号的长度 https://leetcode.cn/problems/longest-valid-parentheses/
	public int longestValidParentheses(String s) {
		// 最长有效括号子序列，纯纯技巧题，最好的解题思路见题解：https://leetcode.cn/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-powcai/

		// 1、首先找到所有有效括号的下标（完成这一点需要栈+线性表）
		LinkedList<Integer> stack = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			// stack中只存(的下标
			if (!stack.isEmpty() && s.charAt(i) == ')') {
				// 只要stack中还存在(，即stack不为空，就可以将()凑成一对
				list.add(stack.pop()); // 添加(的下标
				list.add(i); // 添加)的下标
			} else if (s.charAt(i) == '('){
				stack.push(i);
			}
		}

		// 2、再将下标排序，寻找下标最长有效子序列，其长度就是目标值
		Integer[] array = list.toArray(new Integer[0]);
		Arrays.sort(array);

		int maxLen = Integer.MIN_VALUE;
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for (Integer cur : array) {
			if (deque.isEmpty() || deque.peekLast() + 1 == cur) {
				deque.offerLast(cur);
			} else {
				maxLen = Math.max(deque.size(), maxLen);
				deque.clear();
				deque.offerLast(cur);
			}
		}

		maxLen = Math.max(deque.size(), maxLen);

		return maxLen;
	}
}
