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
	 * sha256加密
	 *
	 * @param souStr
	 * @return
	 */
	public String encodStr(String souStr) {
		return DigestUtils.sha256Hex(souStr);

	}

	/**
	 * 比对加密字符串
	 *
	 * @param 前明后密
	 * @return boolen
	 */
	public boolean chcekStr(String souStr, String encodeStr) {
		return DigestUtils.sha256Hex(souStr).equalsIgnoreCase(encodeStr);

	}

}
