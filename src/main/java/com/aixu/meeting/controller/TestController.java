package com.aixu.meeting.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aiko.common.util.SystemApi;
import com.aixu.meeting.dao.AixuAudioinfoMapper;
import com.aixu.meeting.dao.AixuMeetandroomMapper;
import com.aixu.meeting.dao.AixuMeetingMapper;
import com.aixu.meeting.dao.AixuMeetingroomMapper;
import com.aixu.meeting.domain.AixuMeetandroom;
import com.aixu.meeting.domain.AixuMeetandroomExample;
import com.aixu.meeting.domain.AixuMeeting;
import com.aixu.meeting.domain.AixuMeetingExample;
import com.aixu.meeting.entity.OAPojo;
import com.aixu.meeting.service.MeetAndRoomService;
import com.aixu.meeting.service.MeetService;
import com.aixu.meeting.service.RoomService;
import com.aixu.meeting.service.UserService;
import com.aixu.meeting.utils.AjaxObject;
import com.aixu.meeting.utils.OAUtils;
import com.aixu.meeting.utils.OAUtils2;
import com.aixu.meeting.utils.WeChatUtil;

import net.sf.json.JSONObject;

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
	private MeetService meetService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private MeetAndRoomService meetAndRoomService;
	@Autowired
	private AixuAudioinfoMapper aaiMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private AixuMeetingMapper meetDAO;
	@Autowired
	private AixuMeetingroomMapper roomDAO;
	@Autowired
	private AixuMeetandroomMapper mAndrDAO;
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
			OAUtils.CFOA("718",new OAPojo());
			return "成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "失败";
		}
	}
	
	@RequestMapping("/shanchuhy/{name}")
	@ResponseBody
	public String shanchu(@PathVariable("name")String applyName) {
		AixuMeetingExample exp = new AixuMeetingExample();
		exp.createCriteria().andResFourEqualTo(applyName);
		List<AixuMeeting> meets = meetDAO.selectByExample(exp);
		List<AixuMeetandroom> amds = new ArrayList<>();
		for (AixuMeeting meet : meets) {
			List<AixuMeetandroom> amds1 = meetAndRoomService.getMeetRoomByMeetId(meet.getMeetId());
			for (AixuMeetandroom amd : amds1) {
				amds.add(amd);
			}
		}
		for (AixuMeetandroom amd : amds) {
			AixuMeetandroomExample exp1 = new AixuMeetandroomExample();
			exp1.createCriteria().andMeetIdEqualTo(amd.getMeetId());
			mAndrDAO.deleteByExample(exp1);
		}
		for (AixuMeeting meet : meets) {
			AixuMeetingExample exp2 = new AixuMeetingExample();
			exp2.createCriteria().andMeetIdEqualTo(meet.getMeetId());
			meetDAO.deleteByExample(exp2);
		}
		return meets.size() + "--" + amds.size();
	}
	
	@RequestMapping("/cufaoa1")
	@ResponseBody
	public String cufaOA2() {
		try {
			OAUtils2.CFOA("722","1016087");
			return "成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "失败";
		}
	}
	
	@RequestMapping(value = "/getSavePathTest")
	public void getSavePath(HttpServletRequest request,@RequestParam(name="requestid", required = false) String requestId,HttpServletResponse response) throws Exception {	
		try {
			System.out.println("============"+requestId);
	        response.setContentType("text/plain");  
	        response.setHeader("Pragma", "No-cache");  
	        response.setHeader("Cache-Control", "no-cache");  
	        response.setDateHeader("Expires", 0);  
	        Map<String,String> map = new HashMap<String,String>();   
	        map.put("result", "success");  
	        map.put("requestId", "返回id:"+requestId);  
	        PrintWriter out = response.getWriter();       
	        JSONObject resultJSON = JSONObject.fromObject(map); //根据需要拼装json  
	        String jsonpCallback = request.getParameter("jsonpCallback");//客户端请求参数  
	        out.println(jsonpCallback+"("+resultJSON.toString(1,1)+")");//返回jsonp格式数据  
	        out.flush();  
	        out.close();  
	      } catch (IOException e) {  
	       e.printStackTrace();  
	      }  
	}
}
 