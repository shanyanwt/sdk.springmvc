package com.skd.user.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sdk.test.util;
import com.sdk.util.ContstatFinaUtil;
import com.sdk.util.PageUtil;
import com.skd.user.pojo.AAdims;
import com.skd.user.sercie.IuserService;

/**
 * api接口测试类
 *
 * @author YanJiang 2018年1月15日
 *
 */
@Controller
@RestController
public class ApiTest extends util {

	@Resource
	private IuserService userService;

	/**
	 * @return
	 * @ResponseBody 蒋controller的 原有对象 返回 jsp页面 produces MIME 类型解决乱码问题
	 * @return
	 */
	@RequestMapping(value = "user/info", method = RequestMethod.GET)
	public AAdims fandeOne(AAdims aAdims) {

		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("id", aAdims.getId());
		return userService.findOneAdimsService(condMap);
	}

	@RequestMapping(value = "adminList", method = RequestMethod.GET)
	public String adminList(HttpServletRequest request) {
		// 搜索功能
		System.out.println(request);
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("keyword", "18");
		PageUtil pageUtil = new PageUtil();
		List<AAdims> adims = userService.findListService(pageUtil, condMap);
		int conte = 0;
		for (AAdims items : adims) {

			ContstatFinaUtil.LOGGER.info("查询结果：" + conte + items.toString());
			conte++;
		}
		request.setAttribute("data", adims.toString());
		return adims.toString();
	}

}
