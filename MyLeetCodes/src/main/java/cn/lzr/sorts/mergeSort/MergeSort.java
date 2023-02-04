package cn.lzr.sorts.mergeSort;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		Integer[] a = {1, 3, 2, 7, 9, 4, 1, 2, 0, 10, -32, 6, 33};
		Integer[] res = MergeSort.mergeSort(a,0,a.length-1);
		System.out.println(Arrays.toString(res));
	}
	// 对本地数组操作，而不是通过复制后的数组
	public static Integer[] mergeSort(Integer[] a, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			// 类似于树形结构递归，最底层肯定是从单个元素开始归并
			a = MergeSort.mergeSort(a, left, mid);
			a = MergeSort.mergeSort(a, mid + 1, right);
			merge(a, left, mid, right);
		}
		return a;
	}

	// 假设数组A、B都只有两个元素时的比较方法
	public static Integer[] merge(Integer[] a, int left, int mid, int right) {
		Integer[] integers = new Integer[right - left+1];
		int i = left;
		int j = mid + 1;

		// k给中间变量数组integers准备
		int k = 0;

		// 两个子数组比较，存入临时数组中
		while (i <= mid && j <= right) {
			if (a[i] < a[j]) {
				integers[k++] = a[i++];
			} else {
				integers[k++] = a[j++];
			}
		}

		// 没有加完的情况时就不用比较直接追加在后面
		while (j <= right) integers[k++] = a[j++];
		while (i <= mid) integers[k++] = a[i++];

		// 为了不产生多的内存 把临时数组复制到原数组中
		for (i = 0; i < integers.length; i++) {
			a[left++] = integers[i];
		}

		return a;
	}
}
