package cn.lzr.others.hot100;

import java.util.HashMap;
import java.util.Map;

public class Solution45 {
  public static void main(String[] args) {
    int[] ints = {3, 3, 4};
    Solution45 solution45 = new Solution45();
    solution45.majorityElement(ints);
  }

  public int majorityElement(int[] nums) {
    // key nums中的元素； value nums出现的次数
    HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    for (int num : nums) {
      if (!hashMap.containsKey(num)) {
        hashMap.put(num, 1);
      } else {
        Integer value = hashMap.get(num);
        hashMap.put(num, value + 1);
      }
    }

    Map.Entry<Integer, Integer> res = null;
    for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
      if (res == null || entry.getValue() > res.getValue()) {
        res = entry;
      }
    }

    return res.getKey();
  }
}
