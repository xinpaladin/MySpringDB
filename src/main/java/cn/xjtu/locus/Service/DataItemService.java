package cn.xjtu.locus.Service;

import cn.xjtu.locus.Entity.DataItem;
import cn.xjtu.locus.Entity.DataItem.LocusType;
import cn.xjtu.locus.common.Result;

public interface DataItemService extends BaseService<Long, DataItem>{
	
	public DataItem initDataItem(DataItem item,String evalution);
	
	public LocusType getType(String fileName);
	
	public Result insertData(String path);
}
