package cn.lzr.others.hot100;

public class Solution27 {
  public boolean exist(char[][] board, String word) {
    // 本题用最简单的思路就能解出答案，即依次对board上的每个点进行word的匹配
    // 解决问题一：如何让字符右、左、上、下地行走（行为控制）
    // 解决问题二：如何防止字符走到已经经过的board位置（回溯）

    int row = board.length;
    int col = board[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (dfs(board, word, i, j, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  // i 表示横坐标， j 表示总作弊
  public boolean dfs(char[][] board, String word, int i, int j, int k) {
    // 终止条件
    if (k == word.length()) return true;
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
    if (board[i][j] != word.charAt(k)) return false;

    boolean res = false;
    // 防止走到重复的字符
    char temp = board[i][j];
    board[i][j] = '0';
    // 行为控制(深度遍历)
    res =
        dfs(board, word, i, j + 1, k + 1)
            || dfs(board, word, i, j - 1, k + 1)
            || dfs(board, word, i - 1, j, k + 1)
            || dfs(board, word, i + 1, j, k + 1);
    // 从当前i,j位置开始不能完全匹配，进行回溯,相当于还原
    board[i][j] = temp;
    return res;
  }
}
