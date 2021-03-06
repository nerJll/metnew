<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base id="ctx" href="ctx">
<title>会议详情</title>
<meta name="renderer" content="webkit">    
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${ctx}/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${ctx}/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<script>
function fanhui(){
	window.location.href='${ctx}/meet/showMyApply'
}
</script>
<style>
#header {
	height: 50px;
	background-color: #FCFCFC;
	font-size: 25px;
	text-align: center;
	padding-top: 10px;
}
</style>
</head>
<body>
	<div id='header' class='container-fluid'>
		<span>会议详情</span>
		<input style='float:left' onclick='fanhui()' class="btn btn-primary" type="button" value="<< 返回">
	</div>
	<div class='container'>
		<table id="tb" class="table table-bordered">
			<tr class="info">
				<td style="text-align: left;" colspan="3">基本信息</td>
			</tr>
			<tr>
				<td width=30%>发起人：${meet.applyEmpName}</td>
				<td width=30%>主题：${meet.meetTheme}</td>
				<td width=20%>${meet.meetType}</td>
			</tr>
			<tr>
				<td colspan="2">
				时间：
				${meet.staTime?string('yyyy-MM-dd HH:mm')} 至
					${meet.endTime?string('HH:mm')}</td>
				<td width=10%><#if meet.meetState=="已取消">
						<font color=red>${meet.meetState}</font> <#else>
						${meet.meetState} </#if></td>
			</tr>
			<#if meet.meetType=="视频会议">
			<tr>
				<td colspan="3">视频号：${meet.resTwo}</td>
			</tr> 
			<tr>
				<td colspan="3">主持方：${meet.resThree}</td>
			</tr>
			</#if>
			<tr>
				<td colspan='3'>申请时间：${meet.meetCreateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
			</tr>
			<tr class='info'>
				<td colspan="3">会议室人员</td>
			</tr>
			<#list amrs as amr>
			<tr>
				<td>${amr.resFive}</td>
				<td colspan="2">${amr.personNames!}</td>
			</tr>
			</#list>
		</table>
	</div>
</body>
</html>