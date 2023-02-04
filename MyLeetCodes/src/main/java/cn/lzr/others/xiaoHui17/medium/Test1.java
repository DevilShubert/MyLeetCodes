package cn.lzr.others.xiaoHui17.medium;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Test1 {
  public static void main(String[] args) {
    m3();
  }

  // 基本数据类型：整数
  public static void m1() {
    Long l = 123l;
    int i = 123;

    int i1 = l.intValue();
    long l2 = (long) i;
  }

  // 基本数据类型：浮点数
  public static void m2() {
    float f = 1.23f;
    double d = 1.233d;

    // 往低转型，同样会有精度问题
    float d1 = (float) d;
    // 往高转型，不会发生精度问题
    double f1 = f;
  }

  // 大整数
  public static void m3() {
    BigInteger bigInteger1 = new BigInteger("123131426709752318");
    BigInteger bigInteger2 = new BigInteger("95481253129123123");
    // BigInteger bi = BigInteger.valueOf(1231312);
    System.out.println(bigInteger1.add(bigInteger2));
    System.out.println(bigNumberSum("123131426709752318", "95481253129123123"));
  }

  // 大浮点数
  public static void m4() {
    // 通过double创建
    BigDecimal bd1 = new BigDecimal(100.111);
    BigDecimal bd2 = new BigDecimal("100.122");
  }

  // 竖位相加
  public static String bigNumberSum(String bigNumberA, String bigNumberB) {
    int maxLength =
        bigNumberA.length() > bigNumberB.length() ? bigNumberA.length() : bigNumberB.length();

    // 大数倒叙
    int[] arrA = new int[maxLength];
    for (int i = 0; i < bigNumberA.length(); i++) {
      arrA[i] = bigNumberA.charAt(bigNumberA.length() - i - 1) - 48;
    }
    int[] arrB = new int[maxLength];
    for (int i = 0; i < bigNumberB.length(); i++) {
      arrB[i] = bigNumberB.charAt(bigNumberB.length() - i - 1) - 48;
    }

    // 构建res数组，位数加一以防进位
    int[] res = new int[maxLength + 1];

    for (int i = 0; i < res.length - 1; i++) {
      int temp = res[i];
      temp += arrA[i];
      temp += arrB[i];
      if (temp >= 10) {
        temp -= 10;
        res[i] = temp;
        res[i + 1] = 1;
      } else {
        res[i] = temp;
      }
    }

    StringBuilder stringBuilder = new StringBuilder();
    for (int i = res.length - 1; i >= 0; i--) {
      // 首位
      if (i == res.length - 1) {
        // 首位为1说明进位
        if (res[i] == 1) {
          stringBuilder.append(res[i]);
        }
      } else {
        stringBuilder.append(res[i]);
      }
    }
    return stringBuilder.toString();
  }
}
