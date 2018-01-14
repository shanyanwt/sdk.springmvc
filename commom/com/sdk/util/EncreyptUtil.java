package com.sdk.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 字符串 加密工具类
 *
 * @author YanJiang 2018年1月14日
 *
 */
public class EncreyptUtil {

	/**
	 * sha256加密 加密算法=$da32$+'yanjaing' sb.substring(0, 8);
	 *
	 * @param souStr
	 * @return
	 */
	public String encodStr(String souStr) {
		String split = "$";
		RegexUtil randomUtil = new RegexUtil();
		String random = randomUtil.randomStr(8);
		// 固定随机字符
		String fixed = split + random + split;
		String pass = DigestUtils.sha256Hex(fixed + souStr);
		return fixed + pass;
	}

	/**
	 * 比对加密字符串
	 *
	 * @param 前明后密
	 * @return boolen
	 */
	public boolean chcekStr(String souStr, String encodeStr) {

		String split = "$";
		String[] random = encodeStr.split("\\" + split);
		if (random.length == 3) {
			// 固定随机字符
			String fixed = split + random[1] + split;
			String pass = DigestUtils.sha256Hex(fixed + souStr);
			// 最终加密之后的
			String finalStr = fixed + pass;
			return finalStr.equalsIgnoreCase(encodeStr);
		}
		return false;

	}

}
