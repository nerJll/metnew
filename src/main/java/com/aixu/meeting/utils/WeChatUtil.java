package com.aixu.meeting.utils;

import java.util.List;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.aiko.config.wxcp.WxcpApi;
import com.google.gson.Gson;

import me.chanjar.weixin.cp.bean.WxCpMessage;

/**
 * @author RenBowen
 * @date 2017年11月6日-上午10:03:36
 * @since 1.0.0
 */
public class WeChatUtil {
	/**
	 * 企业号常量
	 */
	private static final Integer cId = 66;  
	/**
	 * 微信推送TEXT
	 * @param uId
	 */
	public static String weChatPush(String uId, String content) {
		WxCpMessage msg=new WxCpMessage();
		Gson gson = new Gson();
		MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
		//推送TEXT
		msg.setAgentId(cId);//企业应用id
		msg.setContent(content);
		msg.setToUser(uId);//1013608|1014906|1014709
		requestEntity.add("requestJson", gson.toJson(msg));
		//跳转url,可不传,url中会默认一个参数userid,值为微信接收人的工号
		//requestEntity.add("redirectUri","http://portal.aikosolar.com/?test=2");
		String result = WxcpApi.send(WxcpApi.TEXT,requestEntity);
		return result;
	}
	
	/**
	 * 批处理微信推送
	 * @param id 预定人工号
	 * @param msgList 冲突集合
	 * @return
	 */
	public static String weChatPushBatch(String id, List<ConflictMsg> msgList) {
		WxCpMessage msg=new WxCpMessage();
		Gson gson = new Gson();
		MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
		//推送TEXT
		msg.setAgentId(cId);//企业应用id
		StringBuilder sb = new StringBuilder();
		sb.append("状态信息：").append("\n");
		// 处理占用信息
		if (msgList.size() > 0) {
			for (ConflictMsg conflictMsg : msgList) {
				sb.append(conflictMsg.getTimeRange()).append(" ").append(conflictMsg.getName()).append("\n");
			}
			sb.append("以上时间段被他人提前预定，请与上述人员自行协商");
		} else {
			sb.append("会议室长期预定申请成功！");
		}
		// 推送微信
		msg.setContent(sb.toString());
		msg.setToUser(id);//1013608|1014906|1014709
		requestEntity.add("requestJson", gson.toJson(msg));
		String result = WxcpApi.send(WxcpApi.TEXT,requestEntity);
		return result;
	}
}
