package cn.xjtu.locus.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xjtu.locus.Dao.DataDetailDao;
import cn.xjtu.locus.Dao.DataItemDao;
import cn.xjtu.locus.Entity.DataDetail;
import cn.xjtu.locus.Entity.DataItem;
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
