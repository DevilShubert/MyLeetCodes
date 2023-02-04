package cn.lzr.others.programmercarl.dynamicProgramming;

public class Solution05 {
  public static void main(String[] args) {
    int[][] ints = new int[1][2];
    int[] row = new int[] {1, 0};
    ints[0] = row;
    Solution05 solution05 = new Solution05();
    solution05.uniquePathsWithObstacles(ints);
  }

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    // n for rows; m for colum
    int n = obstacleGrid.length;
    int m = obstacleGrid[0].length;
    if (obstacleGrid[0][0] == 1) return 0;
    int[][] dp = new int[n][m];
    dp[0][0] = 1;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (obstacleGrid[i][j] == 1) continue;
        // up to down
        if (i > 0) dp[i][j] += dp[i - 1][j];

        // left to right
        if (j > 0) dp[i][j] += dp[i][j - 1];
      }
    }
    return dp[n - 1][m - 1];
  }
}
