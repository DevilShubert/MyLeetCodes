package cn.lzr.others.programmercarl.dynamicProgramming;

public class Solution04 {
  public static void main(String[] args) {
    //
    Solution04 solution04 = new Solution04();
    solution04.uniquePaths(3, 7);
  }

  public int uniquePaths(int m, int n) {
    // row: m; col: n
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = 0;
      }
    }

    dp[0][0] = 1;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i != 0) {
          // 从上往下走
          dp[i][j] += dp[i - 1][j];
        }

        if (j != 0) {
          // 从走往右走
          dp[i][j] += dp[i][j - 1];
        }
      }
    }
    return dp[m - 1][n - 1];
  }
}
