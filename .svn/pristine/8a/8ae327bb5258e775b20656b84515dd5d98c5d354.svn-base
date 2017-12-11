package com.aixu.meeting.oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCreateSD06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//主表
		Map<String,String> mainTableMap =null;
		mainTableMap =new HashMap<String, String>();
    	mainTableMap.put("CONTRACT_NO", "111111");
    	mainTableMap.put("CONTRACT_TYPE", "11222");
    	//明细表
    	List<Map<String,String>> itemTableMap = null;
    	itemTableMap=new ArrayList<Map<String,String>>();
    	/*for(int i=0;i<2;i++){
    		Map<String,String> map = new HashMap<String, String>();
    		map.put("SILICON", "09");
    		map.put("MAIN_GRID", "09");
    		map.put("TECH", "09");
    		itemTableMap.add(map);
    	}*/
    	String workflowId ="638";
    	int createId=1551;
		String result = new CreateSD06().createWorkFlow(mainTableMap, itemTableMap,workflowId, 1551);
		System.out.print(result);
	}

}
