package cn.xjtu.locus.ServiceImpl;

import java.io.Serializable;
import java.util.List;

import cn.xjtu.locus.Dao.BaseDao;
import cn.xjtu.locus.Service.BaseService;

public class BaseServiceImpl<ID extends Serializable , T> implements BaseService<ID, T>{

	/** baseDao */
	private BaseDao<ID,T > baseDao;

	public void setBaseDao(BaseDao<ID, T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void add(T entity) {
		
		baseDao.add(entity);
	}

	@Override
	public void delete(T entity) {
		baseDao.delete(entity);
		
	}

	@Override
	public void delete(List<T> entities) {
		for(T entity:entities){
			delete(entity);
		}
		
	}

	@Override
	public void delete(ID id) {
		baseDao.delete(id);
		
	}

	@Override
	public void update(T entity) {
		baseDao.update(entity);
		
	}

	@Override
	public T find(ID id) {
		
		return baseDao.find(id);
	}


	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return baseDao.findAll();
	}

}
