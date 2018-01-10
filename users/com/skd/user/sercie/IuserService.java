package com.skd.user.sercie;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.skd.user.pojo.AAdims;

/**
 * 4 用户service
 * 一个Dao  对应  一张表
 * 一个Service持有多个dao的引用
 * 一个controller持有多个service
 *
 * @author HEII
 *
 */

public interface IuserService {

	/**
	 * 保存一条管理员
	 * @param adims
	 * @return json
	 *
	 */
	JSONObject saveOneAimsService(AAdims adims);

	/**
	 * 更新一条记录
	 *
	 * @param adims
	 * @return
	 */
	JSONObject updateOneAimsService(AAdims adims);

	/**
	 * 删除一条记录
	 *
	 * @param condMap
	 * @return
	 */
	JSONObject deleteOneAimsService(Map<String, Object> condMap);

	/**
	 * 查询一条管理员
	 *
	 * @param condMap
	 * @return
	 */
	AAdims findOneAdimsService(Map<String, Object> condMap);

	/**
	 * 查询多条记录
	 * 
	 * @return
	 */
	List<AAdims> findListService();
}
