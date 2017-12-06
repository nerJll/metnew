package com.aixu.meeting.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aixu.meeting.utils.DateUtil;

@ControllerAdvice
@Controller
@RequestMapping("/common")
public class CommonController {
	
	/**
	 * @desc  全局异常处理
	 * @param req
	 * @param model
	 * @return
	 */
	@ExceptionHandler(value=Exception.class)  
	public String fail(HttpServletRequest req,
			HttpServletResponse res,
			Model model,
			Exception e) {
		int errorState = res.getStatus();
		String errorUrl = req.getServletPath();
		String errorTime = DateUtil.getDateFormat(new Date(),"yyyy-MM-dd HH:mm");
		model.addAttribute("errorState",errorState);
		model.addAttribute("errorUrl",errorUrl);
		model.addAttribute("errorTime",errorTime);
		e.printStackTrace();
		return "common/fail";
	}
	
	@RequestMapping("/render")
	public String render() {
		return "common/render";
	}
	
	@RequestMapping("/tiaoz")
	public String tiaoZ() {
		return "common/tiaoz";
	}
}
