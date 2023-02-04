package cn.lzr.others.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution28 {

  public static void main(String[] args) {
    Solution28 solution28 = new Solution28();
    // int[] ints = new int[] {2, 1, 5, 6, 2, 3};
    // int[] ints = new int[] {1, 0, 1, 0, 1};
    int[] ints = new int[] {2, 1, 0, 2};
    solution28.myLargestRectangleArea(ints);
  }

  public int largestRectangleArea(int[] heights) {
    int len = heights.length;
    if (len == 0) {
      return 0;
    }
    if (len == 1) {
      return heights[0];
    }

    int res = 0;
    Deque<Integer> stack = new ArrayDeque<>(len);
    for (int i = 0; i < len; i++) {
      // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
      while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
        int curHeight = heights[stack.pollLast()];
        while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
          stack.pollLast();
        }

        int curWidth;
        if (stack.isEmpty()) {
          curWidth = i;
        } else {
          curWidth = i - stack.peekLast() - 1;
        }

        // System.out.println("curIndex = " + curIndex + " " + curHeight * curWidth);
        res = Math.max(res, curHeight * curWidth);
      }
      stack.addLast(i);
    }

    while (!stack.isEmpty()) {
      int curHeight = heights[stack.pollLast()];
      while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
        stack.pollLast();
      }
      int curWidth;
      if (stack.isEmpty()) {
        curWidth = len;
      } else {
        curWidth = len - stack.peekLast() - 1;
      }
      res = Math.max(res, curHeight * curWidth);
    }
    return res;
  }

  public int myLargestRectangleArea(int[] heights) {
    if (heights.length == 1) return heights[0];
    int length = heights.length;
    int res = 0;

    // 用栈存储下标
    Deque<Integer> stack = new ArrayDeque<>(length);
    for (int i = 0; i < length; i++) {
      while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
        int curH = heights[stack.pollLast()];

        // 如果前面有相等的
        while (!stack.isEmpty() && curH == heights[stack.peekLast()]) {
          stack.pollLast();
        }
        int width;
        if (stack.isEmpty()) {
          width = i;
        } else {
          width = i - stack.peekLast() - 1;
        }
        res = Math.max(res, curH * width);
      }
      stack.addLast(i);
    }

    // 将剩下的栈中元素遍历完，假设栈的最右边长度 = 6
    while (!stack.isEmpty()) {
      int curH = heights[stack.pollLast()];
      // 如果前面有相等的
      while (!stack.isEmpty() && curH == heights[stack.peekLast()]) {
        stack.pollLast();
      }
      int width;
      if (stack.isEmpty()) {
        width = length;
      } else {
        width = length - stack.peekLast() - 1;
      }
      res = Math.max(res, curH * width);
    }

    return res;
  }
}
