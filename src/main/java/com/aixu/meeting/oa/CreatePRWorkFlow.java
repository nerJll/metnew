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
public class CreatePRWorkFlow {
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
				//主表单信息
				//主表字段信息
				WorkflowRequestTableField[] wtfs = new WorkflowRequestTableField[mainTable.size()];//mainTable.size()
				
				//订单类型
				WorkflowRequestTableField ddlx = new WorkflowRequestTableField();
				ddlx.setEdit(true);
				ddlx.setView(true);
				ddlx.setFieldName("gangwei");//对应字段数据库的字段名
				ddlx.setFieldValue("1");
				wtfs[0]=ddlx;
						
				requestInfo.setRequestName("工牌补办");
														
				//只有一个主表单
				WorkflowRequestTableRecord[] mtrs= new WorkflowRequestTableRecord[1];
				WorkflowRequestTableRecord mainTableR = new WorkflowRequestTableRecord();
				mainTableR.setWorkflowRequestTableFields(wtfs);
				mtrs[0]=mainTableR;
				
				workflowMainTableInfo = new WorkflowMainTableInfo();
				workflowMainTableInfo.setRequestRecords(mtrs);
				
				requestInfo.setWorkflowMainTableInfo(workflowMainTableInfo);//主表单信息
			}
			
			
			//子表单信息
			if(itemTable!=null && itemTable.size()>0){
				WorkflowRequestTableRecord[] dtrs= new WorkflowRequestTableRecord[itemTable.size()];
				for(int i=0;i<itemTable.size();i++){
					Map<String,String> map=itemTable.get(i);
					//一行
					WorkflowRequestTableRecord dtr = new WorkflowRequestTableRecord();
					//字段
					WorkflowRequestTableField[] dwrtfs=new WorkflowRequestTableField[17];
					
					//补办人名称
					WorkflowRequestTableField danjns = new WorkflowRequestTableField();
					danjns.setEdit(true);
					danjns.setView(true);
					danjns.setFieldName("goname");
					danjns.setFieldValue("1");
					dwrtfs[0]=danjns;
					//补办人工号
					WorkflowRequestTableField xm = new WorkflowRequestTableField();
					xm.setEdit(true);
					xm.setView(true);
					xm.setFieldName("gocode");
					xm.setFieldValue("2");
					dwrtfs[1]=xm;
					
					//补办人部门
					WorkflowRequestTableField wulph = new WorkflowRequestTableField();
					wulph.setEdit(true);
					wulph.setView(true);
					wulph.setFieldName("godepartment");
					wulph.setFieldValue("3");
					dwrtfs[2]=wulph;
					
					//补办人岗位
					WorkflowRequestTableField wulms = new WorkflowRequestTableField();
					wulms.setEdit(true);
					wulms.setView(true);
					wulms.setFieldName("gopost");
					wulms.setFieldValue("4");
					dwrtfs[3]=wulms;
					
					//补办原因
					WorkflowRequestTableField danj = new WorkflowRequestTableField();
					danj.setEdit(true);
					danj.setView(true);
					danj.setFieldName("reasion");
					danj.setFieldValue("5");
					dwrtfs[4]=danj;
					
					//补办日期
					WorkflowRequestTableField danw = new WorkflowRequestTableField();
					danw.setEdit(true);
					danw.setView(true);
					danw.setFieldName("bubandate");
					danw.setFieldValue("6");
					dwrtfs[5]=danw;
					
					
					
					dtr.setWorkflowRequestTableFields(dwrtfs);
					dtrs[i]=dtr;
				}
				
				WorkflowDetailTableInfo wdtf = new WorkflowDetailTableInfo();
				wdtf.setWorkflowRequestTableRecords(dtrs);
				
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
