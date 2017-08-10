package cn.e3mall.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
		TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
		return tbItem;
	}

	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		
		PageHelper.startPage(page, rows);
		
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		
		
		return result;
	}

	@Override
	public E3Result addItem(TbItem tbItem, String desc) {
		long l = System.currentTimeMillis();
		tbItem.setId(l);
		tbItem.setCreated(new Date());
		tbItem.setUpdated(new Date());
		tbItem.setStatus((byte) 1);
		itemMapper.insert(tbItem);
		
		TbItemDesc tbItemDesc = new TbItemDesc();
		tbItemDesc.setItemId(l);
		tbItemDesc.setItemDesc(desc);
		tbItemDesc.setCreated(new Date());
		tbItemDesc.setUpdated(new Date());
		
		return E3Result.ok();
	}
	
	

}
