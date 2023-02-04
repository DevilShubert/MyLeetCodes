package cn.lzr.others.hot100;

public class Solution46 {
  public static void main(String[] args) {
    char[][] area = {
      {'1', '1', '1', '1', '0'},
      {'1', '1', '0', '1', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '0', '0', '0'}
    };
    Solution46 solution46 = new Solution46();
    solution46.numIslands(area);
  }

  public int numIslands(char[][] grid) {

    // 双层循环，行、列
    //      grid[r][c] != 1 pass else num + 1
    int res = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] != '1') {
          continue;
        } else {
          res++;
          dfsRecursive(grid, i, j);
        }
      }
    }
    return res;
  }

  // grid代表网格，row，col表示当前的行、列坐标
  public void dfsRecursive(char[][] grid, int row, int col) {
    if (!inArea(grid, row, col)) {
      return;
    }

    // 0 —— 海洋格子
    // 1 —— 陆地格子（未遍历过）
    // 2 —— 陆地格子（已遍历过）
    if (grid[row][col] != '1') return;

    grid[row][col] = '2';

    // 遍历上下左右
    dfsRecursive(grid, row - 1, col);
    dfsRecursive(grid, row + 1, col);
    dfsRecursive(grid, row, col - 1);
    dfsRecursive(grid, row, col + 1);
  }

  // grid代表网格，row，col表示当前的行、列坐标
  public boolean inArea(char[][] grid, int row, int col) {
    int rlen = grid.length;
    int clen = grid[0].length;
    return row >= 0 && row < rlen && col >= 0 && col < clen;
  }
}
