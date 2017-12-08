package com.aixu.meeting.oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aixu.meeting.oa.workflow.WorkflowBaseInfo;
import com.aixu.meeting.oa.workflow.WorkflowDetailTableInfo;
import com.aixu.meeting.oa.workflow.WorkflowMainTableInfo;
import com.aixu.meeting.oa.workflow.WorkflowRequestInfo;
import com.aixu.meeting.oa.workflow.WorkflowRequestTableField;
import com.aixu.meeting.oa.workflow.WorkflowRequestTableRecord;
import com.aixu.meeting.oa.workflow.WorkflowServicePortTypeProxy;

public class test {
	/**
	 * 创建流程，支持多明细，并且带附件字段--目前只支持一个附件，并且是（http格式的）
	 * 
	 * @throws Exception
	 */
	public static void createRequest() throws Exception {
		// 主字段

		

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
		
		/**
		 * 申请人为 HrmResource 表的 id 字段
		 */
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
		
		wrti[28] = new WorkflowRequestTableField();
		wrti[28].setFieldName("apply_user_no");// 申请人工号
		wrti[28].setFieldValue("1016079");// 被留言人字段的值，111为被留言人id
		wrti[28].setView(true);// 字段是否可见
		wrti[28].setEdit(true);// 字段是否可编辑
	
		
		wrti[29] = new WorkflowRequestTableField();
		wrti[29].setFieldName("File_upload");//附件上传
		wrti[29].setFieldType("http:baidu_sylogo1.gif");
		wrti[29].setFieldValue("http://www.baidu.com/img/baidu_sylogo1.gif");
		wrti[29].setView(true);
		wrti[29].setEdit(true);
	
		
		WorkflowRequestTableRecord[] wrtri = new WorkflowRequestTableRecord[1];// 主字段只有一行数据
		wrtri[0] = new WorkflowRequestTableRecord();
		wrtri[0].setWorkflowRequestTableFields(wrti);

		WorkflowMainTableInfo wmi = new WorkflowMainTableInfo();
		wmi.setRequestRecords(wrtri);

		// 明细字段
		WorkflowDetailTableInfo wdti[] = new WorkflowDetailTableInfo[3];// 两个明细表0明细表1,1明细表2
		List<Map<String,String>> itemTableMap = null;
    	itemTableMap=new ArrayList<Map<String,String>>();
    	for(int i=0;i<2;i++){
		Map<String,String> map = new HashMap<String, String>();
		map.put("SILICON", "09");
		map.put("MAIN_GRID", "09");
		map.put("TECH", "09");
		itemTableMap.add(map);
	}
		// 明细表1 start
		wrtri = new WorkflowRequestTableRecord[1];// 数据 行数，假设添加2行明细数据
		// 第一行
		wrti = new WorkflowRequestTableField[20]; // 每行3个字段
		wrti[0] = new WorkflowRequestTableField();
		wrti[0].setFieldName("SILICON");// 硅片晶体
		wrti[0].setFieldValue("11");
		wrti[0].setView(true);
		wrti[0].setEdit(true);

		wrti[1] = new WorkflowRequestTableField();
		wrti[1].setFieldName("MAIN_GRID");// 主栅
		wrti[1].setFieldValue("2");
		wrti[1].setView(true);
		wrti[1].setEdit(true);

		wrti[2] = new WorkflowRequestTableField();
		wrti[2].setFieldName("TECH");// 工艺	
		wrti[2].setFieldValue("22");
		wrti[2].setView(true);
		wrti[2].setEdit(true);
		
		wrti[3] = new WorkflowRequestTableField();
		wrti[3].setFieldName("CONVERT_RATE");// 转换效率
		wrti[3].setFieldValue("444");//
		wrti[3].setView(true);// 字段是否可见
		wrti[3].setEdit(true);// 字段是否可编辑

		wrti[4] = new WorkflowRequestTableField();
		wrti[4].setFieldName("GRADE");// 等级
		wrti[4].setFieldValue("111");
		wrti[4].setView(true);
		wrti[4].setEdit(true);

		wrti[5] = new WorkflowRequestTableField();
		wrti[5].setFieldName("MOUNT");// 数量
		wrti[5].setFieldValue("444");
		wrti[5].setView(true);
		wrti[5].setEdit(true);

		wrti[6] = new WorkflowRequestTableField();
		wrti[6].setFieldName("UNIT");// 单位
		wrti[6].setFieldValue("444");// 
		wrti[6].setView(true);// 字段是否可见
		wrti[6].setEdit(true);// 字段是否可编辑

		wrti[7] = new WorkflowRequestTableField();
		wrti[7].setFieldName("UnitPricetax");// 含税单价
		wrti[7].setFieldValue("444");
		wrti[7].setView(true);
		wrti[7].setEdit(true);

		wrti[8] = new WorkflowRequestTableField();
		wrti[8].setFieldName("SUM");//金额
		wrti[8].setFieldValue("444");
		wrti[8].setView(true);
		wrti[8].setEdit(true);

		wrti[9] = new WorkflowRequestTableField();
		wrti[9].setFieldName("Wafercost");//硅片成本
		wrti[9].setFieldValue("111"); 
		wrti[9].setView(true);
		wrti[9].setEdit(true);

		wrti[10] = new WorkflowRequestTableField();
		wrti[10].setFieldName("NonsiliconCost");// 非硅成本
		wrti[10].setFieldValue("444");
		wrti[10].setView(true);
		wrti[10].setEdit(true);

		wrti[11] = new WorkflowRequestTableField();
		wrti[11].setFieldName("CapitalCost");// 资金成本  
		wrti[11].setFieldValue("1111");
		wrti[11].setView(true);
		wrti[11].setEdit(true);

		wrti[12] = new WorkflowRequestTableField();
		wrti[12].setFieldName("ContrProcefee");//合同加工费
		wrti[12].setFieldValue("29");// 被留言人字段的值，111为被留言人id
		wrti[12].setView(true);// 字段是否可见
		wrti[12].setEdit(true);// 字段是否可编辑

		wrti[13] = new WorkflowRequestTableField();
		wrti[13].setFieldName("OperatiProfit");//营业利润
		wrti[13].setFieldValue("444");
		wrti[13].setView(true);
		wrti[13].setEdit(true);

		wrti[14] = new WorkflowRequestTableField();
		wrti[14].setFieldName("OpeProfitmargin");// 营业利润率
		wrti[14].setFieldValue("444");
		wrti[14].setView(true);
		wrti[14].setEdit(true);

		wrtri[0] = new WorkflowRequestTableRecord();
		wrtri[0].setWorkflowRequestTableFields(wrti);

		wdti[0] = new WorkflowDetailTableInfo();
		wdti[0].setWorkflowRequestTableRecords(wrtri);// 加入明细表1的数据
		// 明细表1 end

		// 明细表2 start
		wrtri = new WorkflowRequestTableRecord[1];// 数据行数，假设添加1行明细数据

		// 第一行
		wrti = new WorkflowRequestTableField[2]; // 每行2个字段
		wrti[0] = new WorkflowRequestTableField();
		wrti[0].setFieldName("SILICON");//硅片晶体
		wrti[0].setFieldValue("11");
		wrti[0].setView(true);
		wrti[0].setEdit(true);

		wrti[1] = new WorkflowRequestTableField();
		wrti[1].setFieldName("MAIN_GRID");//主栅
		wrti[1].setFieldValue("2");
		wrti[1].setView(true);
		wrti[1].setEdit(true);

		
		
		
		wrtri[0] = new WorkflowRequestTableRecord();
		wrtri[0].setWorkflowRequestTableFields(wrti);

		wdti[1] = new WorkflowDetailTableInfo();
		wdti[1].setWorkflowRequestTableRecords(wrtri);// 加入明细表2的数据
		// 明细表2 end

		WorkflowBaseInfo wbi = new WorkflowBaseInfo();
		wbi.setWorkflowId("638");// workflowid 5 代表内部留言

		WorkflowRequestInfo wri = new WorkflowRequestInfo();// 流程基本信息

		wri.setRequestName("SD06-合同审批");// 流程标题
		wri.setWorkflowMainTableInfo(wmi);// 添加主字段数据
		wri.setWorkflowBaseInfo(wbi);
		wri.setWorkflowDetailTableInfos(wdti);

		// 执行创建流程接口
		WorkflowServicePortTypeProxy WorkflowServicePortTypeProxy = new WorkflowServicePortTypeProxy();
		String requestid = WorkflowServicePortTypeProxy.doCreateWorkflowRequest(wri, 1551);
		System.out.println("requestid:" + requestid);

	}

	public static void main(String[] args) throws Exception {
		new test().createRequest();
	}

}
