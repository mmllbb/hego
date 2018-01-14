package cn.mlb.service;

import java.util.List;

import cm.mlb.bean.EUTreeNode;

public interface ItemCatService {

	public List<EUTreeNode> getItemCatList(Long parentId) throws Exception;
	
}
