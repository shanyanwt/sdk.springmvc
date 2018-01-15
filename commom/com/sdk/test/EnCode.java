package com.sdk.test;

import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import com.sdk.util.EncreyptUtil;
import com.sdk.util.RegexUtil;

/**
 * 测试常用的加密算法
 *
 * @author YanJiang 2018年1月14日
 *
 */
public class EnCode {

	@Test
	public void enConde() {
		/* 明文 */
		String souStr = "11111";
		String enCodeStr = "";
		/*
		 * md5加密
		 */
		enCodeStr = DigestUtils.md5Hex(souStr);
		System.out.println("md5：明文," + souStr + "---密文:" + enCodeStr
				+ "---密文长度:" + enCodeStr.length());

		/*
		 * sha256加密
		 */
		enCodeStr = DigestUtils.sha256Hex(souStr);
		System.out.println("sha256：明文," + souStr + "---密文:" + enCodeStr
				+ "---密文长度:" + enCodeStr.length());

		/*
		 * sha512加密
		 */
		enCodeStr = DigestUtils.sha512Hex(souStr);
		System.out.println("sha512：明文," + souStr + "---密文:" + enCodeStr
				+ "---密文长度:" + enCodeStr.length());
	}

	/**
	 * 可逆加密
	 */

	@Test
	public void enCondeDe() {
		/* 明文 */
		String souStr = "张三";
		String enCodeStr = "";
		/*
		 * base64加密
		 */
		byte[] res = Base64.encodeBase64(souStr.getBytes());
		enCodeStr = new String(res);
		System.out.println(" base64：明文," + souStr + "---密文:" + enCodeStr
				+ "---密文长度:" + enCodeStr.length());

		/*
		 * 解密
		 */

		res = Base64.decodeBase64(enCodeStr);
		enCodeStr = new String(res);
		System.out.println("解密：" + enCodeStr);
	}

	/**
	 * 加密对比
	 *
	 * @return boolen
	 */
	@Test
	public void encreyptUtil() {

		String souStr = "yan";
		EncreyptUtil encreyq = new EncreyptUtil();
		String enStr = encreyq.encodStr(souStr);
		System.out.println(enStr);
		// 明文和加密比对

		boolean res = encreyq.chcekStr(souStr, enStr);
		System.out.println(res);

	}

	@Test
	public void randomUUID() {
		// 3、时间戳和随机字符串
		String noncestr = UUID.randomUUID().toString().replace("-", "")
				.substring(0, 16);
		String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
		System.out.println(noncestr + "=======" + timestamp);

		RegexUtil random = new RegexUtil();
		String aString = random.randomStr(10);
		System.out.println(aString);
	}
}
