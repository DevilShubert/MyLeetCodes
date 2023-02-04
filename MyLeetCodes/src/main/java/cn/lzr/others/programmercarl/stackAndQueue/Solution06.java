package cn.lzr.others.programmercarl.stackAndQueue;


import java.util.*;


public class Solution06 {

      public static void main(String[] args) {
        //
          Solution06 solution06 = new Solution06();
          int[] ints = {1, 1, 1, 2, 2, 3};
          solution06.topKFrequent(ints, 2);
      }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] result = new int[k];


        for (int i : nums) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();


        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    // 如果o1比o2小则返回负数（o1被排序在前面）
                    return o1.getValue() - o2.getValue();
            }
        };

        // 使用comparator比较器，对优先队列设定排序规则：小顶堆，value值小的在前面
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(comparator);

        // 加入优先队列
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            // 永远保持优先队列只有k个元素
            if (queue.size() > k) {
                queue.poll();
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return result;


    }
}
