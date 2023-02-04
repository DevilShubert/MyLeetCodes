package cn.lzr.others.hot100;

public class Solution49 {

  public static void main(String[] args) {
    int[] ints = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    Solution49 solution49 = new Solution49();
    System.out.println(solution49.findKthLargest(ints, 4));
  }

  public int findKthLargest(int[] nums, int k) {
    quickSort(nums, 0, nums.length - 1);
    return nums[nums.length - k];
  }

  public void quickSort(int[] arr, int low, int high) {
    int i, j, temp, t;
    if (low > high) {
      return;
    }
    i = low;
    j = high;
    // temp就是基准位
    temp = arr[low];

    while (i < j) {
      // 先看右边，依次往左递减
      while (temp <= arr[j] && i < j) {
        j--;
      }
      // 再看左边，依次往右递增
      while (temp >= arr[i] && i < j) {
        i++;
      }
      // 如果满足条件则交换
      if (i < j) {
        t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
      }
    }
    // 最后将基准为与i和j相等位置的数字交换，这时肯定有i=j
    arr[low] = arr[i];
    arr[i] = temp;
    // 递归调用左半数组
    quickSort(arr, low, j - 1);
    // 递归调用右半数组
    quickSort(arr, j + 1, high);
  }
}
