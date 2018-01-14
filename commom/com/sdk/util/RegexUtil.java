package com.sdk.util;

import java.util.Random;

/**
 * 正则相关的工具
 *
 * @author YanJiang 2018年1月14日
 *
 */
public class RegexUtil {
	/**
	 * 随机数（a-zA-Z0-9）
	 *
	 * @param len
	 *            要生成字符串的长度
	 * @return
	 */
	public String randomStr(int len) {
		// 字符拼接 append(ch)
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < len; i++) {
			int randInt = random.nextInt(ContstatFinaUtil.ALL_STRING.length());
			// 指定位置在char字符上
			char ch = ContstatFinaUtil.ALL_STRING.charAt(randInt);
			// System.out.println(ch);
			sb.append(ch);
		}
		/**
		 * String noncestr = UUID.randomUUID().toString().replace("-", "")
		 * .substring(0, 16); 生成范围（a-z0-9）
		 */

		return sb.toString();
	}

}
