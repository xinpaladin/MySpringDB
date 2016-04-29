package cn.xjtu.locus.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xjtu.locus.Dao.DataDetailDao;
import cn.xjtu.locus.Dao.DataItemDao;
import cn.xjtu.locus.Entity.DataDetail;
import cn.xjtu.locus.Entity.DataItem;


@Controller
@RequestMapping
public class IndexController {

	@Resource(name="dataItemDaoImpl")
	private DataItemDao itemDao;
	@Resource(name="dataDetailDaoImpl")
	private DataDetailDao detailDao;
	
	@RequestMapping("/index.html")
	public String getIndex(){
		
		return "index";
	}
	
	@RequestMapping("/insertData")
	@ResponseBody
	public boolean insertData(String path){

	//	String path = "D:/表象计算组/from ZX/dataSet/test";
		File file = new File(path);
		File[] fileList = file.listFiles();
		System.out.println("该目录下对象个数：" + fileList.length);
		DataProcessing process = new DataProcessing();

		// 循环读取每个文件
		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isFile()) {
				DataItem item = new DataItem();
				item.setType(process.getType(fileList[i].getName()));
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
					item = process.initDataItem(item, evalution);

					// todo:将item存入数据库
					itemDao.add(item);
					// 删除评价数据
					datas.removeLast();

					// 遍历
					Iterator<String> iter = datas.iterator();
					while (iter.hasNext()) {
						String data = iter.next();
						DataDetail detail = process.initDataDetail(data);
						detail.setDataItemId(item.getId());
						detailDao.add(detail);
					}
				} catch (IOException e) {
					System.out.println("未找到文件");
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}
}
