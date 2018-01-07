package com.skd.user.test;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.skd.user.pojo.AAdims;

/**
 *测试返回json  controller
 * @author HEII
 *
 */

@Controller
public class UsersController {

	/**
	 * @ResponseBody 蒋controller的 原有对象 返回 jsp页面
	 * produces MIME 类型解决乱码问题
	 * @return
	 */
	@RequestMapping(value="/login",produces="application/json;charset=UTF-8")
	@ResponseBody
	public AAdims fandeOne( ){
		AAdims aAdims =new AAdims();
		aAdims.setEmail("2134@.com");
		aAdims.setContent("大王大王");
		aAdims.setLast_login_time(new Date());
		aAdims.setQq("1172726898");
		System.out.println("=====spring  json====");
		return aAdims;
	}

	//方法二   fastjson工具实现返回

	@RequestMapping(value="/dataJson",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String dataJson( ){
		AAdims aAdims =new AAdims();
		aAdims.setEmail("2134@.com");
		aAdims.setContent("大王大王");
		aAdims.setLast_login_time(new Date());
		aAdims.setQq("1172726898");
		JSONObject result = (JSONObject) JSON.toJSON(aAdims);
		System.out.println("=====fastjson===="+ result.toJSONString());

		return result.toJSONString();
	}
}

