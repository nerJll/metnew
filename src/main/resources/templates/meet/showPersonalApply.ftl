<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<base id="ctx" href="ctx">
<title>我的申请</title>
<meta name="renderer" content="webkit">   
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${ctx}/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${ctx}/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<script>
	function cancelMeet(meetId) {
		$('#meetId1').val(meetId)
	}

	function queryMeet() {
		var applyOrTheme = $('#applyOrTheme').val()
		//模拟表单提交
		var url = "${ctx}/meet/showMyApply";
		var form = $("<form></form>").attr("action", url).attr("method", "post");
		form.append($("<input></input>").attr("type", "hidden").attr("name", "applyOrTheme").attr("value", applyOrTheme));
		form.appendTo('body').submit().remove();
	}
	
	function xiangq(meetId){
		var url = "${ctx}/meet/showOneMeetInfo";
		var form = $("<form></form>").attr("action", url).attr("method", "post");
		form.append($("<input></input>").attr("type", "hidden").attr("name", "meetId").attr("value", meetId));
		form.appendTo('body').submit().remove();
	}
	
	function fanhui(){
		var sUserAgent = navigator.userAgent.toLowerCase();
		var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
		var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
		var bIsMidp = sUserAgent.match(/midp/i) == "midp";
		var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
		var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
		var bIsAndroid = sUserAgent.match(/android/i) == "android";
		var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
		var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";
		if (!(bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM)) {
			window.location.href= '${ctx}/meet/index';
		} else {
			window.location.href = '${ctx}/mobile';
		}
	}
</script>
</head>
<body>
	<div class="panel panel-default">
		<div style="text-align: center;" class="panel-heading">
			<input style='float:left' onclick='fanhui()' class="btn btn-primary" type="button" value="<< 预订会议">
			<font size=5px><b>我的预订</b></font>
		</div>
		<div class="panel-body">
				<div class="form-group">
					<div class='row'>
						<div class='col-md-2 col-xs-6'>
							<input type="text" class="form-control" id="applyOrTheme"
								placeholder="发起人 / 主题">
						</div>
						<div class='col-md-1 col-xs-2'>
							<button onclick='queryMeet()' class="btn btn-primary">查询</button>
						</div>
					</div>
				</div>
		</div>
		<form class="form-group">
			<table class="table table-bordered table-hover">
				<tr class="info">
					<th style="text-align: center">发起人</th>
					<th style="text-align: center">主题</th>
					<th style="text-align: center">时间</th>
					<th style="text-align: center">类型</th>
					<th style="text-align: center">视频号</th>
					<th style="text-align: center">状态</th>
					<th style="text-align: center">详情</th>
					<th style="text-align: center">取消</th>
				</tr>
				<#list meets.list as meet>
				<tr>
					<td style="text-align: center">${meet.applyEmpName}</td>
					<td style="text-align: center">
						<#if meet.meetTheme==''>
						<#else>
							${meet.meetTheme}
						</#if>
					</td>
					<td style="text-align: center">${meet.staTime?string('yyyy年MM月dd日
						HH:mm')} ~ ${meet.endTime?string('HH:mm')}</td>
					<td style="text-align: center">${meet.meetType}</td>
					<td style="text-align: center"><#if meet.meetType=="视频会议">
						${meet.resTwo} <#else> --- </#if></td>
					<td style="text-align: center"><#if meet.meetState=="已取消">
						<font color=red>${meet.meetState}</font> <#else>
						${meet.meetState} </#if></td>
					<td style="text-align: center">
						<button type="button" onclick='xiangq("${meet.meetId}")' class="btn btn-success">查看</button>
						</td>
					<td style="text-align: center"><#if meet.meetState=="已通过">
						<a data-toggle="modal" data-target="#myModal"
							onclick='cancelMeet("${meet.meetId}")' class="btn btn-warning">取消</a>
						</#if></td>
				</tr>
				</#list>
			</table>

			<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><#if meets.total !=0> <span>第${meets.pageNum}/${meets.pages}页</#if>
						总记录数：${meets.total} <#if meets.total
								!=0>每页显示:${meets.pageSize}&nbsp;&nbsp;&nbsp;</span></#if></li>
					<#if meets.pageNum!=1>
					<li><a href="${ctx}/meet/showMyApply?currentPage=1">首页</a></li>
					<li><a
						href="${ctx}/meet/showMyApply?currentPage=${meets.pageNum-1}"
						aria-label="Previous"> <span aria-hidden="true">&lt;&lt;</span>
					</a></li>
					</#if>
					<#if meets.pageNum !=meets.pages && meets.pages!=0>
					<li><a
						href="${ctx}/meet/showMyApply?currentPage=${meets.pageNum+1}"
						aria-label="Next"> <span aria-hidden="true">&gt;&gt;</span>
					</a></li>
					<li><a
						href="${ctx}/meet/showMyApply?currentPage=${meets.pages}">尾页</a></li>
					</#if>
				</ul>
			</nav>
		</form>
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">会议取消</h4>
				</div>
				<form action='${ctx}/meet/cancelMeet' method='get'>
					<div class="modal-body">
						<input type='hidden' id='meetId1' name='meetId'> <span
							style='color: blue; font-weight: bold; font-size: 20px'>取消信息将会推送给各参会人员</span>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">确认</button>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	</div>
</body>
</html>