package cn.mlb.service;

import cm.mlb.bean.EUDataGridResult;
import cn.mlb.pojo.TbItem;

public interface ItemService {

	public TbItem geTbItemById(long itemId);
	
	public EUDataGridResult getItemList(Integer page,Integer row);
}
