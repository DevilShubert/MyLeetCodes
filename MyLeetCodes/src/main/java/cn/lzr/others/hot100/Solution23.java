package cn.lzr.others.hot100;

public class Solution23 {
  // [最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)
  public int minPathSum(int[][] grid) {
    // dp[i] 途径位置i的最少花费
    // 初始化、地推公式、走两个试一下
    int row = grid.length;
    int col = grid[0].length;
    int[][] dp = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {

        if (i == 0 && j == 0) {
          dp[i][j] = grid[i][j];
        } else if (i == 0) {
          dp[i][j] = grid[i][j] + dp[i][j - 1];
        } else if (j == 0) {
          dp[i][j] = grid[i][j] + dp[i - 1][j];
        } else {
          dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[row - 1][col - 1];
  }
}
