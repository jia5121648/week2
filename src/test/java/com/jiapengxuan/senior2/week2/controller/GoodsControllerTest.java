package com.jiapengxuan.senior2.week2.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiapengxuan.common.utils.StreamUtil;
import com.jiapengxuan.common.utils.StringUtil;
import com.jiapengxuan.senior2.week2.domain.Goods;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class GoodsControllerTest {
	@Autowired
	RedisTemplate redisTemplate;
	
	@Test
	public void test01() {
		File file = new File("src/test/resources/init.txt");
		ArrayList<Goods> list = new ArrayList<>();
		try {
			InputStream is = new FileInputStream(file);
			List<String> readTextForLine = StreamUtil.readTextForLine(is);
			
			for (String string : readTextForLine) {
				Goods g = new Goods();
				String[] split = string.split("==");
				if(StringUtil.isNumber(split[0])) {							
					g.setId(split[0]);
				}
				if(StringUtil.hasText(split[1])) {
					g.setName(split[1]);
				}
				if(StringUtil.hasText(split[2])) {
					BigDecimal substring = BigDecimal.valueOf(Double.parseDouble(split[2].substring(1)));
					if(StringUtil.isNumber(split[2].substring(1))){
						g.setPrice(substring);
					}	
				}
				if(StringUtil.hasText(split[3])) {
					if(StringUtil.isNumber(split[3].substring(0,split[3].length()-1))){
						g.setBaifen(split[3].substring(0,split[3].length()-1));
					}
				}
				
				list.add(g);				
			}		
			System.out.println(list.size());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		redisTemplate.opsForList().leftPush("goods_list", list);	
	}
	
	@Test
	public void test02() {
		File file = new File("src/test/resources/init.txt");
		HashSet<Goods> set = new HashSet<Goods>();
		try {
			InputStream is = new FileInputStream(file);
			List<String> readTextForLine = StreamUtil.readTextForLine(is);
			
			for (String string : readTextForLine) {
				Goods g = new Goods();
				String[] split = string.split("==");
				if(StringUtil.isNumber(split[0])) {							
					g.setId(split[0]);
				}
				if(StringUtil.hasText(split[1])) {
					g.setName(split[1]);
				}
				if(StringUtil.hasText(split[2])) {
					BigDecimal substring = BigDecimal.valueOf(Double.parseDouble(split[2].substring(1)));
					if(StringUtil.isNumber(split[2].substring(1))){
						g.setPrice(substring);
					}	
				}
				if(StringUtil.hasText(split[3])) {
					if(StringUtil.isNumber(split[3].substring(0,split[3].length()-1))){
						g.setBaifen(split[3].substring(0,split[3].length()-1));
					}
				}
				
				set.add(g);				
			}		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		redisTemplate.opsForZSet().add("goods_zset", set, 1);
	}
	

}
