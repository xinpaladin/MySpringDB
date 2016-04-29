package cn.xjtu.locus.Service;

import cn.xjtu.locus.Entity.DataItem;
import cn.xjtu.locus.Entity.DataItem.LocusType;

public interface DataItemService {
	
	public DataItem initDataItem(DataItem item,String evalution);
	
	public LocusType getType(String fileName);
}
