package cn.lzr.others.hot100;

import java.util.HashSet;

public class Solution36 {
  public int longestConsecutive(int[] nums) {
    // 第一步去重
    HashSet<Integer> hashSet = new HashSet<Integer>();
    for (int num : nums) {
      hashSet.add(num);
    }

    int max = 0;

    // 第二步只遍历那些没有x-1的元素
    for (int num : hashSet) {
      if (!hashSet.contains(num - 1)) {
        int curLength = 0;
        while (hashSet.contains(++num)) {
          curLength++;
        }
        max = Math.max(max, curLength);
      }
    }
    return max;
  }
}
