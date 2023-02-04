package cn.lzr.others.xiaoHui17.easy;

import java.util.LinkedList;

public class Solution04 {
  // 栈实现队列 https://leetcode-cn.com/problems/implement-queue-using-stacks/
}

class MyQueue {
  private LinkedList<Integer> stack1;
  private LinkedList<Integer> stack2;

  public MyQueue() {
    stack1 = new LinkedList<>();
    stack2 = new LinkedList<>();
  }

  public void push(int x) {
    // push时只往stack1中放
    stack1.push(x);
  }

  public int pop() {
    if (stack2.size() != 0) {
      return stack2.pop();
    } else {
      while (stack1.size() != 0) {
        stack2.push(stack1.pop());
      }
      return stack2.pop();
    }
  }

  public int peek() {
    if (stack2.size() != 0) {
      return stack2.peek();
    } else {
      while (stack1.size() != 0) {
        stack2.push(stack1.pop());
      }
      return stack2.peek();
    }
  }

  public boolean empty() {
    return (stack1.size() == 0 && stack2.size() == 0) ? true : false;
  }
}
