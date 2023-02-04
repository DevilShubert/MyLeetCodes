package cn.lzr.others.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution07 {
  public static void main(String[] args) {
    int[] ints = {1, 1, 2};
    Solution07 solution07 = new Solution07();
    solution07.permute(ints);
    System.out.println(solution07.res);
  }

  List<List<Integer>> res = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>(); // 用来存放符合条件结果

  public List<List<Integer>> permute(int[] nums) {
    boolean[] flag = new boolean[nums.length];
    bt(nums, flag);
    return res;
  }

  public void bt(int[] nums, boolean[] flag) {

    // 中止条件
    if (path.size() == nums.length) {
      res.add(new ArrayList<>(path));
      return;
    }

    // 单层逻辑
    for (int i = 0; i < nums.length; i++) {
      if (flag[i] == true) continue;
      path.addLast(nums[i]);
      flag[i] = true;
      bt(nums, flag);
      path.removeLast();
      flag[i] = false;
    }
  }
}
