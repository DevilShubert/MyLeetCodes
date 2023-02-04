package cn.lzr.others.hot100;

public class Solution09 {
  // 盛最多水的容器
  // https://leetcode-cn.com/problems/container-with-most-water/
  public static void main(String[] args) {
    int[] ints = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(new Solution09().maxArea2(ints));
  }

  // 暴力解法，leetCode不通过
  public int maxArea(int[] height) {
    int res = 0;

    int temp;
    int len = height.length;

    if (len == 2) {
      return Math.min(height[0], height[1]);
    }

    for (int i = 0; i < len - 1; i++) {
      for (int j = i + 1; j < len; j++) {
        temp = (j - i) * Math.min(height[i], height[j]);
        res = Math.max(res, temp);
      }
    }

    return res;
  }

  public int maxArea2(int[] height) {
    int res = 0;
    int left = 0;
    int right = height.length - 1;
    int temp;
    while (left < right) {
      temp = (right - left) * Math.min(height[left], height[right]);
      res = Math.max(res, temp);
      if (height[left] <= height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return res;
  }
}
