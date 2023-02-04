package cn.lzr.sorts.quickSort;

public class QuickSort {
	// left是0，right是length-1
	public static Integer[] quicksort(Integer[] a, Integer left, Integer right) {
		// 当left = right时 就说明当前序列就只有一个值
		if (left <= right) {
			// 第一次调整后确定pivot位置
			int mid = quick(a, left, right);
			quicksort(a, left, mid - 1);
			quicksort(a, mid + 1, right);
		}
		return a;
	}

	// 在每一轮的quick中其实就有排序的步骤
	public static int quick(Integer[] a, Integer left, Integer right) {
		// 目标就是将下表为pivot的元素挪到数组中间的某个位置
		int pivot = a[left];
		int i = left + 1;
		int j = right;

		// j为右哨兵，i为左哨兵，每次都是j先往左走找第一个小于等于pivot的元素
		while (i < j) {
			while (a[j] > pivot && i < j) j--;
			while (a[i] < pivot && i < j) i++;
			Integer temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		// 最后肯定i = j
		a[left] = a[j];
		a[i] = pivot;
		return j;
	}
}
