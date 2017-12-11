package com.aixu.meeting.utils;

import java.util.Date;

/**
 * 冲突信息Vo
 * @author RenBowen
 * @date 2017年12月8日-上午11:38:24
 * @since 1.0.0
 * @aixu-meet
 */
public class ConflictMsg implements java.io.Serializable{
	
	private static final long serialVersionUID = -8037652647653078266L;

	private String timeRange; // 时间段
	
	private String name; // 冲突预定人姓名
	
	public String getTimeRange() {
		return timeRange;
	}
	public void setTimeRange(Date st, Date ed) {
		String stStr = DateUtil.getDateTimeFormat(st);
		String edStr = DateUtil.getDateTimeFormat(ed);
		StringBuilder sb = new StringBuilder();
		// 字符串截取
		sb.append(stStr.substring(0, 16)).append(" ").append("~").append(" ").append(edStr.substring(11,16));
		this.timeRange = sb.toString();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ConflictMsg(String timeRange, String name) {
		this.timeRange = timeRange;
		this.name = name;
	}
	
	public ConflictMsg() {}
	
}
