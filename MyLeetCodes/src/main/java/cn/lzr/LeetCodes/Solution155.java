package cn.lzr.LeetCodes;

import java.util.ArrayDeque;

public class Solution155 {
	// 155. 最小栈 https://leetcode-cn.com/problems/min-stack/
}

class MinStack {

	ArrayDeque<Integer> curStack;
	ArrayDeque<Integer> minStack;

	public MinStack() {
		curStack = new ArrayDeque<Integer>();
		minStack = new ArrayDeque<Integer>();
	}

	public void push(int val) {
		if (minStack.isEmpty()) {
			curStack.push(val);
			minStack.push(val);
		} else {
			// 小于等于时才入栈
			if (val <= minStack.peek()) {
				minStack.push(val);
				curStack.push(val);
			} else {
				curStack.push(val);
			}
		}
	}

	public void pop() {
		// 注意：对象比较一律用equals
		Integer pop = curStack.pop();
		// 相等时才出栈
		if (pop.equals(minStack.peek())) {
			minStack.pop();
		}
	}

	public int top() {
		return curStack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}