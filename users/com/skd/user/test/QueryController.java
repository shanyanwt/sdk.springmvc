package com.skd.user.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.skd.user.pojo.AAdims;

@Controller
@RequestMapping(value = "/query", method = { RequestMethod.POST,
		RequestMethod.GET })
public class QueryController {


	/**
	 * @param id
	 * @param age
	 * @RequestParam
	 */
	@RequestMapping("/findOne_{age}")
	public String findOne(@RequestParam String id, @PathVariable int age) {

		System.out.println("===queryid====" + id + ",;age=" + age);
		return "/findOne";

	}

	@RequestMapping("/insert")
	public String insert(AAdims users) {
		System.out.println("===Ausers ausers====" + "id:" + users.getId()
				+ ";name:" + users.getName() + ";socre:" + users.getEmail()
				+ "statr:" + users.getStatus());
		return "/findOne";
	}

	@RequestMapping("/insertSubmit")
	public String insertSubmi(AAdims users) {
		JSONObject result = (JSONObject) JSON.toJSON(users);
		System.out.println("=====返回结果====" + result.toJSONString());
		return result.toString();

	}

}
