package cn.lzr.LeetCodes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution131 {
	// 分割回文串 https://leetcode-cn.com/problems/palindrome-partitioning/
	// 搞清楚字符串如何进行树状递归即可

	static List<List<String>> lists = new ArrayList<>();
	static Deque<String> deque = new ArrayDeque<>();

	public static void main(String[] args) {
		System.out.println(partition("a"));
	}


	public static List<List<String>> partition(String s) {
		bt(s,0);
		return lists;
	}

	public static void bt(String s, int startIndex) {
		// 中止条件
		if (startIndex == s.length()) {
			lists.add(new ArrayList<>(deque));
		}

		// 每层遍历：1、1+2、1+2+3、1+2+3+4
		for (int i = startIndex; i < s.length(); i++) {
			// 利用深度遍历，所以不会重复
			if (isPalindrome(s, startIndex, i)){
				deque.addLast(s.substring(startIndex, i+1));
				// 下层树状递归
				bt(s,i+1);
				deque.removeLast();
			} else {
				continue;
			}
		}
	}

	public static boolean isPalindrome(String s, int startIndex, int end) {
		for (int i = startIndex, j = end; i <= j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
