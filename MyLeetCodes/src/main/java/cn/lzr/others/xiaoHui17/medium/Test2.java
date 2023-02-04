package cn.lzr.others.xiaoHui17.medium;

import java.util.ArrayDeque;

public class Test2 {
  // 最小栈
  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(512);
    minStack.push(-1024);
    minStack.push(-1024);
    minStack.push(512);
    minStack.pop();
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.getMin());
  }
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
      if (val <= minStack.peek()) {
        minStack.push(val);
        curStack.push(val);
      } else {
        curStack.push(val);
      }
    }
  }

  public void pop() {
    Integer pop = curStack.pop();
    // 对象比较一律用equals
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
