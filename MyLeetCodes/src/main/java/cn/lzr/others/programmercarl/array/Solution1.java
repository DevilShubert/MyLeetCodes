package cn.lzr.others.programmercarl.array;

public class Solution1 {
    public int search(int[] nums, int target){
        // 左闭右闭
        if (target < nums[0] || target > nums[nums.length -  1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int middle = left + ((right - left) >> 1);
            // (2 - 0) / 2
            // 防止出现0.5的情况，也就是向下取取整
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target){
        // 左闭右开
        if (target < nums[0] || target > nums[nums.length -  1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // (3 - 0) / 2
            if (nums[mid] == target) {
                return mid ;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
