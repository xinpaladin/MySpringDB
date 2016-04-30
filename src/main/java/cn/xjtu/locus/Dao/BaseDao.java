package cn.xjtu.locus.Dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<ID extends Serializable, T> {
	/**
	 * 持久化实体对象
	 * 
	 * @param entity 实体对象
	 */
	void add(T entity);

	/**
	 * 移除实体对象
	 * 
	 * @param entity 实体对象
	 */
	void delete(T entity);


	/**
	 * 删除实体对象
	 * 
	 * @param entity 实体对象
	 */
	void delete(ID id);

	
	/**
	 * 刷新实体对象
	 * 
	 * @param entity 实体对象
	 */
	void update(T entity);


	/**
	 * 查找实体对象
	 * 
	 * @param id ID
	 * @return 实体对象，若不存在则返回null
	 */
	T find(ID id);

	/**
	 * 查询实体对象
	 * 
	 * @param entity 实体对象
	 * @param lockModeType 锁定方式
	 */
	T findSingle(String hql, Object... params);

	/**
	 * 查询实体对象
	 * 
	 * @param entity 实体对象
	 * @param lockModeType 锁定方式
	 */
	List<T> find(String ql, Object... params);

	/**
	 * 查询所有实体对象
	 * 
	 */
	List<T> findAll();
}