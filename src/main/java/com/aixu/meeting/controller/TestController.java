package com.aixu.meeting.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aiko.common.util.SystemApi;
import com.aixu.meeting.entity.OAPojo;
import com.aixu.meeting.utils.AjaxObject;
import com.aixu.meeting.utils.OAUtils;
import com.aixu.meeting.utils.WeChatUtil;

/** 
* @author Jianglinle
* @date 2017年10月25日 下午2:55:21 
* @version 1.0.0
* @aiko-
*/
@Controller
@RequestMapping("/test")
public class TestController {
	private final static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate; //数据可显

	/*@Autowired
	private RedisTemplate redisTemplate;//数据不可显
*/	
	@GetMapping("/test1")
	public String test1(){
		return "test/test1";
	}
	
	@GetMapping("/test2")
	public String test2(){
		return "test/test2";
	}
	
	@GetMapping("/test3")
	@ResponseBody
	public String test3(){
		try{
			stringRedisTemplate.opsForValue().set("name", "jianglinle");
			return "成功";
		}catch(Exception e){
			e.printStackTrace();
			return "失败";
		}
		//Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}

	@GetMapping("/test4")
	@ResponseBody
	public Object test4(){
		Object obj = stringRedisTemplate.opsForValue().get("name");
		return obj;
		//Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}
	
	@RequestMapping(value = "/system/test")
	@ResponseBody
	public AjaxObject sendText(){	
		AjaxObject returnVal = new AjaxObject();
		try {
			WeChatUtil.weChatPush("1016087", "nihao\nhhh");
			returnVal.success("成功", null);
		} catch (Throwable e) {
			returnVal.fail(e.getMessage());
		}
		return returnVal;
	}

	@GetMapping("/test5")
	public String test5() {
		return "meet/testIndex2";
	}
	
	@GetMapping("/test6")
	@ResponseBody
	public String test6() {
		Map<?,?> map = SystemApi.getCurrentUser();
		for (Map.Entry<?, ?> entry : map.entrySet()) {
			logger.info("键值对={}",entry.getKey()+"::"+entry.getValue());
		}
		return "成功";
	}
	
	@RequestMapping("/cufaoa")
	@ResponseBody
	public String cufaOA1() {
		try {
			OAUtils.CFOA(new OAPojo());
			return "成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "失败";
		}
	}
}
 