package com.skd.user.test;

import java.util.Date;

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

		users.setContent("大王大王");
		users.setLast_login_time(new Date());
		users.setQq("1172726898");
		JSONObject result = (JSONObject) JSON.toJSON(users);
		System.out.println("=====fastjson====" + result.toJSONString());

		System.out.println("===Ausers ausers====" + "id:" + users.getId()
				+ ";name:" + users.getName() + ";socre:" + users.getEmail()
				+ "statr:" + users.getStatus());
		return "/findOne";

	}

}
