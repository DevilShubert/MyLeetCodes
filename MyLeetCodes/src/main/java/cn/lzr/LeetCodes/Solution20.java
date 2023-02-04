package cn.lzr.LeetCodes;

import java.util.ArrayDeque;

public class Solution20 {
	//20. 有效的括号  https://leetcode.cn/problems/valid-parentheses/
	static public boolean isValid(String s) {
		ArrayDeque<Character> stack = new ArrayDeque<>();
		char[] chars = s.toCharArray();
		for (char curChar : chars) {
			if (curChar == '(' || curChar == '{' || curChar == '[') {
				stack.addLast(curChar);
			} else if (curChar == ')') {
				if (stack.isEmpty() || stack.removeLast() != '(') {
					return false;
				}
			} else if (curChar == '}') {
				if (stack.isEmpty() || stack.removeLast() != '{') {
					return false;
				}
			} else if (curChar == ']') {
				if (stack.isEmpty() || stack.removeLast() != '[') {
					return false;
				}
			}
		}
		return stack.isEmpty() ;
	}
}
