package cn.lzr.sorts.mergeSort;

import dataStructure.ListNode;

public class MergeSort2 {
	// 对链表使用归并排序，注意链表的merge方法必须用递归
	// 传入两个链表排序成一个链表
	public ListNode sortList(ListNode head) {
		if (head == null) return head;

		//  首先获得链表长度
		int len = 0;
		ListNode node = head;
		while (node != null) {
			len++;
			node = node.next;
		}

		//    归并的方式就不再是排序数组那样可以用下标递归，而拆分为一块一块的部分链表
		//    部分链表长度：1、2、4、8
		ListNode dummyNode = new ListNode(0, head);

		for (int subLen = 1; subLen < len; subLen <<= 1) {
			ListNode prev = dummyNode;
			ListNode cur = dummyNode.next;

			while (cur != null) {
				ListNode h1 = cur;
				// 拆分出长度为subLen的链表1
				for (int i = 1; i < subLen && cur != null && cur.next != null; i++) {
					cur = cur.next;
				}
				ListNode h2 = cur.next; // 第二个链表的头  即 链表1尾部的下一个位置
				cur.next = null; // 断开第一个链表和第二个链表的链接
				cur = h2; // 第二个链表头 重新赋值给cur

				// 再拆分出长度为subLen的链表2
				for (int i = 1; i < subLen && cur != null && cur.next != null; i++) {
					cur = cur.next;
				}
				//  再次断开 第二个链表最后的next的链接
				ListNode next = null;
				if (cur != null) {
					next = cur.next; // next用于记录 两个subList后一个结点，也就是下一组合并子链表
					cur.next = null; // 断开连接
				}
				prev.next = mergeTwoLists(h1, h2);
				while (prev.next != null) {
					// 保持在cur前一个位置
					prev = prev.next;
				}
				cur = next;
			}
		}

		return dummyNode.next;
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null) return list2;
		if (list2 == null) return list1;
		if (list1.val < list2.val) {
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoLists(list1, list2.next);
			return list2;
		}
	}
}
