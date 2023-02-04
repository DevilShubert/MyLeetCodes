package cn.lzr.others.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution05 {
  public static void main(String[] args) {
    //
    int[] ints =
        new int[] {
          1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
          1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
          1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
          1, 1, 1, 1, 1, 1, 1, 1, 1, 1
        };

    System.out.println(new Solution05().combinationSum2(ints, 30));
  }

  List<List<Integer>> res = new ArrayList<>();
  List<Integer> path = new ArrayList<>();

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    int sum = 0;
    Arrays.sort(candidates);
    boolean[] flag = new boolean[candidates.length];
    bt(candidates, 0, sum, target, flag);
    return res;
  }

  public void bt(int[] candidates, int cur, int sum, int target, boolean[] flag) {

    // 剪枝
    if (sum > target) {
      return;
    }

    // 结束条件
    if (sum == target && !res.contains(path)) {
      res.add(new ArrayList<>(path));
    }

    // 单层遍历内容
    for (int i = cur; i < candidates.length; i++) {
      if (i > 0 && candidates[i - 1] == candidates[i] && !flag[i - 1]) {
        continue;
      }
      path.add(candidates[i]);
      flag[i] = true;
      bt(candidates, i + 1, sum + candidates[i], target, flag);
      path.remove(path.size() - 1);
      flag[i] = false;
    }
  }
}
