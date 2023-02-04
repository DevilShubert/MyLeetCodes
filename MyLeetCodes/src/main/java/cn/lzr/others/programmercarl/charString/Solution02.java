package cn.lzr.others.programmercarl.charString;

public class Solution02 {

      public static void main(String[] args) {
        new Solution02().reverseStr2("abcdefg", 2);
      }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = s.length();

        for (int i = 0; i < len; i += 2*k) {
          if ((i + 2*k) < len) {
              reverse(chars, i, i + k - 1);
          } else {
              if ((i + k) < len) {
                  reverse(chars,i, i + k - 1);
              } else {
                  reverse(chars,i, len - 1);
              }

          }
        }

        return new String(chars);
    }

    public void reverse(char[] chars, int i, int j){
        while (i < j){
            chars[i] ^= chars[j];
            chars[j] ^= chars[i];
            chars[i] ^= chars[j];
            i++;
            j--;
        }
    }

    public String reverseStr2(String s, int k) {
        char[] chars = s.toCharArray();
        int len = s.length();

        int l = 0;
        int r = 0;
        while(r < len){
            r += 2 * k;
            if(r > len) {
                if(l + k < len) {
                    reverse(chars, l, l + k -1);
                } else {
                    reverse(chars, l, len - 1);
                }
            } else {
                reverse(chars, l, l + k -1);
                l = r;
            }
        }
        return new String(chars);
    }

}
