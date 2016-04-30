package cn.xjtu.locus.Service;

import java.io.Serializable;
import java.util.List;


public interface BaseService <ID extends Serializable,T>{

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
	 * 移除实体对象集合
	 * 
	 * @param List<entity> 实体对象
	 */
	void delete(List<T> entities);

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
	 * 查询所有实体对象
	 * 
	 */
	List<T> findAll();
}
