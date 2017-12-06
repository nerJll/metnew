package com.aixu.meeting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aixu.meeting.dao.AikoRecepempMapper;
import com.aixu.meeting.domain.AikoRecepemp;
import com.aixu.meeting.domain.AikoUser;
import com.aixu.meeting.service.UserService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private AikoRecepempMapper recepempDAO;
	
	@GetMapping("get-all-user")
	@ResponseBody
	public List<AikoUser> listAllUser() {
		List<AikoUser> userList = userService.listUserByMyNo();
		return userList;
	}
	
	@GetMapping("list-user/{id}")
	@ResponseBody
	public List<AikoUser> listUserByDeptId(@PathVariable(name = "id")String deptId) {
		return userService.listUserByDeptId(deptId);
	}
	
	@GetMapping("list-user-like/{word}")
	@ResponseBody
	public List<AikoUser> listUserLikeKeyWord(@PathVariable(name = "word")String keyWord) {
		return userService.listUserLikeKeyWord(keyWord);
	}
	
	/**
	 * @desc 配置前台接收人员
	 * @return
	 */
	@GetMapping("/recepemp")
	public String recepemp(@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage,
			@RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize,
			//@RequestParam(name = "empNoOrName", required = false, defaultValue = "") String empNo,
			Model model) {
		PageInfo<?> recepemps = userService.getAllRecepemps(currentPage,pageSize);
		model.addAttribute("recepemps",recepemps);
		return "common/showRecepEmps";
	}
	
	/**
	 * @desc	新增前台人员
	 * @param aikoRecepemp
	 * @return
	 */
	@PostMapping("/addRecepEmp")
	public String addRecepEmp(AikoRecepemp aikoRecepemp) {
		userService.addRempEmp(aikoRecepemp);
		return "redirect:/user/recepemp";
	}
	
	/**
	 * @desc	删除前台人员
	 * @param empId
	 * @return
	 */
	@PostMapping("/deleteRecepEmp")
	public String deleteRecepEmp(@RequestParam("empId")String empId) {
		try {
			recepempDAO.deleteByPrimaryKey(empId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/user/recepemp"; 
	}
	
	/**
	 * @desc	更新前台人员
	 * @param aikoRecepemp
	 * @return
	 */
	@PostMapping("/modifyRecepEmp")
	public String modifyRecepEmp(AikoRecepemp aikoRecepemp) {
		recepempDAO.updateByPrimaryKeySelective(aikoRecepemp);
		return "redirect:/user/recepemp";
	}
}
