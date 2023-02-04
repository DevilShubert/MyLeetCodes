package cn.lzr.others.programmercarl.hashTable;

import java.util.HashMap;

public class Demo04 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int temp;
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            temp = target - nums[i];
            if (hashMap.containsKey(temp)) {
                res[0] = i;
                // 将具体数值作为key，将索引作为value
                res[1] = hashMap.get(temp);
            }
            hashMap.put(nums[i],i);
        }

        return res;
    }
}
