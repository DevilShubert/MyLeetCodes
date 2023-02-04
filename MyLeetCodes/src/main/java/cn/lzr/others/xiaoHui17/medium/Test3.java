package cn.lzr.others.xiaoHui17.medium;

import java.util.ArrayDeque;

public class Test3 {}

class MyQueue {
  ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

  void poll(int val) {
    // 要出队的元素正好是deque对头元素，说明此时deque刚好全部单调递减且为满的
    if (!deque.isEmpty() && val == deque.peekFirst()) {
      deque.removeFirst();
    }
  }

  void add(int val) {
    // 时刻保持单调递减
    while (!deque.isEmpty() && val > deque.peekLast()) {
      deque.removeLast();
    }
    deque.addLast(val);
  }

  // 队列队顶元素始终为最大值
  int peek() {
    return deque.peekFirst();
  }
}
