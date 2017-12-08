package com.aixu.meeting.utils;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class OAUtils {
	// 框架协议
	public static void CFOA(String applyNo) {
		List<Map<String, String>> itemTableMap = null;
		Map<String, String> mainTableMap = null;
		mainTableMap = new HashMap<String, String>();
		mainTableMap.put("apply_user", "1016087");
		itemTableMap = new ArrayList<Map<String, String>>();
		for (int i = 0; i < 7; i++) {
			Map<String, String> map = new HashMap<String, String>();
			itemTableMap.add(map);
		}
		String workflowId = "718";
		int createId = 1551;
		String result = createWorkFlow(applyNo, mainTableMap, itemTableMap, workflowId, createId);
		System.out.print(result);
	}

	public static String createWorkFlow(String contract, Map<String, String> mainTable,
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
				wrti[0].setFieldValue("1552");// 1551--陈明霞 1552-任博文 1548--姜林乐
				wrti[0].setView(true);
				wrti[0].setEdit(true);

				wrti[1] = new WorkflowRequestTableField();
				wrti[1].setFieldName("depNames");// 部门名称
				wrti[1].setFieldValue("人力资源及行政部");
				wrti[1].setView(true);
				wrti[1].setEdit(true);

				wrti[2] = new WorkflowRequestTableField();
				wrti[2].setFieldName("empPos");// 理由
				wrti[2].setFieldValue("看电影");
				wrti[2].setView(true);
				wrti[2].setEdit(true);

				wrti[3] = new WorkflowRequestTableField();
				wrti[3].setFieldName("position");// 职位
				wrti[3].setFieldValue("管培生");//
				wrti[3].setView(true);// 字段是否可见
				wrti[3].setEdit(true);// 字段是否可编辑

				wrti[4] = new WorkflowRequestTableField();
				wrti[4].setFieldName("company");// 所属公司
				wrti[4].setFieldValue("浙江爱旭");
				wrti[4].setView(true);
				wrti[4].setEdit(true);
				
				wrti[5] = new WorkflowRequestTableField();
				wrti[5].setFieldName("empPhNo");// 手机号
				wrti[5].setFieldValue("18270884103");
				wrti[5].setView(true);
				wrti[5].setEdit(true);

				wrti[6] = new WorkflowRequestTableField();
				wrti[6].setFieldName("staTime");// 开始时间
				wrti[6].setFieldValue("2017-12-01 09:00:00");
				wrti[6].setView(true);
				wrti[6].setEdit(true);
				
				wrti[7] = new WorkflowRequestTableField();
				wrti[7].setFieldName("endTime");// 结束时间
				wrti[7].setFieldValue("2017-12-01 10:00:00");
				wrti[7].setView(true);
				wrti[7].setEdit(true);
				
				wrti[8] = new WorkflowRequestTableField();
				wrti[8].setFieldName("loopCycle");// 持续周期
				wrti[8].setFieldValue("每天一次，持续10天");
				wrti[8].setView(true);
				wrti[8].setEdit(true);
				
				wrti[9] = new WorkflowRequestTableField();
				wrti[9].setFieldName("reason");// 理由
				wrti[9].setFieldValue("看电影");
				wrti[9].setView(true);
				wrti[9].setEdit(true);
				
				wrti[10] = new WorkflowRequestTableField();
				wrti[10].setFieldName("meetTheme");// 主题
				wrti[10].setFieldValue("3D的");
				wrti[10].setView(true);
				wrti[10].setEdit(true);
				
				wrti[11] = new WorkflowRequestTableField();
				wrti[11].setFieldName("resFive");// 议程
				wrti[11].setFieldValue("1.吃饭\n2.睡觉\n3.打豆豆");
				wrti[11].setView(true);
				wrti[11].setEdit(true);
				
				wrti[12] = new WorkflowRequestTableField();
				wrti[12].setFieldName("roomName");// 会议室
				wrti[12].setFieldValue("广东爱旭1期2楼会议室1");
				wrti[12].setView(true);
				wrti[12].setEdit(true);
				
				wrti[13] = new WorkflowRequestTableField();
				wrti[13].setFieldName("applyName");// 姓名
				wrti[13].setFieldValue("姜林乐");
				wrti[13].setView(true);
				wrti[13].setEdit(true);
				
				wrti[14] = new WorkflowRequestTableField();
				wrti[14].setFieldName("applyNo");// 议程
				wrti[14].setFieldValue("1016087");
				wrti[14].setView(true);
				wrti[14].setEdit(true);
				
				requestInfo.setRequestName("会议室长期试用申请");

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
