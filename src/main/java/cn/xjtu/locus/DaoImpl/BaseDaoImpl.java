package cn.xjtu.locus.DaoImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cn.xjtu.locus.Dao.BaseDao;

public class BaseDaoImpl<ID extends Serializable, T> implements BaseDao<ID, T> {

	/** 实体类类型 */
	private Class<T> entityClass;

	@PersistenceContext
	protected EntityManager manager;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Type type = getClass().getGenericSuperclass();
		Type[] parameterizedType = ((ParameterizedType) type)
				.getActualTypeArguments();
		entityClass = (Class<T>) parameterizedType[1];
	}

	public void add(T entity) {
		manager.persist(entity);
	}

	public void delete(T entity) {
		manager.remove(entity);
	}

	public void delete(ID id) {
		manager.createQuery("delete" + entityClass.getSimpleName() +"en where en.id = ?0").setParameter(0, id).executeUpdate();
	}

	public void update(T entity) {
		manager.merge(entity);
	}

	public T find(ID id) {
		return manager.find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public T findSingle(String hql, Object... params) {
		Query query = manager.createQuery(hql);
		for(int i=0;i<params.length;i++){
			query.setParameter(i, params[i]);
		}
		return (T) query.getSingleResult();
	}

	/** 根据带占位符参数的JPQL语句查询实体*/
	@SuppressWarnings("unchecked")
	public List<T> find(String jql, Object... params) {
		Query query = manager.createNamedQuery(jql);
		for(int i =0;i<params.length;i++){
			query.setParameter(i, params[i]);
		}
		return (List<T>)query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		
		return manager.createQuery("selecr en from" + entityClass.getSimpleName()+" en").getResultList();
	}

}


