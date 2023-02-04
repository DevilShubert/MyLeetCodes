package cn.lzr.others.programmercarl.hashTable;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {

  public static void main(String[] args) {
    System.out.println(isAnagram("anagram","nagaram"));
  }

    static public boolean isAnagram(String s, String t) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>(26);

        // 重点：将一个String类型的字符串变为单个的字符数组
        for (char c : s.toCharArray()) {
            if (hashMap.containsKey(String.valueOf(c))){
                Integer integer = hashMap.get(String.valueOf(c));
                hashMap.put(String.valueOf(c), ++integer);
            }else{
                hashMap.put(String.valueOf(c), 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (hashMap.containsKey(String.valueOf(c))){
                Integer integer = hashMap.get(String.valueOf(c));
                hashMap.put(String.valueOf(c), --integer);
            } else {
                return false;
            }
        }

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()){
            if (entry.getValue() != 0){
                return  false;
            }
        }

        return true;

//        int[] record = new int[26];
//        for (char c : s.toCharArray()) {
//            record[c - 'a'] += 1;
//        }
//        for (char c : t.toCharArray()) {
//            record[c - 'a'] -= 1;
//        }
//        for (int i : record) {
//            if (i != 0) {
//                return false;
//            }
//        }
//        return true;
    }
}
