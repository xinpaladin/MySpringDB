package cn.xjtu.locus.ServiceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.xjtu.locus.Dao.BaseDao;
import cn.xjtu.locus.Service.BaseService;

@Transactional
public class BaseServiceImpl<ID extends Serializable , T> implements BaseService<ID, T>{

	/** baseDao */
	private BaseDao<ID,T > baseDao;

	public void setBaseDao(BaseDao<ID, T> baseDao) {
		this.baseDao = baseDao;
	}

	public void add(T entity) {
		baseDao.add(entity);
	}

	public void delete(T entity) {
		baseDao.delete(entity);
		
	}

	public void delete(List<T> entities) {
		for(T entity:entities){
			delete(entity);
		}
		
	}

	public void delete(ID id) {
		baseDao.delete(id);
		
	}

	public void update(T entity) {
		baseDao.update(entity);
		
	}

	public T find(ID id) {
		return baseDao.find(id);
	}


	public List<T> findAll() {
		// TODO Auto-generated method stub
		return baseDao.findAll();
	}

}
