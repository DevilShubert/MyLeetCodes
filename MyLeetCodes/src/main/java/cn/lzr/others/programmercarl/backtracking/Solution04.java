package cn.lzr.others.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution04 {
  public static void main(String[] args) {
    int[] candidates = new int[] {2, 3, 6, 7};
    System.out.println(new Solution04().combinationSum(candidates, 7));
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    Arrays.sort(candidates);
    bt(candidates, 0, target, res, list, 0);
    return res;
  }

  public void bt(
      int[] candidates,
      int sum,
      int target,
      List<List<Integer>> res,
      List<Integer> list,
      int index) {

    if (sum == target) {
      // 引用对象不能直接存储
      res.add(new ArrayList<>(list));
      return;
    }

    for (int i = index; i < candidates.length; i++) {
      if (sum + candidates[i] > target) break;
      sum += candidates[i];
      list.add(candidates[i]);
      // 注意这里的大坑，不同的回溯传递下标不一样
      bt(candidates, sum, target, res, list, i);

      // backTracing
      list.remove(list.size() - 1);
      sum -= candidates[i];
    }
  }
}
