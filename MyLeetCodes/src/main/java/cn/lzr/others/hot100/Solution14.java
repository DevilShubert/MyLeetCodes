package cn.lzr.others.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution14 {
  // [长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/)

  public static void main(String[] args) {
    new Solution14().longestValidParentheses(")()())");
  }

  public int longestValidParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      if (!stack.isEmpty() && s.charAt(i) == ')') {
        // '(' index
        list.add(stack.pop());
        // ')' index
        list.add(i);
      } else if (s.charAt(i) == '(') {
        stack.push(i);
      }
    }
    Integer[] array = list.toArray(new Integer[list.size()]);
    Arrays.sort(array);

    // 寻找最长的连续子序列
    int i = 0;
    int ans = 0;
    int n = array.length;
    while (i < n) {
      int j = i;
      while (j < n - 1 && array[j + 1] == array[j] + 1) {
        j += 1;
      }
      ans = Math.max(ans, j - i + 1);
      i = j + 1;
    }
    return ans;
  }
}
