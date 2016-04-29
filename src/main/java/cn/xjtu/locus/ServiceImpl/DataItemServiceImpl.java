package cn.xjtu.locus.ServiceImpl;

import org.springframework.stereotype.Service;

import cn.xjtu.locus.Entity.DataItem;
import cn.xjtu.locus.Entity.DataItem.LocusType;
import cn.xjtu.locus.Service.DataItemService;

@Service
public class DataItemServiceImpl implements DataItemService {

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
