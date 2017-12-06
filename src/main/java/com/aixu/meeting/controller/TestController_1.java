package com.aixu.meeting.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aiko.common.util.SystemApi;
import com.aixu.meeting.domain.AikoUser;
import com.aixu.meeting.service.RoomService;
import com.aixu.meeting.service.UserService;

@Controller
public class TestController_1 {
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("mobile")
	public String toMobile(Model model) {
		return "mobile/index5";
	}
	
	@RequestMapping("to-order")
	public String toOrder(Model model) {
		// 总经办
		List<AikoUser> zzb = userService.listUserByDeptId("150");
		model.addAttribute("zzbs", zzb);
		// 流程与IT部
		List<AikoUser> it = userService.listUserByDeptId("151");
		model.addAttribute("its", it);
		// 人力资源与行政部
		List<AikoUser> rlzy = userService.listUserByDeptId("153");
		model.addAttribute("rlzys", rlzy);
		// 采购
		List<AikoUser> cg = userService.listUserByDeptId("158");
		model.addAttribute("cgs", cg);
		// 财务
		List<AikoUser> cw = userService.listUserByDeptId("152");
		model.addAttribute("cws", cw);
		// 销售
		List<AikoUser> allXs = new ArrayList<>();
		List<AikoUser> xs1 = userService.listUserByDeptId("155");
		List<AikoUser> xs2 = userService.listUserByDeptId("156");
		List<AikoUser> xs3 = userService.listUserByDeptId("157");
		allXs.addAll(xs1);
		allXs.addAll(xs2);
		allXs.addAll(xs3);
		model.addAttribute("xs", allXs);
		// 研发部
		List<AikoUser> yf = userService.listUserByDeptId("159");
		model.addAttribute("yfs", yf);
		// 设备
		List<AikoUser> sb = userService.listUserByDeptId("164");
		model.addAttribute("sbs", sb);
		// 工艺
		List<AikoUser> gy = userService.listUserByDeptId("166");
		model.addAttribute("gys", gy);
		// 动力部
		List<AikoUser> dl = userService.listUserByDeptId("165");
		model.addAttribute("dls", dl);
		// 品质
		List<AikoUser> pz = userService.listUserByDeptId("169");
		model.addAttribute("zps", pz);
		// 计划控制
		List<AikoUser> jh1 = userService.listUserByDeptId("171");
		model.addAttribute("jhs", jh1);
		// 生管办
		List<AikoUser> sgbs = userService.listUserByDeptId("170");
		model.addAttribute("sgbs", sgbs);
		return "meet/order-meet_1";
	}
}
