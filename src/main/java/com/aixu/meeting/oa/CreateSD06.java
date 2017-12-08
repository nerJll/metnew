package com.aixu.meeting.oa;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.aixu.meeting.oa.workflow.WorkflowBaseInfo;
import com.aixu.meeting.oa.workflow.WorkflowDetailTableInfo;
import com.aixu.meeting.oa.workflow.WorkflowMainTableInfo;
import com.aixu.meeting.oa.workflow.WorkflowRequestInfo;
import com.aixu.meeting.oa.workflow.WorkflowRequestTableField;
import com.aixu.meeting.oa.workflow.WorkflowRequestTableRecord;
import com.aixu.meeting.oa.workflow.WorkflowServicePortTypeProxy;

/**
 *@mainTable 主表信息
 *@itemTable 明细表
 *@workflowId 流程ID
 *@createId OA数据库表hrmResource对应的人员ID
 *@return result 
 */
public class CreateSD06 {
	public final Logger log = Logger.getLogger(CreatePRWorkFlow.class); 
	public String createWorkFlow(Map<String,String> mainTable,List<Map<String,String>> itemTable,String workflowId,int createId){
		String result="0";
		WorkflowMainTableInfo workflowMainTableInfo=null;
		WorkflowRequestInfo requestInfo = new WorkflowRequestInfo();
		WorkflowBaseInfo workflowBaseInfo = new WorkflowBaseInfo();
		workflowBaseInfo.setWorkflowId(workflowId);//流程对应的id
		
		requestInfo.setCanEdit(true);
		requestInfo.setCanView(true);
		requestInfo.setWorkflowBaseInfo(workflowBaseInfo);
		
		try {
			if(mainTable!=null && !mainTable.isEmpty()){
			
				
				WorkflowRequestTableField[] wrti = new WorkflowRequestTableField[30]; // 字段信息
				wrti[0] = new WorkflowRequestTableField();
				wrti[0].setFieldName("CONTRACT_NO");// 合同编号
				wrti[0].setFieldValue("111");// 被留言人字段的值，111为被留言人id
				wrti[0].setView(true);// 字段是否可见
				wrti[0].setEdit(true);// 字段是否可编辑

				wrti[1] = new WorkflowRequestTableField();
				wrti[1].setFieldName("CONTRACT_TYPE");// 合同类型
				wrti[1].setFieldValue("test");
				wrti[1].setView(true);
				wrti[1].setEdit(true);

				wrti[2] = new WorkflowRequestTableField();
				wrti[2].setFieldName("SERVICE_MODEL");// 业务模式
				wrti[2].setFieldValue("test");
				wrti[2].setView(true);
				wrti[2].setEdit(true);

				wrti[3] = new WorkflowRequestTableField();
				wrti[3].setFieldName("ISFORMATE");// 是否格式合同
				wrti[3].setFieldValue("是");//
				wrti[3].setView(true);// 字段是否可见
				wrti[3].setEdit(true);// 字段是否可编辑

				wrti[4] = new WorkflowRequestTableField();
				wrti[4].setFieldName("SALE_ORG");// 销售组织
				wrti[4].setFieldValue("111");
				wrti[4].setView(true);
				wrti[4].setEdit(true);

				wrti[5] = new WorkflowRequestTableField();
				wrti[5].setFieldName("SALE_WAY");// 分销渠道
				wrti[5].setFieldValue("test");
				wrti[5].setView(true);
				wrti[5].setEdit(true);

				wrti[6] = new WorkflowRequestTableField();
				wrti[6].setFieldName("PAYMENT_WAY");// 付款方式
				wrti[6].setFieldValue("PAYMENT_WAY");// 被留言人字段的值，111为被留言人id
				wrti[6].setView(true);// 字段是否可见
				wrti[6].setEdit(true);// 字段是否可编辑

				wrti[7] = new WorkflowRequestTableField();
				wrti[7].setFieldName("SALE_GROUP");// 销售组
				wrti[7].setFieldValue("444");
				wrti[7].setView(true);
				wrti[7].setEdit(true);

				wrti[8] = new WorkflowRequestTableField();
				wrti[8].setFieldName("TRADE_TERM");//贸易条款
				wrti[8].setFieldValue("贸易条款");
				wrti[8].setView(true);
				wrti[8].setEdit(true);

				wrti[9] = new WorkflowRequestTableField();
				wrti[9].setFieldName("CUSTOMER_NO");//
				wrti[9].setFieldValue("111");// 被留言人字段的值，111为被留言人id
				wrti[9].setView(true);// 字段是否可见
				wrti[9].setEdit(true);// 字段是否可编辑

				wrti[10] = new WorkflowRequestTableField();
				wrti[10].setFieldName("Customer_identify");// 客户标识
				wrti[10].setFieldValue("客户标识 Customer_identify");
				wrti[10].setView(true);
				wrti[10].setEdit(true);

				wrti[11] = new WorkflowRequestTableField();
				wrti[11].setFieldName("PURCHASE_NO");// 客户采购编号  
				wrti[11].setFieldValue("1111");
				wrti[11].setView(true);
				wrti[11].setEdit(true);

				wrti[12] = new WorkflowRequestTableField();
				wrti[12].setFieldName("STA_TIME");//
				wrti[12].setFieldValue("2017-08-09");// 被留言人字段的值，111为被留言人id
				wrti[12].setView(true);// 字段是否可见
				wrti[12].setEdit(true);// 字段是否可编辑

				wrti[13] = new WorkflowRequestTableField();
				wrti[13].setFieldName("END_TIME");//
				wrti[13].setFieldValue("2017-08-12");
				wrti[13].setView(true);
				wrti[13].setEdit(true);

				wrti[14] = new WorkflowRequestTableField();
				wrti[14].setFieldName("PAYMENT_TERM");// 付款条件
				wrti[14].setFieldValue("付款条件");
				wrti[14].setView(true);
				wrti[14].setEdit(true);

				wrti[15] = new WorkflowRequestTableField();
				wrti[15].setFieldName("CURRENCY");// 
				wrti[15].setFieldValue("货币类型");// 货币类型
				wrti[15].setView(true);// 字段是否可见
				wrti[15].setEdit(true);// 字段是否可编辑

				wrti[16] = new WorkflowRequestTableField();
				wrti[16].setFieldName("Wafercost");// 硅片成本
				wrti[16].setFieldValue("44.87");
				wrti[16].setView(true);
				wrti[16].setEdit(true);
				
				wrti[17] = new WorkflowRequestTableField();
				wrti[17].setFieldName("NonsiliconCost");// 非硅成本
				wrti[17].setFieldValue("44.87");
				wrti[17].setView(true);
				wrti[17].setEdit(true);

				wrti[18] = new WorkflowRequestTableField();
				wrti[18].setFieldName("CapitalCost");// 资金成本
				wrti[18].setFieldValue("44.87");// 被留言人字段的值，111为被留言人id
				wrti[18].setView(true);// 字段是否可见
				wrti[18].setEdit(true);// 字段是否可编辑

				wrti[19] = new WorkflowRequestTableField();
				wrti[19].setFieldName("ContrProcefee");// 合同加工费
				wrti[19].setFieldValue("44.87");
				wrti[19].setView(true);
				wrti[19].setEdit(true);
				
				wrti[20] = new WorkflowRequestTableField();
				wrti[20].setFieldName("total");// 合计
				wrti[20].setFieldValue("44.87");
				wrti[20].setView(true);
				wrti[20].setEdit(true);
				
				wrti[21] = new WorkflowRequestTableField();
				wrti[21].setFieldName("CostTotal");// 成本合计
				wrti[21].setFieldValue("111");// 被留言人字段的值，111为被留言人id
				wrti[21].setView(true);// 字段是否可见
				wrti[21].setEdit(true);// 字段是否可编辑

				wrti[22] = new WorkflowRequestTableField();
				wrti[22].setFieldName("Total_profits");// 利润合计
				wrti[22].setFieldValue("444");
				wrti[22].setView(true);
				wrti[22].setEdit(true);
				
				wrti[23] = new WorkflowRequestTableField();
				wrti[23].setFieldName("EMPLOYEE");// 销售雇员
				wrti[23].setFieldValue("test");
				wrti[23].setView(true);
				wrti[23].setEdit(true);
				/**
				 * 注意：只能是int类型
				 */
			

				
				wrti[24] = new WorkflowRequestTableField();
				wrti[24].setFieldName("apply_date");// 申请日期
				wrti[24].setFieldValue("2017-09-08");
				wrti[24].setView(true);
				wrti[24].setEdit(true);
				
				
			
				wrti[25] = new WorkflowRequestTableField();
				wrti[25].setFieldName("department"); //部门
				wrti[25].setFieldValue("11");
				wrti[25].setView(true);
				wrti[25].setEdit(true);
				
				
				wrti[26] = new WorkflowRequestTableField();
				wrti[26].setFieldName("apply_user"); //申请人
				wrti[26].setFieldValue("1551");
				wrti[26].setView(true);
				wrti[26].setEdit(true);
				
				wrti[27] = new WorkflowRequestTableField();
				wrti[27].setFieldName("Purcontr_engine");// 采购合同引擎  注意：只能是int类型
				wrti[27].setFieldValue("1111");
				wrti[27].setView(true);
				wrti[27].setEdit(true);
				
			/*	wrti[28] = new WorkflowRequestTableField();
				wrti[28].setFieldName("apply_user_no");// 申请人工号
				wrti[28].setFieldValue("111");// 被留言人字段的值，111为被留言人id
				wrti[28].setView(true);// 字段是否可见
				wrti[28].setEdit(true);// 字段是否可编辑
*/				
				/*wrti[27] = new WorkflowRequestTableField();
				wrti[27].setFieldName("File_upload");//附件上传
				wrti[27].setFieldValue("111");
				wrti[27].setView(true);
				wrti[27].setEdit(true);*/
				/*
				 * wrti[3] = new WorkflowRequestTableField();
				 * wrti[3].setFieldName("fj2");//附件
				 * wrti[3].setFieldType("http:baidu_sylogo1.gif");//http:开头代表该字段为附件字段
				 * wrti[3].setFieldValue("http://www.baidu.com/img/baidu_sylogo1.gif");/
				 * /附件地址 wrti[3].setView(true); wrti[3].setEdit(true);
				 */
				
						
				requestInfo.setRequestName("SD06-合同审批");
														
				//只有一个主表单
				WorkflowRequestTableRecord[] mtrs= new WorkflowRequestTableRecord[1];
				WorkflowRequestTableRecord mainTableR = new WorkflowRequestTableRecord();
				mainTableR.setWorkflowRequestTableFields(wrti);
				mtrs[0]=mainTableR;
				
				workflowMainTableInfo = new WorkflowMainTableInfo();
				workflowMainTableInfo.setRequestRecords(mtrs);
				
				requestInfo.setWorkflowMainTableInfo(workflowMainTableInfo);//主表单信息
			}
			
			
			//子表单信息
			if(itemTable!=null && itemTable.size()>0){
				
				WorkflowDetailTableInfo wdti[] = new WorkflowDetailTableInfo[3];
				
				
					WorkflowRequestTableField danjns = new WorkflowRequestTableField();
					danjns.setEdit(true);
					danjns.setView(true);
					danjns.setFieldName("SILICON");
					danjns.setFieldValue("1");
				//	dwrtfs[0]=danjns;
					//补办人工号
					WorkflowRequestTableField xm = new WorkflowRequestTableField();
					xm.setEdit(true);
					xm.setView(true);
					xm.setFieldName("MAIN_GRID");
					xm.setFieldValue("2");
				//	dwrtfs[1]=xm;
					
					//补办人部门
					WorkflowRequestTableField wulph = new WorkflowRequestTableField();
					wulph.setEdit(true);
					wulph.setView(true);
					wulph.setFieldName("TECH");
					wulph.setFieldValue("3");
					//dwrtfs[2]=wulph;
					
					
					
					
					//dtr.setWorkflowRequestTableFields(dwrtfs);
					//dtrs[i]=dtr;
				
				
				WorkflowDetailTableInfo wdtf = new WorkflowDetailTableInfo();
				//wdtf.setWorkflowRequestTableRecords(dtrs);
			
			
				//只有一个子表单
				WorkflowDetailTableInfo[] workflowDetailTableInfos = new WorkflowDetailTableInfo[1];
				workflowDetailTableInfos[0]=wdtf;
				
				requestInfo.setWorkflowDetailTableInfos(workflowDetailTableInfos);//子表单信息
			}
			
			if(workflowMainTableInfo!=null){
		
				String addrss="http://192.168.0.35//services/WorkflowService";
				WorkflowServicePortTypeProxy client = new WorkflowServicePortTypeProxy(addrss);
			
				requestInfo.setCreatorId(createId+"");
				result =client.doCreateWorkflowRequest(requestInfo, Integer.valueOf(createId));
				
				log.info(result);
				System.out.println(result);
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

}
