package cn.lzr.others.hot100;

import java.util.LinkedHashMap;

public class Solution40 {
  // LRU 使用LinkedHashMap实现
  public static void main(String[] args) {
    Solution40 solution40 = new Solution40(2);
    solution40.put(1, 1);
    solution40.put(2, 2);
    solution40.get(1);
  }

  private int count;
  // 链表尾部进，最后访问的在链表头
  private LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();

  public Solution40(int capacity) {
    count = capacity;
  }

  public int get(int key) {
    if (!linkedHashMap.containsKey(key)) {
      return -1;
    }
    Integer value = linkedHashMap.get(key);
    makeRecently(key, value);
    return value;
  }

  public void put(int key, int value) {
    if (linkedHashMap.containsKey(key)) {
      linkedHashMap.remove(key);
      linkedHashMap.put(key, value);
    } else {
      if (linkedHashMap.size() >= count) {
        Integer curHead = linkedHashMap.keySet().iterator().next();
        linkedHashMap.remove(curHead);
      }
      // 自动插入到链表尾部
      linkedHashMap.put(key, value);
    }
  }

  // 不管是get还是put都需要用到makeRecently
  public void makeRecently(int key, int value) {
    linkedHashMap.remove(key);
    linkedHashMap.put(key, value);
  }
}
