package cn.lzr.others.hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution26 {
  List<List<Integer>> res = new ArrayList();
  List<Integer> path = new ArrayList();

  public List<List<Integer>> subsets(int[] nums) {
    bt(nums, 0);
    return res;
  }

  public void bt(int[] nums, int index) {
    if (index == nums.length) {
      res.add(new ArrayList(path));
      return;
    }

    for (int i = index; i < nums.length; i++) {
      path.add(nums[i]);
      bt(nums, i + 1);
      path.remove(path.size() - 1);
    }
  }
}
