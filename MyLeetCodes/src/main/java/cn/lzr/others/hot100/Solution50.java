package cn.lzr.others.hot100;

public class Solution50 {
  public int maximalSquare(char[][] matrix) {
    int rowLen = matrix.length;
    int colLen = matrix[0].length;

    int[][] dp = new int[rowLen][colLen];

    // store for maxLen
    int maxLen = 0;

    // init for 0 row
    for (int i = 0; i < colLen; i++) {
      dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
      maxLen = Math.max(maxLen, dp[0][i]);
    }

    // init for 0 row
    for (int i = 0; i < rowLen; i++) {
      dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
      maxLen = Math.max(maxLen, dp[i][0]);
    }

    for (int i = 1; i < rowLen; i++) {
      for (int j = 1; j < colLen; j++) {
        // (x, x)
        if (matrix[i][j] == '1') {
          dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
          maxLen = Math.max(maxLen, dp[i][j]);
        } else {
          dp[i][j] = 0;
        }
      }
    }
    return maxLen * maxLen;
  }
}
