package cn.lzr.others.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution22 {
  public static void main(String[] args) {
    //
    Solution22 solution22 = new Solution22();
    int[][] ints = {{2, 6}, {1, 3}, {8, 10}, {15, 18}};
    solution22.merge(ints);
  }

  // [合并区间](https://leetcode-cn.com/problems/merge-intervals/)
  public int[][] merge(int[][] intervals) {
    int len = intervals.length;
    if (len == 1) return new int[][] {intervals[0]};

    // intervals排序
    Arrays.sort(intervals, (int[] a1, int[] a2) -> a1[0] - a2[0]);
    List<int[]> list = Arrays.asList(intervals);
    ArrayList<int[]> res = new ArrayList();
    // for循环对 i遍历，内部如果有覆盖的使用j = i + 1，连续覆盖使用while
    for (int i = 0; i < len; ) {
      int[] inter = new int[2];

      // 区间左值
      inter[0] = list.get(i)[0];
      // 区间右值
      inter[1] = list.get(i)[1];
      int j = i + 1;
      while (j < len && list.get(j)[0] <= inter[1]) {
        if (list.get(j)[1] > inter[1]) {
          inter[1] = list.get(j)[1];
        }
        j++;
      }
      res.add(inter);
      i = j;
    }

    int[][] resInters = res.toArray(new int[res.size()][]);
    return resInters;
  }
}
