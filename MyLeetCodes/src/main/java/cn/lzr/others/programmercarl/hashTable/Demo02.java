package cn.lzr.others.programmercarl.hashTable;

import java.util.HashSet;
import java.util.Set;

public class Demo02 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        int[] arr = new int[1000];

        Set<Integer> resSet = new HashSet<>();

        for (int a : nums1) {
            if (arr[a] == 0) {
                arr[a] = 1;
            }else continue;
        }

        for (int b  : nums2) {
            if (arr[b] == 1) {
                resSet.add(b);
            }
        }

        int[] resArr = new int[resSet.size()];
        int index = 0;
        //将结果几何转为数组
        for (int i : resSet) {
            resArr[index++] = i;
        }
        return resArr;
    }
}
