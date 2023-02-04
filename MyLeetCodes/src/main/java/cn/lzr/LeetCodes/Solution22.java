package cn.lzr.LeetCodes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution22 {
	// 22. 括号生成  https://leetcode.cn/problems/generate-parentheses/
	public static void main(String[] args) {
		new Solution22().generateParenthesis(3);
	}

	// 基本方法：使用递归首先生成满足n对的所有情况，例如n=3，则有3个(和3个)，再用排除法剔除
	ArrayList<String> list;
	public List<String> generateParenthesis(int n) {
		list = new ArrayList<String>();
		ArrayList<String> res = new ArrayList<>();
		recursion("",n,n);
		for (String s: list) {
			if (isValid(s)) res.add(s);
		}
		return res;
	}

	public void recursion(String s, int leftCount, int rightCount){
		if (leftCount == 0 && rightCount == 0) {
			list.add(s);
			return;
		}
		if (leftCount > 0){
			recursion(s+"(", leftCount -1 ,rightCount);
		}
		if (rightCount > 0){
			recursion(s+")", leftCount  ,rightCount-1);
		}

	}

	 public boolean isValid(String s) {
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

	// 进阶方法：直接在递归的同时就剪枝修改
	public void recursion2(int n, String str, int left, int right) {

		// 剪枝的中止条件，注意left不能是>=n，因为会回溯，少一个括号
		if (left > n || right > left) return;

		if (str.length() == n * 2) {
			list.add(str);
			return;
		}
		recursion2(n, str + "(", left + 1, right);
		recursion2(n, str + ")", left, right + 1);
	}
}
