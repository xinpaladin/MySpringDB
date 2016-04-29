package cn.xjtu.locus.DaoImpl;

import org.springframework.stereotype.Repository;

import cn.xjtu.locus.Dao.DataItemDao;
import cn.xjtu.locus.Entity.DataItem;


@Repository("dataItemDaoImpl")
public class DataItemDaoImpl extends BaseDaoImpl<Long, DataItem> implements DataItemDao{

}
