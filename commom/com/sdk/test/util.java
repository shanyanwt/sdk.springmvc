package com.sdk.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdk.util.ContstatFinaUtil;


/**
 * 测试类的父类
 * 初始化spring加载前置后置
 * @author HEII
 *
 */

public class util {

	/**
	 * spring的应用上下文，
	 * @param
	 */
	public ApplicationContext ac;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		ContstatFinaUtil.LOGGER.info("====init=======");
	}

	@Test
	public void test() {
		ContstatFinaUtil.LOGGER.info("====test=======");
	}

	/**
	 * spring关闭
	 * @param
	 */
	@After
	public void close() {
		if (this.ac instanceof ApplicationContext) {
			ClassPathXmlApplicationContext cpac =(ClassPathXmlApplicationContext) this.ac;
			cpac.close();
		}
		ContstatFinaUtil.LOGGER.info("====close=======");
	}
}
