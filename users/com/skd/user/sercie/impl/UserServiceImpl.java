package com.skd.user.sercie.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sdk.util.PageUtil;
import com.skd.user.dao.IAdimsDao;
import com.skd.user.dao.IRoleDao;
import com.skd.user.pojo.AAdims;
import com.skd.user.pojo.ARole;
import com.skd.user.sercie.IuserService;

/**
 * 5 用户service的实现类
 * @author HEII
 *
 */

@Service("userService")
public class UserServiceImpl implements IuserService {

	@Resource
	private IAdimsDao adimsDao;
	@Resource
	private IRoleDao roleDao;

	@Override
	public JSONObject saveOneAimsService(AAdims adims) {

		JSONObject result = new JSONObject();
		int res = this.adimsDao.save(adims);
		if(res >0){
			/**
			 * jsoNObiect对象{}  .put 使用方式
			 * JSONArray[]  .add
			 * {"code":"1000","data":{"effect":1,"id":6},"info":"成功"}
			 */

			result.put("code", "1000");
			result.put("info", "成功");
			JSONObject dataJson = new JSONObject();
			/**
			 * id
			 * 条数
			 */
			dataJson.put("id", adims.getId());
			dataJson.put("effect", res);

			JSONArray jsonArray = new JSONArray();

			JSONObject items = new JSONObject();
			items.put("qq", adims.getQq());
			items.put("email", adims.getEmail());
			items.put("login_time", adims.getLast_login_time());
			jsonArray.add(items);
			dataJson.put("items", jsonArray);
			result.put("data", dataJson);

			//json解析  获取json信息  返回的数据是什么就用什么接收   Object || Array
			String jsonStr = result.toJSONString();
			JSONObject resultJs = (JSONObject) JSON.parse(jsonStr);
			String itemCode = resultJs.getString("code");
			String itemInfo = resultJs.get("info")+ "";
			System.out.println("======code=="+itemCode +";info"+itemInfo);
			// 获取对象
			JSONObject itemData = (JSONObject) resultJs.get("data");

			String itemId = itemData.getString("id");
			System.out.println("======itemId=="+itemId);
			//获取list
			JSONArray qitem = (JSONArray) itemData.get("items");

			for (Object i : qitem) {
				JSONObject iQ = (JSONObject) i;
				String email = iQ.getString("email");
				System.out.println("======itemsEmail=="+email);
			}
			// 打印pojo的tostring
			// System.out.println(adims);

		}else {
			result.put("code", "500");
			result.put("info", "失败!");
		}
		return result;
	}

	@Override
	public AAdims findOneAdimsService(Map<String, Object> condMap) {

		return this.adimsDao.findOne(condMap);
	}

	/* (non-Javadoc)
	 * @see com.skd.user.sercie.IuserService#updateOneAimsService(com.skd.user.pojo.AAdims)
	 */
	@Override
	public JSONObject updateOneAimsService(AAdims adims) {
		JSONObject result = new JSONObject();
		int res = this.adimsDao.update(adims);
		if (res > 0) {
			result.put("code", "1000");
			result.put("message", "成功");
			result.put("data", adims);
		} else {
			result.put("code", "500");
			result.put("info", "失败!");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.skd.user.sercie.IuserService#deleteOneAimsService(java.util.Map)
	 */
	@Override
	public JSONObject deleteOneAimsService(Map<String, Object> condMap) {
		JSONObject result = new JSONObject();
		int res = adimsDao.delete(condMap);
		if (res > 0) {
			result.put("code", "1000");
			result.put("info", "成功");
		} else {
			result.put("code", "500");
			result.put("info", "失败!");
		}
		return result;
	}


	@Override
	public List<AAdims> findListService(PageUtil pageUtil,
			Map<String, Object> condMap) {
		/* 匹配模糊关键字 */
		if (condMap.get("keyword") != null) {
			condMap.put("keyword", "%" + condMap.get("keyword") + "%");
		}
		/**
		 * 分页查询
		 */
		if (pageUtil != null) {
			// 获取工具类的当前页，每页多少条
			Page page = PageHelper.startPage(pageUtil.getCurrentPage(),
					pageUtil.getPageSize());
			List<AAdims> aAdims = adimsDao.findList(condMap);
			// 建议转为Long 类型 int
			pageUtil.setToalRecord(Long.valueOf(page.getTotal()).intValue());
			return aAdims;
		}
		return adimsDao.findList(condMap);
	}

	/* =========================== */
	@Override
	public JSONObject saveOneARoleService(ARole role) {

		JSONObject result = new JSONObject();
		int res = this.roleDao.save(role);
		if (res > 0) {
			/**
			 * jsoNObiect对象{} .put 使用方式 JSONArray[] .add
			 * {"code":"1000","data":{"effect":1,"id":6},"info":"成功"}
			 */

			result.put("code", "1000");
			result.put("info", "成功");
			JSONObject dataJson = new JSONObject();
			/**
			 * id 条数
			 */
			dataJson.put("id", role.getId());
			dataJson.put("effect", res);

			JSONArray jsonArray = new JSONArray();

			JSONObject items = new JSONObject();
			jsonArray.add(items);
			dataJson.put("items", jsonArray);
			result.put("data", dataJson);

			// json解析 获取json信息 返回的数据是什么就用什么接收 Object || Array
			String jsonStr = result.toJSONString();
			JSONObject resultJs = (JSONObject) JSON.parse(jsonStr);
			String itemCode = resultJs.getString("code");
			String itemInfo = resultJs.get("info") + "";
			System.out.println("======code==" + itemCode + ";info" + itemInfo);
			// 获取对象
			JSONObject itemData = (JSONObject) resultJs.get("data");

			String itemId = itemData.getString("id");
			System.out.println("======itemId==" + itemId);
			// 获取list
			JSONArray qitem = (JSONArray) itemData.get("items");

			for (Object i : qitem) {
				JSONObject iQ = (JSONObject) i;
				String email = iQ.getString("email");
				System.out.println("======itemsEmail==" + email);
			}
			// 打印pojo的tostring
			// System.out.println(role);

		} else {
			result.put("code", "500");
			result.put("info", "失败!");
		}
		return result;
	}

	@Override
	public ARole findOneARoleService(Map<String, Object> condMap) {

		return roleDao.findOne(condMap);
	}

	@Override
	public JSONObject updateOneARoleService(ARole role) {
		JSONObject result = new JSONObject();
		int res = this.roleDao.update(role);
		if (res > 0) {
			result.put("code", "1000");
			result.put("message", "成功");
			result.put("data", role);
		} else {
			result.put("code", "500");
			result.put("info", "失败!");
		}
		return result;
	}
	@Override
	public JSONObject deleteOneARoleService(Map<String, Object> condMap) {
		JSONObject result = new JSONObject();
		int res = roleDao.delete(condMap);
		if (res > 0) {
			result.put("code", "1000");
			result.put("info", "成功");
		} else {
			result.put("code", "500");
			result.put("info", "失败!");
		}
		return result;
	}

	@Override
	public List<ARole> findARoleListService(PageUtil pageUtil,
			Map<String, Object> condMap) {
		/* 匹配模糊关键字 */
		if (condMap.get("keyword") != null) {
			condMap.put("keyword", "%" + condMap.get("keyword") + "%");
		}
		/**
		 * 分页查询
		 */
		if (pageUtil != null) {
			// 获取工具类的当前页，每页多少条
			Page page = PageHelper.startPage(pageUtil.getCurrentPage(),
					pageUtil.getPageSize());
			List<ARole> aAdims = roleDao.findList(condMap);
			// 建议转为Long 类型 int
			pageUtil.setToalRecord(Long.valueOf(page.getTotal()).intValue());
			return aAdims;
		}
		return roleDao.findList(condMap);
	}

}
