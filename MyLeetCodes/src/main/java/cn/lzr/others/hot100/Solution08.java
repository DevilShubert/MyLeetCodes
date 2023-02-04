package cn.lzr.others.hot100;

public class Solution08 {
      public static void main(String[] args) {

    System.out.println(Integer.MIN_VALUE % 10);
      }

    // 字符串转换整数 (atoi)
    // https://leetcode-cn.com/problems/string-to-integer-atoi/

    public int myAtoi2(String s){
        // 1、去除前导空格

        // 2、如果已经遍历完成（针对极端用例 "      "）


        // 3、如果出现符号字符，仅第 1 个有效，并记录正负

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的

        // res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && add > Integer.MAX_VALUE % 10)
        // res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && add > -1 * Integer.MIN_VALUE % 10)

        // res = res * 10 + sign * add
        // return
        return -1;
    }
}
