package cn.lzr.others.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution19 {
  // [字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, ArrayList<String>> hashmap = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      char[] chars = strs[i].toCharArray();
      Arrays.sort(chars);
      String key = String.valueOf(chars);

      if (!hashmap.containsKey(key)) {
        hashmap.put(key, new ArrayList<String>());
      }
      hashmap.get(key).add(strs[i]);
    }
    return new ArrayList<List<String>>(hashmap.values());
  }
}
