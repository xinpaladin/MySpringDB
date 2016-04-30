package cn.xjtu.locus.ServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xjtu.locus.Dao.DataDetailDao;
import cn.xjtu.locus.Dao.DataItemDao;
import cn.xjtu.locus.Entity.DataDetail;
import cn.xjtu.locus.Entity.DataItem;
import cn.xjtu.locus.Entity.DataItem.LocusType;
import cn.xjtu.locus.Service.DataDetailService;
import cn.xjtu.locus.Service.DataItemService;
import cn.xjtu.locus.common.Result;

@Service
public class DataItemServiceImpl extends BaseServiceImpl<Long, DataItem>implements DataItemService {

	
	
	@Autowired
	private DataDetailDao detailDao;

	@Autowired
	private DataDetailService dataDetailService;
	
	@Autowired
	private DataItemDao itemDao;
	
	@Autowired
	public void setBaseDao(DataItemDao dataItemDao){
		super.setBaseDao(dataItemDao);
	}
	
	
	@Transactional
	public Result insertData(String path){

		File file = new File(path);
		File[] fileList = file.listFiles();
		System.out.println("该目录下对象个数：" + fileList.length);
		
		// 循环读取每个文件
		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isFile()) {
				DataItem item = new DataItem();
				item.setType(getType(fileList[i].getName()));
				item.setFileName(fileList[i].getName());
				BufferedReader br = null;
				try {
					LinkedList<String> datas = new LinkedList<String>();
					br = new BufferedReader(new FileReader(fileList[0]));
					String line = "";
					while ((line = br.readLine()) != null) {
						datas.add(line);
					}
					// 轨迹数据评价
					String evalution = datas.getLast();
					item = initDataItem(item, evalution);

					// todo:将item存入数据库
					itemDao.add(item);
					// 删除评价数据
					datas.removeLast();

					// 遍历
					Iterator<String> iter = datas.iterator();
					while (iter.hasNext()) {
						String data = iter.next();
						DataDetail detail = dataDetailService.initDataDetail(data);
						detail.setDataItemId(item.getId());
						detailDao.add(detail);
					}
				} catch (IOException e) {
					System.out.println("未找到文件");
					e.printStackTrace();
					return new Result(false, "未找到文件");
				}
			}
		}
		return new Result(true, "");
	}
	
	@Override
	public DataItem initDataItem(DataItem item, String evalution) {
		String[] evals = evalution.split(" ");
		// IsAvailable<<" "<<Speed <<" "<<Locus <<" "<<Comfort<<" "<<Total;
		if(evals[0].equals("0")){
			item.setAvailable(true);// evals[0]
		}else{
			item.setAvailable(false);
		}
		item.setSpeed(evals[1]);
		item.setLocus(evals[2]);
		item.setComfortable(evals[3]);
		item.setOverallEval(evals[4]);
		return item;
	}

	// 判断文件的轨迹类型
	public LocusType getType(String fileName) {

		if (fileName.contains("直行")) {
			return LocusType.Straight;
		} else if (fileName.contains("左换道")) {
			return LocusType.LeftLaneChange;
		} else if (fileName.contains("右换道")) {
			return LocusType.RightLaneChange;
		} else if (fileName.contains("左转")) {
			return LocusType.TurnLeft;
		} else if (fileName.contains("右转")) {
			return LocusType.TurnRight;
		} else if (fileName.contains("左掉头")) {
			return LocusType.TurnAround;
		}
		return null;
	}

}
