package cn.lzr.others.programmercarl.array;

public class Solution5 {
    static public int[][] generateMatrix(int N) {
        int[][] res = new int[N][N];

        int num = 1;

        // 阶数位奇数阶，直接赋值中间
        if (N % 2 != 0){
            res[N/2][N/2] = N * N;
        }

        // i是横坐标，j纵坐标，注意二维数组要反着来
        int i = 0, j = 0;

        // 左闭右开原则, 循环圈数等于阶数一半
        for(int n = 0; n < (N>>1); n++) {
            // 上行从左到右
            for (i = n; i < N - n -1; i++){
                res[n][i] = num++;
            }

            // 右列从上到下
            for (j = n; j < N - n -1; j++){
                res[j][N - n - 1] = num++;
            }

            // 下行从左到右
            for (i = N - n - 1; i > n; i--){
                res[N - n - 1][i] = num++;
            }

            // 左列从下到上
            for (j = N - n -1; j > n; j--){
                res[j][n]=num++;
            }
        }
        return res;
    }

  public static void main(String[] args) {
    Solution5.generateMatrix(3);
  }
}
