package cn.lzr.others.hot100;

import java.util.Stack;

public class Solution43 {
  Integer min;
  Stack<Integer> stack;

  public Solution43() {
    min = null;
    stack = new Stack<Integer>();
  }

  public void push(int val) {
    if (stack.size() > 0) {
      if (val < min) {
        stack.push(min);
        stack.push(val);
        min = val;
      } else {
        stack.push(val);
      }
    } else {
      stack.push(val);
      min = val;
    }
  }

  public void pop() {
    int temp = stack.pop();
    if (stack.size() == 0) {
      min = null;
    } else if (temp == min && temp < stack.peek()) {
      int lastMin = stack.pop();
      min = lastMin;
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min;
  }
}
