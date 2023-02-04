package cn.lzr.others.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution08 {
  public static void main(String[] args) {
    //
    Solution08 solution08 = new Solution08();
    int[] ints = {1, 1, 2};
    System.out.println(solution08.permuteUnique(ints));
  }

  List<List<Integer>> res = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> permuteUnique(int[] nums) {
    boolean[] flag = new boolean[nums.length];
    Arrays.sort(nums);
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
      if (flag[i] == true || (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1])) continue;
      path.add(nums[i]);
      flag[i] = true;
      bt(nums, flag);
      path.removeLast();
      flag[i] = false;
    }
  }
}
