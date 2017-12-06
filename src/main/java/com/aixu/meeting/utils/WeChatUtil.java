package com.aixu.meeting.utils;

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
}
