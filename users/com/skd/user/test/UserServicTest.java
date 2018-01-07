package com.skd.user.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.sdk.test.util;
import com.sdk.util.ContstatFinaUtil;
import com.skd.user.pojo.AAdims;
import com.skd.user.sercie.IuserService;

/**
 * 6 用户service测试类
 * @author HEII
 *
 */
public class UserServicTest extends util {

	private IuserService userService;

	@Before
	public void initService(){
		userService = (IuserService) ac.getBean("userService");
	}
	@Test
	public void saveOneAimsService() {
		AAdims adims = new AAdims();
		adims.setRole_id(1);
		adims.setEmail("3232@.com");
		adims.setName("张三");
		adims.setContent("dad");
		adims.setPassword("cdacd");
		adims.setPhone("3245");
		adims.setQq("1234356");
//		adims.setStatus((byte) 1);
//		adims.setSex((byte) 1);
		adims.setCreate_time(new Date());
		adims.setLast_login_time(new Date());
		adims.setUpdate_time(new Date());
		JSONObject result =userService.saveOneAimsService(adims);
		ContstatFinaUtil.LOGGER.info(result);
	}

	@Test
	public void savedAimsService() {
		AAdims adims = new AAdims();
		for (int i = 0; i < 100; i++) {
			adims.setRole_id(1);
			adims.setEmail("3232@.com_" + i);
			adims.setName("小美_" + i);
			adims.setContent("dad_" + i);
			adims.setPassword("cdacd_" + i);
			adims.setPhone("3245_" + i);
			adims.setQq("1234356_" + i);
			adims.setCreate_time(new Date());
			adims.setLast_login_time(new Date());
			adims.setUpdate_time(new Date());
			JSONObject result = userService.saveOneAimsService(adims);
			int rand = new Random().nextInt(1000);
			ContstatFinaUtil.LOGGER.info(result + "随机数" + rand);
			try {
				Thread.sleep(rand);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 查询一条管理员
	 */
	@Test
	public void findOneAdimsService() {
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("id", "5");
		AAdims adims = userService.findOneAdimsService(condMap);
		ContstatFinaUtil.LOGGER.info("查询结果：" + adims.toString());
	}

	/**
	 * 查询一条管理员
	 */
	@Test
	public void updateOneAimsService() {
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("id", "5");
		AAdims adims = userService.findOneAdimsService(condMap);
		ContstatFinaUtil.LOGGER.info("更新之前：" + adims.toString());

		adims.setEmail("1172716898@qq.com");
		adims.setUpdate_time(new Date());
		JSONObject resultJson = userService.updateOneAimsService(adims);

		ContstatFinaUtil.LOGGER.info("更新之后：" + resultJson.toString());
	}

	/**
	 * 删除一条记录
	 */
	@Test
	public void deleteOneAimsService() {
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("id", "2");
		JSONObject adims = userService.deleteOneAimsService(condMap);
		ContstatFinaUtil.LOGGER.info("查询结果：" + adims.toString());
	}

}
