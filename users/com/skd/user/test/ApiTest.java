package com.skd.user.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sdk.test.util;
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

	private IuserService userService;

	@Before
	public void initService() {
		userService = (IuserService) ac.getBean("userService");
	}

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

}
