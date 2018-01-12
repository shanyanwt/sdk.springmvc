package com.skd.user.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.sdk.test.util;
import com.sdk.util.ContstatFinaUtil;
import com.sdk.util.PageUtil;
import com.skd.user.pojo.AAdims;
import com.skd.user.pojo.ARole;
import com.skd.user.sercie.IuserService;

/**
 * 6 用户service测试类
 *
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
	 * 修改一条管理员
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
		condMap.put("id", "5");
		JSONObject adims = userService.deleteOneAimsService(condMap);
		ContstatFinaUtil.LOGGER.info("查询结果：" + adims.toString());
	}

	/**
	 * 查询多条 管理员 以下几种情况 1：不带条件分页 2：带条件的分页 3：不带条件的不分页 4：带条件的不分页
	 *
	 */
	@Test
	public void findListService() {
		// 搜索功能
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("keyword", "18");
		/*
		 * condMap.put("status", "1"); condMap.put("seDtate", new Date());
		 * condMap.put("edDtate", new Date());
		 */

		// 查询所有 不分页 传null
		/* List<AAdims> adims = userService.findListService(null); */

		PageUtil pageUtil = new PageUtil();
		// pageUtil.setCurrentPage(1);
		// pageUtil.setPageSize(20);
		List<AAdims> adims = userService.findListService(pageUtil, condMap);
		int conte = 0;
		for (AAdims aAdims : adims) {

			ContstatFinaUtil.LOGGER.info("查询结果：" + conte + aAdims.toString());
			conte++;
		}
		ContstatFinaUtil.LOGGER.info("分页信息：" + pageUtil);
	}

	/* ==============角色开始======================= */
	/**
	 * 查询一条管角色
	 */
	@Test
	public void findOneARoleService() {
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("id", "1");
		ARole role = userService.findOneARoleService(condMap);
		ContstatFinaUtil.LOGGER.info("查询结果：" + role.toString());
	}

	@Test
	public void saveOneARoleService() {
		ARole role = new ARole();
		role.setName("小二_");
		role.setStatus(1);
		role.setContent("新华社时刻更新_");
		role.setCreate_time(new Date());
		role.setUpdate_time(new Date());
		JSONObject result = userService.saveOneARoleService(role);
		ContstatFinaUtil.LOGGER.info(result);
	}

	/**
	 * 修改一条角色
	 */
	@Test
	public void updateOneARoleService() {
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("id", "5");
		ARole role = userService.findOneARoleService(condMap);
		ContstatFinaUtil.LOGGER.info("更新之前：" + role.toString());

		role.setName("xinliang");
		role.setUpdate_time(new Date());
		JSONObject resultJson = userService.updateOneARoleService(role);

		ContstatFinaUtil.LOGGER.info("更新之后：" + resultJson.toString());
	}

	/**
	 * 删除一条记录
	 */
	@Test
	public void deleteOneARoleService() {
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("id", "2");
		JSONObject adims = userService.deleteOneARoleService(condMap);
		ContstatFinaUtil.LOGGER.info("查询结果：" + adims.toString());
	}

	@Test
	public void findARoleListService() {
		// 搜索功能
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("keyword", "小二");
		/*
		 * condMap.put("status", "1"); condMap.put("seDtate", new Date());
		 * condMap.put("edDtate", new Date());
		 */

		// 查询所有 不分页 传null
		/* List<AAdims> adims = userService.findListService(null); */

		PageUtil pageUtil = new PageUtil();
		// pageUtil.setCurrentPage(1);
		// pageUtil.setPageSize(20);
		List<ARole> role = userService.findARoleListService(pageUtil, condMap);
		int conte = 0;
		for (ARole roles : role) {
			ContstatFinaUtil.LOGGER.info("查询结果：" + conte + roles.toString());
			conte++;
		}
		ContstatFinaUtil.LOGGER.info("分页信息：" + pageUtil);
	}

}
