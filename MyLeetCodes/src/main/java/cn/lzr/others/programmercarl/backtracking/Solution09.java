package cn.lzr.others.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution09 {
  List<List<String>> res = new ArrayList<>();

  public List<List<String>> solveNQueens(int n) {
    char[][] chessboard = new char[n][n];
    backTrack(n, 0, chessboard);
    return res;
  }

  public void backTrack(int n, int row, char[][] chessboard) {
    // 中止条件
    if (row == n) {
      res.add(Array2List(chessboard));
      return;
    }

    // 单层逻辑
    for (int col = 0; col < n; col++) { //
      // 如果在当前位置防止棋子有效
      if (isValid(row, col, n, chessboard)) {
        chessboard[row][col] = 'Q';
        // 自动剪枝，只有在有效位置才进入下一层
        backTrack(n, row + 1, chessboard);
        // 一行只放一个棋子，用于回溯寻找所有可能
        chessboard[row][col] = '.';
      }
    }
  }

  public List Array2List(char[][] chessboard) {
    List<String> list = new ArrayList<>();

    for (char[] c : chessboard) {
      list.add(String.copyValueOf(c));
    }
    return list;
  }

  public boolean isValid(int row, int col, int n, char[][] chessboard) {
    // 检查列
    for (int i = 0; i < row; ++i) { // 相当于剪枝
      if (chessboard[i][col] == 'Q') {
        return false;
      }
    }

    // 检查45度对角线
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (chessboard[i][j] == 'Q') {
        return false;
      }
    }

    // 检查135度对角线
    for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
      if (chessboard[i][j] == 'Q') {
        return false;
      }
    }
    return true;
  }
}
