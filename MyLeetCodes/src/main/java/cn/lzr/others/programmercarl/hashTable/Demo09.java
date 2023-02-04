package cn.lzr.others.programmercarl.hashTable;

public class Demo09 {
  public static void main(String[] args) {
    //
  }

  public boolean canConstruct(String ransomNote, String magazine) {
    int[] myInts = new int[26];


    // 将String类型字符串换变为数组
    for (int i = 0; i < magazine.length(); i++) {
      myInts[magazine.charAt(i) - 'a']++;
    }

    for (int i = 0; i < ransomNote.length(); i++) {
      if (myInts[ransomNote.charAt(i) - 'a'] > 0) {
        myInts[ransomNote.charAt(i) - 'a']--;
      } else {
        return false;
      }
    }

    return true;
  }
}
