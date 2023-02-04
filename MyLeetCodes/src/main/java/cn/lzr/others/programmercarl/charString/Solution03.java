package cn.lzr.others.programmercarl.charString;

public class Solution03 {
  public static void main(String[] args) {
    replaceSpace("     ");

  }

    static public String replaceSpace(String s) {


        if (s == null) {
            return null;
        }
        //选用 StringBuilder可以使用append方法，比较方便
        StringBuilder sb = new StringBuilder();
        //使用 sb 逐个复制 str ，碰到空格则替换，否则直接复制
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public String replaceSpace2(String s) {
        StringBuilder sb = new StringBuilder();

        char[] chars =  s.toCharArray();
        for(int i = 0; i < chars.length ; i++) {
            if(chars[i] != ' ') {
                sb.append(chars[i]);
            } else {
                sb.append("%20");
            }
        }

        return new String(sb);
    }
}
