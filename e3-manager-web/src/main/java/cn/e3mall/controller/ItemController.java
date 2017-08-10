package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.service.ItemCatService;
import cn.e3mall.service.ItemService;

/**
 * 商品管理Controller
 * <p>Title: ItemController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/item/{itemid}")
	@ResponseBody
	public TbItem getItemById(@PathVariable long itemid) {
		TbItem item = itemService.getItemById(itemid);
		return item;
	}
	
	@RequestMapping("/item/save")
	@ResponseBody
	public E3Result addItem(TbItem tbItem,String desc){
		System.out.println(tbItem.toString());
		E3Result result = itemService.addItem(tbItem,desc);
		return result;
	}
	
	@RequestMapping("/item/cid")
	@ResponseBody
	public String addGetItemCid(Long cid){
		TbItemCat itemCat = itemCatService.getItemCat(cid);
		return itemCat.getName();
	}
	
}
