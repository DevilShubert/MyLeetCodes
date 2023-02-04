package cn.lzr.others.programmercarl.charString;

public class Solution05 {
  public static void main(String[] args) {
    //
      Solution05 solution05 = new Solution05();
    System.out.println(solution05.reverseLeftWords("abcdefg", 2));
  }

    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();

        reverseChars(chars, 0, n -1);
        reverseChars(chars, n, s.length() - 1);
        reverseChars(chars,0, s.length() - 1);
        return  new String(chars);
    }

    // 传入一个chars数组，按照左右索引值反转
    public void reverseChars(char[] chars, int left, int right){
      char temp;
      while (left < right) {
          temp = chars[left];
          chars[left] = chars[right];
          chars[right] = temp;
          right--;
          left++;
      }
    }


}
