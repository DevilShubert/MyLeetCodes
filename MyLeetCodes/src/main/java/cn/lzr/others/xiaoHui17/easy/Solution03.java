package cn.lzr.others.xiaoHui17.easy;

import java.util.Scanner;

public class Solution03 {
  public static void main(String[] args) {
    // 2 的幂 https://leetcode-cn.com/problems/power-of-two/
  }

  public boolean isPowerOfTwo(int n) {
    if (n <= 0) return false;
    return (n & n - 1) == 0 ? true : false;
  }
}

class Solution03_1 {
  // 求出一个正整数转换成二进制后的数字“1”的个数。要求性能尽可能高
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int res = 0;
    int temp = 1;
    while (temp <= n) {
      if ((n & temp) == temp) res++;
      temp = temp << 1;
    }
    System.out.println(res);
  }
}
