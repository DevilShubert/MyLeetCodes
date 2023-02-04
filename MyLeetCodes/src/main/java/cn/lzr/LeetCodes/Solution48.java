package cn.lzr.LeetCodes;

public class Solution48 {
	// 48. 旋转图像 https://leetcode.cn/problems/rotate-image/

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		new Solution48().rotate(matrix);
	}
	public void rotate(int[][] matrix) {
		// 纯记忆公式 new[j][n - 1 - i] = old[i][j]
		int n = matrix.length;
		int[][] temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[j][n - 1 - i] = matrix[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = temp[i][j];
			}
		}
	}
}
