package com.skd.user.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.sdk.test.util;
import com.sdk.util.ContstatFinaUtil;
import com.sdk.util.EncreyptUtil;
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
		EncreyptUtil encrey = new EncreyptUtil();
		AAdims adims = new AAdims();
		adims.setRole_id(1);
		adims.setEmail("1172716898@.com");
		adims.setName("江小二");
		adims.setContent("时刻点新闻晚报");
		adims.setPassword(encrey.encodStr("@yanjiang"));
		adims.setPhone("3245");
		adims.setQq("1234356");
		adims.setCreate_time(new Date());
		adims.setLast_login_time(new Date());
		adims.setUpdate_time(new Date());
		JSONObject result =userService.saveOneAimsService(adims);
		ContstatFinaUtil.LOGGER.info(result);
	}

	/**
	 * 查询一条管理员
	 */
	@Test
	public void findOneAdimsService() {
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("id", "2");
		AAdims adims = userService.findOneAdimsService(condMap);
		ContstatFinaUtil.LOGGER.info("查询结果：" + adims.toString());
		// 查询角色
		ARole role = adims.getRole();
		ContstatFinaUtil.LOGGER.info("角色信息==" + role);
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
		/* 查询管理员集合 */
		List<AAdims> aAdims = role.getAdimsList();
		for (AAdims adimsList : aAdims) {
			ContstatFinaUtil.LOGGER.info("管理员结果：" + adimsList);
		}
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
