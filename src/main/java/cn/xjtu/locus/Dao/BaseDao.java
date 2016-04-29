package cn.xjtu.locus.Dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<K extends Serializable, V> {
	void add(V entity);

	void delete(V entity);

	void delete(List<V> entities);

	void delete(K id);

	void update(V entity);

	V find(K id);

	V findSingle(String hql, Object... params);

	List<V> find(String ql, Object... params);

	List<V> findAll();
}