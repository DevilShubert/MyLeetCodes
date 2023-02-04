package cn.lzr.others.xiaoHui17.medium;

import java.util.Deque;
import java.util.LinkedList;

public class Test4 {}

class Solution {
  // 这种方法会超时
  public static void main(String[] args) {
    System.out.println(removeKdigits("10001", 4));
  }

  public static String removeKdigits(String num, int k) {
    // 特殊情况
    if (k == num.length()) return "0";

    int len;
    boolean flag;
    for (int i = 0; i < k; i++) {
      flag = false;
      StringBuilder sb = new StringBuilder();
      len = num.length();
      for (int j = 0; j < len; j++) {
        // 如果有高位大于低位的情况
        if (!flag && j < len - 1 && num.charAt(j) > num.charAt(j + 1)) {
          flag = true;
        } else {
          sb.append(num.charAt(j));
        }
      }
      // num从高位到低位都是递增的情况
      if (!flag) {
        sb.delete(len - 1, len);
      }
      // 去除前导零
      num = sb.toString();
      while (num.length() > 1 && num.charAt(0) == '0') {
        num = num.substring(1);
      }
      // 防止被删除完的情况
      if ("".equals(num)) return "0";
    }
    return num;
  }
}

class Solution2 {
  public static void main(String[] args) {
    System.out.println(removeKdigits("10001", 4));
  }

  public static String removeKdigits(String num, int k) {
    Deque<Character> deque = new LinkedList<Character>();
    int length = num.length();
    for (int i = 0; i < length; ++i) {
      char digit = num.charAt(i);
      while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
        deque.pollLast();
        k--;
      }
      deque.offerLast(digit);
    }

    for (int i = 0; i < k; ++i) {
      deque.pollLast();
    }

    StringBuilder ret = new StringBuilder();
    boolean leadingZero = true;
    while (!deque.isEmpty()) {
      char digit = deque.pollFirst();
      if (leadingZero && digit == '0') {
        continue;
      }
      leadingZero = false;
      ret.append(digit);
    }
    return ret.length() == 0 ? "0" : ret.toString();
  }
}
