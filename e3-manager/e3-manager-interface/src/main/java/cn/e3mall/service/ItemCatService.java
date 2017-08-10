package cn.e3mall.service;

import java.util.List;

import cn.e3mall.common.pojo.TreeNode;
import cn.e3mall.pojo.TbItemCat;

public interface ItemCatService {

	List<TreeNode> getCat(long parentId);

	TbItemCat getItemCat(long cid);
}
