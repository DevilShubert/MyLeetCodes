package cn.lzr.others.hot100;

public class Solution18 {
  // [旋转图像](https://leetcode-cn.com/problems/rotate-image)
  // 确定地推公式： m[j][n - 1 - j] = temp[i][j]
  public void rotate(int[][] matrix) {
    // 构造辅助矩阵
    int n = matrix.length;
    int[][] temp = new int[n][];
    for (int i = 0; i < n; i++) {
      temp[i] = matrix[i].clone();
    }

    // row
    for (int i = 0; i < n; i++) {
      // col
      for (int j = 0; j < n; j++) {
        matrix[j][n - 1 - i] = temp[i][j];
      }
    }
  }
}
