package cn.lzr.others.hot100;

public class Solution21 {
  // [跳跃游戏](https://leetcode-cn.com/problems/jump-game/)
  public boolean canJump(int[] nums) {
    int maxReach = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      // 首先保证当前点可达
      if (maxReach >= i) {
        maxReach = Math.max(maxReach, i + nums[i]);
      }
    }
    return maxReach >= nums.length - 1;
  }
}
