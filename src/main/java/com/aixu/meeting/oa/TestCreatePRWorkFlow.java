package com.aixu.meeting.oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCreatePRWorkFlow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Map<String,String>> itemTableMap = null;
		Map<String,String> mainTableMap =null;
		mainTableMap =new HashMap<String, String>();
    	mainTableMap.put("gangwei", "1016079gangwei");
    	itemTableMap=new ArrayList<Map<String,String>>();
    	for(int i=0;i<2;i++){
    		Map<String,String> map = new HashMap<String, String>();
    		map.put("goname", "09");
    		map.put("gocode", "09");
    		map.put("godepartment", "09");
    		map.put("gopost", "09");
    		map.put("reasion", "09");
    		map.put("bubandate", "09");
    		itemTableMap.add(map);
    	}
    	String workflowId ="454";
    	int createId=1551;
		String result = new CreatePRWorkFlow().createWorkFlow(mainTableMap, itemTableMap,workflowId,createId);
		System.out.print(result);
	}

}
