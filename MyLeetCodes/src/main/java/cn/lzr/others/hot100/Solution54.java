package cn.lzr.others.hot100;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution54 {
  // 滑动窗口
  public static void main(String[] args) {
    Solution54 solution54 = new Solution54();
    int[] ints = {1, 3, -1, -3, 5, 3, 6, 7};
    int[] ints2 = {-1, 1};
    int[] ints3 = {-7, -8, 7, 5, 7, 1, 6, 0};

    int[] window = solution54.maxSlidingWindow(ints3, 4);
    System.out.println(Arrays.toString(window));
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 1) {
      return nums;
    }
    int len = nums.length - k + 1;
    // 存放结果元素的数组
    int[] res = new int[len];
    int num = 0;
    // 自定义队列
    MyQueue<Integer> myQueue = new MyQueue<Integer>();
    // 先将前k的元素放入队列
    for (int i = 0; i < k; i++) {
      myQueue.offer(nums[i]);
    }
    res[num++] = myQueue.front();
    for (int i = k; i < nums.length; i++) {
      // 滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
      myQueue.poll(nums[i - k]);
      // 滑动窗口加入最后面的元素
      myQueue.offer(nums[i]);
      // 记录对应的最大值
      res[num++] = myQueue.front();
    }
    return res;
  }
}

class MyQueue<T> {
  ArrayDeque<T> deque = new ArrayDeque<T>();

  // 以单调队列形式插入
  public void offer(T i) {
    while (deque.size() != 0 && (Integer) deque.peekLast() < (Integer) i) {
      deque.pollLast();
    }
    deque.offerLast(i);
  }

  public void poll(T i) {
    if (!deque.isEmpty() && i == deque.peek()) {
      deque.poll();
    }
  }

  // 拿到队列头元素
  public T front() {
    return deque.peekFirst();
  }
}
