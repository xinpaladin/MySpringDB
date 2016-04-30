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

	@Transactional
	public void add(T entity) {
		baseDao.add(entity);
	}

	@Transactional
	public void delete(T entity) {
		baseDao.delete(entity);
		
	}

	@Transactional
	public void delete(List<T> entities) {
		for(T entity:entities){
			delete(entity);
		}
		
	}

	@Transactional
	public void delete(ID id) {
		baseDao.delete(id);
		
	}

	@Transactional
	public void update(T entity) {
		baseDao.update(entity);
		
	}

	@Transactional(readOnly=true)
	public T find(ID id) {
		return baseDao.find(id);
	}


	@Transactional(readOnly=true)
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return baseDao.findAll();
	}

}
