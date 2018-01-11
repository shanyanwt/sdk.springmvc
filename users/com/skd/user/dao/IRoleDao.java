package com.skd.user.dao;

import java.util.List;
import java.util.Map;

import com.skd.user.pojo.ARole;


/**
 * 2 角色 的dao 一般四个方法 增删改查(查询单条或多条)
 * @author HEII
 *
 */

public interface IRoleDao {

	/**
	 * 添加&&保存一条数据
	 *
	 * @param role
	 *            管理员对象
	 * @return sql后对的数据库的影响条数
	 */

	int save(ARole role);

	/**
	 * 更新一条记录 为什么用(ARole role) 因为更新往往是对象的行为； 按照时间范围建一在写一个方法
	 *
	 * @param role
	 * @return
	 */
	int update(ARole role);

	/**
	 * 按照一定范围更新
	 *
	 * @param condMap
	 * @return
	 */

	ARole updateList(Map<String, Object> condMap);

	/**
	 * 删除一条记录
	 *
	 * @param condMap
	 * @return
	 */
	int delete(Map<String, Object> condMap);
	/**
	 * 查询一条记录
	 *
	 * @param conMap
	 *            查询条件，#{}，值是条件
	 * @return
	 */
	ARole findOne(Map<String, Object> condMap);

	/**
	 * 查询多条记录
	 *
	 * @return
	 */
	List<ARole> findList(Map<String, Object> condMap);

}
