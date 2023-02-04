package cn.lzr.LeetCodes;

import java.util.HashMap;
import java.util.Map;

public class Solution208 {
	// 208. 实现 Trie (前缀树)  https://leetcode.cn/problems/implement-trie-prefix-tree/
	class Trie {
		Map<Character, Trie> next;
		boolean isEnd;

		public Trie() {
			this.next = new HashMap<>();
			this.isEnd = false;
		}

		// 插入
		public void insert(String word) {
			Trie cur = this; // 得到根结点
			// 通过遍历所有单个字符来插入， 本质上是深度遍历，但不用递归
			for(char c : word.toCharArray()){
				if(cur.next.get(c) == null){ // 若当前无此字符，添加之
					cur.next.put(c, new Trie());
				}
				cur = cur.next.get(c); // 向下考察
			}
			cur.isEnd = true; // 置末尾字符节点isEnd为true
		}

		// 查找完全匹配
		public boolean search(String word) {
			Trie end = searchPrefix(word);
			return end != null && end.isEnd;
		}

		// 前缀匹配
		public boolean startsWith(String prefix) {
			return searchPrefix(prefix) != null;
		}

		private Trie searchPrefix(String prefix){
			Trie cur = this;
			// 本质上也是深度遍历，但不用递归
			for(char c : prefix.toCharArray()){
				if(cur.next.get(c) == null){
					return null; // 无此前缀，返回null
				}
				cur = cur.next.get(c);
			}
			return cur;
		}
	}
}
