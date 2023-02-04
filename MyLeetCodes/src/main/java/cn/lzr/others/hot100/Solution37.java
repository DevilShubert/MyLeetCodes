package cn.lzr.others.hot100;

import java.util.HashSet;

public class Solution37 {
  public int singleNumber(int[] nums) {
    HashSet<Integer> hashSet = new HashSet<Integer>();
    for (int num : nums) {
      if (!hashSet.contains(num)) {
        hashSet.add(num);
      } else {
        hashSet.remove(num);
      }
    }
    int res = 0;
    for (Integer num : hashSet) {
      return res = num;
    }
    return res;
  }
}
