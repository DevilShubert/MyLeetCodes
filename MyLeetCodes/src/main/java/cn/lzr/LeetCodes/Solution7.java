package cn.lzr.LeetCodes;

import java.util.LinkedList;

public class Solution7 {
	// 整数反转 https://leetcode-cn.com/problems/reverse-integer/
	// 这道题的难点在于如何判断是否超出int类型的界限，解决方法是每次都试探性的判断是否越界
	public int reverse(int x) {
		if (x == 0) return 0;
		// 因为Integer.MIN_VALUE的绝对值要大于Integer.MAX_VALUE
		if (x == Integer.MIN_VALUE) return 0;

		boolean flag = false;
		int res = 0;

		// 1.判断正负 321
		if (x < 0){
			flag = true;
			x = Math.abs(x);
		}

		// 2.加入到栈 栈底 3 -> 2 -> 1 栈顶
		// ArrayDeque<Integer> deque = new ArrayDeque<>();
		LinkedList<Integer> stack = new LinkedList<>();
		while (x != 0) {
			stack.push(x % 10);
			x /= 10;
		}

		// 3.判断是否越界的情况
		int size = stack.size();
		while (size != 0){
			// 查看栈顶要添加的元素
			int peek = stack.peek();
			// 计算当前要加元素对应的幂
			int pow = size - stack.size();
			// 计算要加的元素(向下转型)，这样还可以防止0的存在
			int add = (int) (peek * Math.pow(10, pow));
			// 为了不越界，如下判断
			if (Integer.MAX_VALUE - res < add) return 0;
			res += add;
			stack.pop();
		}
		return  flag  ? -1 * res : res;
	}
}
