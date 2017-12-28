package com.aixu.meeting.utils;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aixu.meeting.entity.OAPojo;
import com.aixu.meeting.oa.workflow.WorkflowBaseInfo;
import com.aixu.meeting.oa.workflow.WorkflowMainTableInfo;
import com.aixu.meeting.oa.workflow.WorkflowRequestInfo;
import com.aixu.meeting.oa.workflow.WorkflowRequestTableField;
import com.aixu.meeting.oa.workflow.WorkflowRequestTableRecord;
import com.aixu.meeting.oa.workflow.WorkflowServicePortTypeProxy;

/**
 * @desc
 * @author jianglinle
 * @date 2017年12月8日
 */
public class OAUtils2 {
	// 触发OA
	public static void CFOA(String lch,String wjid) {
		List<Map<String, String>> itemTableMap = null;
		Map<String, String> mainTableMap = null;
		mainTableMap = new HashMap<String, String>();
		mainTableMap.put("apply_user", "1016087");
		itemTableMap = new ArrayList<Map<String, String>>();
		for (int i = 0; i < 7; i++) {
			Map<String, String> map = new HashMap<String, String>();
			itemTableMap.add(map);
		}
		//OA流程
		String workflowId = lch;
		int createId = 1551;
		String result = createWorkFlow(wjid, mainTableMap, itemTableMap, workflowId, createId);
		System.out.print(result);
	}

	public static String createWorkFlow(String wjid, Map<String, String> mainTable,
			List<Map<String, String>> itemTable, String workflowId, int createId) {
		String result = "0";
		WorkflowMainTableInfo workflowMainTableInfo = null;
		WorkflowRequestInfo requestInfo = new WorkflowRequestInfo();
		WorkflowBaseInfo workflowBaseInfo = new WorkflowBaseInfo();
		workflowBaseInfo.setWorkflowId(workflowId);// 流程对应的id

		requestInfo.setCanEdit(true);
		requestInfo.setCanView(true);
		requestInfo.setWorkflowBaseInfo(workflowBaseInfo);

		try {
			if (mainTable != null && !mainTable.isEmpty()) {
				// 主表单信息
				// 主表字段信息
				// WorkflowRequestTableField[] wtfs = new
				// WorkflowRequestTableField[mainTable.size()];//mainTable.size()
				WorkflowRequestTableField[] wrti = new WorkflowRequestTableField[30];
				wrti[0] = new WorkflowRequestTableField();
				wrti[0].setFieldName("spr");// 申请人
				wrti[0].setFieldValue("1551");// 1551--陈明霞 1552-任博文 1548--姜林乐
				wrti[0].setView(true);
				wrti[0].setEdit(true);

				requestInfo.setRequestName("QS04-客诉申请单");

				// 只有一个主表单
				WorkflowRequestTableRecord[] wrtri = new WorkflowRequestTableRecord[1];

				wrtri[0] = new WorkflowRequestTableRecord();
				wrtri[0].setWorkflowRequestTableFields(wrti);

				workflowMainTableInfo = new WorkflowMainTableInfo();
				workflowMainTableInfo.setRequestRecords(wrtri);

				requestInfo.setWorkflowMainTableInfo(workflowMainTableInfo);// 主表单信息
			}

			if (workflowMainTableInfo != null) {

				String addrss = "http://192.168.0.35//services/WorkflowService";
				WorkflowServicePortTypeProxy client = new WorkflowServicePortTypeProxy(addrss);

				requestInfo.setCreatorId(createId + "");
				result = client.doCreateWorkflowRequest(requestInfo, Integer.valueOf(createId));

				// log.info(result);
				System.out.println(result);
			}

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
