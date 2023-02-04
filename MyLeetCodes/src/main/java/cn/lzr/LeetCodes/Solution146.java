package cn.lzr.LeetCodes;

import java.util.LinkedHashMap;

public class Solution146 {
	// LRU 缓存 https://leetcode.cn/problems/lru-cache/

	public static void main(String[] args) {


		//		LRUCache lruCache = new LRUCache(2);
//		lruCache.put(1,1);
//		lruCache.put(2,2);
//		System.out.println(lruCache.get(1));
//		lruCache.put(3,3);
//		System.out.println(lruCache.get(2));
//		lruCache.put(4,4);
//		System.out.println(lruCache.get(1));
//		System.out.println(lruCache.get(3));
//		System.out.println(lruCache.get(4));
	}

	static class LRUCache {
		// linkedHashMap 可以帮我们实现LRU但是不能固定长度，所以我们需要手动将元素放在队列的最后
		private int count;
		private LinkedHashMap<Integer, Integer> linkedHashMap;

		public LRUCache(int capacity) {
			this.count = capacity;
			this.linkedHashMap = new LinkedHashMap(capacity, 0.75f, true);
		}

		public int get(int key) {
			// 如果存在则会自动刷新元素到队尾，否则返回-1
			return  linkedHashMap.getOrDefault(key, -1);
		}

		public void put(int key, int value) {
			if (linkedHashMap.containsKey(key)) {
				// 说明元素还在缓存中
				linkedHashMap.put(key, value);
				// 更新元素到队列尾部
				linkedHashMap.get(key);
			} else {
				// 需要检测此时是否达到了队列的最大值
				if (linkedHashMap.size() == count){
					// 如果达到了最大值需要删除队列头的元素
					Integer curHead = linkedHashMap.keySet().iterator().next();
					linkedHashMap.remove(curHead);
				}
				// 插入到最后
				linkedHashMap.put(key, value);
			}
		}


	}
}
