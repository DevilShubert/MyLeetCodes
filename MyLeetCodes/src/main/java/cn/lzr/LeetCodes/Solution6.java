package cn.lzr.LeetCodes;

public class Solution6 {
	//  Z 字形变换 https://leetcode-cn.com/problems/zigzag-conversion/
	public String convert(String s, int numRows) {

		// numRows = 1;
		if(numRows == 1 || s.length() == 1) {
			return s;
		}

		int len = s.length();
		int loop = len / numRows + 1; // 总共的循环次数 PAYPALISHIRING长度为 14
		int xC = numRows; // 向下为x轴
		int yC = loop * (numRows - 1); // 向右为y轴
		char[][] chars = new char[xC][yC];
		int index = 0;

		for (int lp = 0; lp < loop; lp++){
			// 向下遍历
			for (int i = 0; i < numRows - 1; i++) {
				if (index >= len) break;
				chars[i][lp * numRows - lp] = s.charAt(index++);
			}
			// 斜向上遍历
			for (int i = numRows - 1; i > 0; i--){
				if (index >= len) break;
				int nextLp = (lp + 1) * numRows - lp -1 ;
				chars[i][nextLp-i] = s.charAt(index++);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < xC; i++){
			for (int j = 0; j < yC; j++){
				// 空char表示为'\0'
				if (chars[i][j] != '\0' ) {
					sb.append(chars[i][j]);
				}
			}
		}

		return new String(sb);
	}
}
