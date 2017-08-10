package cn.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.service.ItemService;

@Controller
public class PageController {

	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/{page}")
	public String toPage(@PathVariable String page){
		return page;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page,Integer rows){
		
		EasyUIDataGridResult list = itemService.getItemList(page, rows);
		System.out.println(list);
		
		return list; 
	}
	
	
	
	
	
}
