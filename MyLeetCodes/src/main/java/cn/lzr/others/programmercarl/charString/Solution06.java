package cn.lzr.others.programmercarl.charString;

public class Solution06 {
    // KMP问题
      public static void main(String[] args) {
          Solution06 solution06 = new Solution06();
          System.out.println(solution06.strStr("aabaabaaf", "aabaaf"));
//          int[] ints = new int[6];
//          solution06.getNext(ints, "aabaaf");

      }

  public int strStr(String haystack, String needle) {
          // 主函数的对比思路其实类似求next数组
          if(needle.length()==0){
              return 0;
          }

          int[] next = new int[needle.length()];
          getNext(next, needle);
          int j = -1;
          // j表示next数组中的元素，i表示待匹配字符串中的遍历的元素
          for(int i = 0; i < haystack.length(); i++){
              // 整个待匹配串，也就是i只遍历一次
              while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                  j = next[j];
              }

              // 判断是都是查找charAt(j + 1)的位置，如果相等则j再加一
              if (haystack.charAt(i) == needle.charAt(j + 1)){
                  j++;
              }

              if (j == needle.length() - 1)
                  return i - needle.length() + 1;
          }

          return -1;
  }

    public void getNext(int[] next, String s){
       // 0、i表示后缀末尾，j表示前缀末尾
        int j = 0;
        next[0] = 0;

        // 利用next的增加必然是连续的这点进行for循环
        for (int i = 1; i < next.length; i++){
            // 2、i与j不相等的情况时，j（前缀末尾需要回退，回退到它前一个），如果满足下面两个条件则一直回退
           while (j > 0 &&  s.charAt(i) != s.charAt(j)){
               j = next[j - 1];
           }
            // 1、前后缀相等的情况
            if (s.charAt(i) == s.charAt(j)) j++;
            // 更新next数组
            next[i] = j;
        }

        // 3、所有值减一，方便主函数使用
        for (int i = 0; i < next.length; i++){
            next[i] = next[i] -  1;
        }
    }
}
