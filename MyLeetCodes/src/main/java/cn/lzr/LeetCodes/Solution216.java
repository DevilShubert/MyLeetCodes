package cn.lzr.LeetCodes;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {
  // 组合总和 III https://leetcode-cn.com/problems/combination-sum-iii/

  public static void main(String[] args) {
    System.out.println(combinationSum3(3, 7));
  }

  static List<List<Integer>> res;
  static List<Integer> path;
  public static List<List<Integer>> combinationSum3(int k, int n) {
    path = new ArrayList<Integer>();
    res = new ArrayList<List<Integer>>();
    bt(1, 0,0, k, n);
    return res;
  }

  public static void bt(int begin, int curSum, int kCount, int k, int n){

    if (kCount > k || curSum > n) return;
    if (kCount == k && curSum == n) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int i = begin; i <= 9; i++) {
      curSum += i;
      kCount++;
      path.add(i);
      bt(i + 1, curSum, kCount, k, n);
      path.remove(path.size()-1);
      curSum -= i;
      kCount--;
    }
  }
}
