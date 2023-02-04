package cn.lzr.others.programmercarl.hashTable;

import java.util.HashMap;

public class Demo08 {
    public static void main(String[] args) {
        int[] ints1 = new int[]{1,2};
        int[] ints2 = new int[]{-2,-1};
        int[] ints3 = new int[]{-1,2};
        int[] ints4 = new int[]{0,2};
        fourSumCount(ints1,ints2,ints3,ints4);
    }

    static public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
       // 由于返回的是次数，所以可以用类似EnumMap的老方法解决
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int res = 0;
        int temp;

        for (int i : nums1) {
            for (int j : nums2) {
                if (hashMap.containsKey(i+j)) {
                    hashMap.put(i+j,hashMap.get(i+j));
                } else {
                    hashMap.put(i+j, 1);
                }
            }
        }


        for (int i: nums3) {
            for (int j: nums4) {
                temp  = i + j;
                if (hashMap.containsKey(0 - temp)) {
                    res += hashMap.get(0 - temp);
                }
            }
        }
        return res;
    }
}
