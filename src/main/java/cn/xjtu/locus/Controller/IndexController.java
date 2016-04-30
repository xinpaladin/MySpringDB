package cn.xjtu.locus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xjtu.locus.Service.DataDetailService;
import cn.xjtu.locus.Service.DataItemService;
import cn.xjtu.locus.common.Result;


@Controller
@RequestMapping
public class IndexController {

	
	@Autowired
	private DataItemService dataItemService;
	
	@Autowired
	private DataDetailService dataDetailService;
	
	@RequestMapping("/index.html")
	public String getIndex(){
		
		return "index";
	}
	
	@RequestMapping("/insertData")
	@ResponseBody
	public Result insertData(String path){
		return dataItemService.insertData(path);
	}
}
