package cn.mlb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.mlb.bean.EUTreeNode;
import cn.mlb.mapper.TbItemCatMapper;
import cn.mlb.pojo.TbItemCat;
import cn.mlb.pojo.TbItemCatExample;
import cn.mlb.pojo.TbItemCatExample.Criteria;
import cn.mlb.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper catMapper;
	
	@Override
	public List<EUTreeNode> getItemCatList(Long parentId) throws Exception {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		
		List<TbItemCat> list = catMapper.selectByExample(example);
		
		List<EUTreeNode> resultList = new ArrayList<>();
		for (TbItemCat tbItemCat : list) {
			EUTreeNode node = new EUTreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		
		return resultList;
	}

}
