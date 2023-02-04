package cn.lzr.others.programmercarl.charString;

import java.util.ArrayList;
import java.util.List;

public class Solution04 {
      public static void main(String[] args) {
//          Solution04 solution04 = new Solution04();
//          solution04.reverseWords2(" asdasd df f");

          String a = "abcdef";
          String sub = a.substring(2,4);
      }

    public String reverseWords(String s) {
      /* 1 <= s.length <= 10000
         s 包含英文大小写字母、数字和空格 ' '
         s 中 至少存在一个 单词
      * */

        char[] chars = s.toCharArray();
        ArrayList<String> arrayList = getStrings(chars);
        int left = arrayList.size() - 1;
        String sb = arrayList.get(left--);
        while(left >= 0){
            sb += " " + arrayList.get(left--);
        }
        return sb;
    }

    /**
        * @param s
        * @return java.util.ArrayList<java.lang.String>
        * @author JLian 按照（任意个）空格分割，并存储到ArrayList中
        * @date 2022/2/15 11:59 上午
    */
    public ArrayList<String> getStrings(char[] s){
          int left = 0;
          int right = 0;

        ArrayList<String> strings = new ArrayList<>();

        while (right < s.length) {
              if (s[right] == ' ' && s[left] == ' ') {
                  right++;
                  left++;
                  continue;
              }

              while (true) {
                  if (right < s.length){
                      if (s[right] == ' ') {
                          strings.add(new String(s, left, right - left));
                          right++;
                          left = right;
                          break;
                      } else {
                          right++;
                          continue;
                      }
                  } else{
                      strings.add(new String(s, left, right - left));
                      right++;
                      left = right;
                      break;
                  }
              }
          }


        return strings;
    }


    public String reverseWords2(String s) {
        int l = -1;
        List<String> list = new ArrayList();
        for(int r = 0; r < s.length(); r++) {
            if(s.charAt(r) == ' ' && l != -1){
                list.add(s.substring(l, r));
                l = -1;
            } else if(s.charAt(r) != ' ' && r == s.length() - 1) {
                // 处理单个字符的情况
                if (l == -1) {
                    list.add(s.substring(r, r + 1));
                } else {
                    list.add(s.substring(l, r + 1));
                }


            }else if (s.charAt(r) != ' ' && l == -1) {
                l = r;
            }
        }

        StringBuilder sb = new StringBuilder();
        int len = list.size();
        for(int i = len - 1; i >= 0; i--) {
            if(i != 0){
                sb.append(list.get(i));
                sb.append(" ");
            } else {
                sb.append(list.get(i));
            }

        }
        return new String(sb);
    }

}
