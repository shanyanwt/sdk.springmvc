package com.skd.user.dao;

import java.util.List;
import java.util.Map;

import com.skd.user.pojo.AAdims;


/**
 * 2 管理员的dao
 * 一般四个方法
 * 增删改查(查询单条或多条)
 *
 * @author HEII
 *
 */

public interface IAdimsDao {

	/**
	 * 添加&&保存一条数据
	 * @param aAdims 管理员对象
	 * @return  sql后对的数据库的影响条数
	 */

	int save(AAdims aAdims);

	/**
	 * 更新一条记录 为什么用(AAdims aAdims) 因为更新往往是对象的行为； 按照时间范围建一在写一个方法
	 *
	 * @param aAdims
	 * @return
	 */
	int update(AAdims aAdims);

	/**
	 * 按照一定范围更新
	 *
	 * @param condMap
	 * @return
	 */

	AAdims updateList(Map<String, Object> condMap);

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
	AAdims findOne(Map<String, Object> condMap);

	/**
	 * 查询多条记录
	 *
	 * @return
	 */
	List<AAdims> findList(Map<String, Object> condMap);

}
