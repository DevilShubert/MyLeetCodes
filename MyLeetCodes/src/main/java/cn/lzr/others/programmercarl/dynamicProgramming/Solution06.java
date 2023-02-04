package cn.lzr.others.programmercarl.dynamicProgramming;

public class Solution06 {
  // 整数拆分
  public int integerBreak(int n) {
    // index refer number
    int[] dp = new int[n + 1];
    dp[1] = 1;
    int curMax;
    for (int i = 2; i <= n; i++) {

      curMax = 0;
      for (int j = 1; j < i; j++) {
        // 情况一，拆分的j直接与剩下的i - j相乘 j*(i-j)
        int temp1 = j * (i - j);

        // 情况二，把i - j继续拆分寻找dp[i-j]，再用 j*(dp[i-j])
        int temp2 = j * dp[i - j];
        curMax = Math.max(curMax, Math.max(temp1, temp2));
      }
      dp[i] = curMax;
    }
    return dp[n];
  }
}
