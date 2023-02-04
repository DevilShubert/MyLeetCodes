package cn.lzr.LeetCodes;

import java.util.ArrayList;
import java.util.List;

public class Solution77 {
  //  组合  https://leetcode-cn.com/problems/combinations/
  static List<List<Integer>> res;
  static List<Integer> path;

  public static List<List<Integer>> combine(int n, int k) {
    path = new ArrayList<Integer>();
    res = new ArrayList<List<Integer>>();
    bt(1, n, k);
    return res;
  }

  public static void bt(int begin, int n, int k) {
    if (path.size() == k) {
      res.add(new ArrayList<Integer>(path));
      return;
    }

    for (int i = begin; i <= n; i++) {
      path.add(i);
      bt(i + 1, n, k);
      path.remove(path.size() - 1);
    }
  }

  public static void bt2(int begin, int n, int k) {
    // 组合的优化
    if (path.size() == k) {
      res.add(new ArrayList<Integer>(path));
      return;
    }

    // 剪枝的地方，例如n = 4, k = 4时
    // 从第一层for循环的时候，从元素2开始的遍历都没有意义了。 在第二层for循环，从元素3开始的遍历都没有意义了
    // n = 4, k = 3时
    // 从第一层for循环的时候，从元素3开始的遍历都没有意义了。 在第二层for循环，从元素4开始的遍历都没有意义了
    for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
      path.add(i);
      bt2(i + 1, n, k);
      path.remove(path.size() - 1);
    }
  }
}
