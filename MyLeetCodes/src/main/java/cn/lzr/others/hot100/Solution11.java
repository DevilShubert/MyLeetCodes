package cn.lzr.others.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution11 {
  // [括号生成](https://leetcode-cn.com/problems/generate-parentheses/)

  public static void main(String[] args) {
    new Solution11().generateParenthesis(3);
  }

  ArrayList<String> list = new ArrayList<>();

  // 利用回溯的思想，生成所有可能组合
  public void recursion(int curLevel, String str) {

    if (curLevel == 0) {
      list.add(str);
      // 中止条件
      return;
    }

    recursion(curLevel - 1, str + "(");
    recursion(curLevel - 1, str + ")");
  }

  // 剪枝操作的回溯法
  public void recursion2(int n, String str, int left, int right) {

    // 剪枝的中止条件，注意left不能是==n，因为会回溯，少一个括号
    if (left > n || right > left) return;

    if (str.length() == n * 2) {
      list.add(str);
      return;
    }
    recursion2(n, str + "(", left + 1, right);
    recursion2(n, str + ")", left, right + 1);
  }

  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    // recursion(n * 2, "");
    recursion2(n, "", 0, 0);

    //    for (String s : list) {
    //      if (isValid(s)) {
    //        res.add(s);
    //      }
    //    }
    return res;
  }

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    Character cur;
    for (int i = 0; i < s.length(); i++) {
      cur = s.charAt(i);
      if (cur == '{' || cur == '(' || cur == '[') {
        stack.push(s.charAt(i));
        continue;
      }
      // 防止"}"这样的输入
      if (stack.isEmpty()) return false;

      switch (cur) {
        case '}':
          {
            if (stack.peek() == '{') {
              stack.pop();
            } else {
              stack.push('}');
            }
            break;
          }
        case ']':
          {
            if (stack.peek() == '[') {
              stack.pop();
            } else {
              stack.push(']');
            }
            break;
          }
        case ')':
          {
            if (stack.peek() == '(') {
              stack.pop();
            } else {
              stack.push(')');
            }
            break;
          }
      }
    }
    if (stack.isEmpty()) return true;
    return false;
  }
}
