package cn.mlb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mlb.pojo.TbItem;
import cn.mlb.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/{itemId}")
	@ResponseBody
	public TbItem geTbItemById(@PathVariable long itemId) {
		TbItem tbItem = itemService.geTbItemById(itemId);
		return tbItem;
	}
	
	
}
