package com.sdk.dao;

import java.util.List;
import java.util.Map;

/**
 * 常用方法Dao封装
 * 
 * @author YanJiang 2018年1月12日
 * @param T
 *            泛型 传过来的对象
 *
 */
public interface IBaseDao<T> {

	/**
	 * 添加&&保存一条数据
	 *
	 * @param t
	 *            管理员对象
	 * @return sql后对的数据库的影响条数
	 */

	int save(T t);

	/**
	 * 更新一条记录 为什么用(T t) 因为更新往往是对象的行为； 按照时间范围建一在写一个方法
	 *
	 * @param t
	 * @return
	 */
	int update(T t);

	/**
	 * 按照一定范围更新
	 *
	 * @param condMap
	 * @return
	 */

	T updateList(Map<String, Object> condMap);

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
	T findOne(Map<String, Object> condMap);

	/**
	 * 查询多条记录
	 *
	 * @return
	 */
	List<T> findList(Map<String, Object> condMap);

}
