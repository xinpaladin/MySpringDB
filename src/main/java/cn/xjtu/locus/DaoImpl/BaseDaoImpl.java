package cn.xjtu.locus.DaoImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cn.xjtu.locus.Dao.BaseDao;

public class BaseDaoImpl<K extends Serializable, V> implements BaseDao<K, V> {

	/** 实体类类型 */
	private Class<V> entityClass;

	@PersistenceContext
	protected EntityManager manager;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Type type = getClass().getGenericSuperclass();
		Type[] parameterizedType = ((ParameterizedType) type)
				.getActualTypeArguments();
		entityClass = (Class<V>) parameterizedType[0];
	}

	public void add(V entity) {
		manager.persist(entity);
	}

	public void delete(V entity) {
		manager.remove(entity);
	}

	public void delete(List<V> entities) {
		for (V entity : entities) {
			delete(entity);
		}
	}

	public void delete(K id) {
		manager.remove(find(id));
	}

	public void update(V entity) {
		manager.merge(entity);
	}

	public V find(K id) {
		return manager.find(entityClass, id);
	}

	public V findSingle(String hql, Object... params) {
		return null;
	}

	/** 根据带占位符参数的JPQL语句查询实体*/
	@SuppressWarnings("unchecked")
	public List<V> find(String jql, Object... params) {
		Query query = manager.createNamedQuery(jql);
		for(int i =0;i<params.length;i++){
			query.setParameter(i, params[i]);
		}
		return (List<V>)query.getResultList();
	}

	public List<V> findAll() {

		return null;
	}

}
