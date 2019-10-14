package com.jiapengxuan.senior2.week2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GoodsController {
	@Autowired
	RedisTemplate redisTemplate;
	
	@GetMapping("getGoodsList")
	public String getGoodsList(Model m,@RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "10")Integer pageSize
			) {
//		List<Goods> list = redisTemplate.opsForList().range("goods_list", 0, -1);
//		for (Goods goods : list) {
//			System.out.println(goods);
//		}
//		m.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping("lsit")
	public String lsit(Model m,@RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "10")Integer pageSize
			) {
		
		return "list";
	}
}
