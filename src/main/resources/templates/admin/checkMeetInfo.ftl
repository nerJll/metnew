<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<base id="ctx" href="ctx">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会议消息推送</title>
<link rel="stylesheet" type="text/css"
	href="${ctx}/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${ctx}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">
.table th, .table td {
	text-align: center;
	vertical-align: middle !important;
	font-size: 15px
}
</style>
<script>
	//可用视频会议号和密码
	var kysph = ''
	var spmm = ''

	$(function(){
        var applyEmpName = $('#applyEmpName').val() //申请人姓名
        var meetTheme = $('#meetTheme').val() //会议主题
        var staTime = $('#staTime').val() //开始时间
        var endTime = $('#endTime').val() //结束时间
        //var serverAdd = $('#serverAdd').val() //服务器地址
        getKysphm(staTime+":00",endTime+":00")
        var audioMeetNo = kysph //视频会议号
        var audioMeetPa = spmm //视频会议密码
        $('#audioMeetNo').val(audioMeetNo)
        $('#audioMeetPa').val(audioMeetPa)
        var roomName = new Array() //会议室名称
        $('input[name="roomName"]').each(function() {
            roomName.push($(this).val())
        })
        var meetEmpNo = new Array() //参会人员工号
        $('input[name="meetEmpNo"]').each(function() {
            meetEmpNo.push($(this).val())
        })
        var meetEmpName = new Array() //参会人员姓名
        $('input[name="meetEmpName"]').each(function() {
            meetEmpName.push($(this).val())
        })
        var account = new Array() //登陆账号
        $('input[name="account"]').each(function() {
            account.push($(this).val())
        })
        var password = new Array() //登陆密码
        $('input[name="password"]').each(function() {
            password.push($(this).val())
        })
        var meetId = $('#meetId').val()
        var pubInfo = '公共信息\n' + '会议发起人：' + applyEmpName + '\n' + '会议主题：'
                + meetTheme + '\n' + '开始时间：' + staTime + '\n' + '结束时间：'
                + endTime + '\n' + '参会人员姓名：' + meetEmpName + '\n' +  '视频会议号：'
                + audioMeetNo + '\n' + '视频会议密码：' + audioMeetPa + '\n'
        var secInfo = roomName + '*' + meetEmpNo + '*' + meetEmpName + '*' + account + '*' + password
        //alert(pubInfo+secInfo)
        submitForm('${ctx}/admin/sendInfo', meetId, pubInfo, secInfo)
	})

	//根据时间返回可用视频会议号
	function getKysphm(staTime,endTime){
	    $.ajax({
			url:'${ctx}/meet/getAudioInfo?staTime='+staTime+'&&endTime='+endTime,
			type:'get',
			async:false,
			dataType:'json',
			success:function(data){
                kysph = data.auAccount
                spmm = data.auPassword
			    //alert(kysph+spmm)
			}
		})
	}

	//模拟表单提交
	function submitForm(path, meetId, pubInfo, secInfo) {
		var url = path;
		var form = $("<form></form>").attr("action", url)
				.attr("method", "post")
		form.append($("<input></input>").attr("type", "hidden").attr("name",
				"meetId").attr("value", meetId))
		form.append($("<input></input>").attr("type", "hidden").attr("name",
				"pubInfo").attr("value", pubInfo))
		form.append($("<input></input>").attr("type", "hidden").attr("name",
				"secInfo").attr("value", secInfo))
		form.appendTo('body').submit().remove();
	}
</script>
</head>
<body>
	<div class="panel panel-default">
		<div style="text-align: center;" class="panel-heading">
			<font size=5px>会议消息推送</font>
		</div>
		<div class="panel-body">
			<form role="form">
				<table id="tb" class="table table-bordered">
					<tr class="info">
						<td style="text-align: left;" colspan="6">&nbsp;&nbsp;&nbsp;会议信息</td>
					</tr>
					<tr>
						<td width=5%>发起人</td>
						<td width=10%>${meet.applyEmpName} 
						<input type='hidden' id="meetId" name='meetId' value='${meet.meetId}'>
						<input type='hidden'
							id='applyEmpName' value='${meet.applyEmpName}'></td>
						<td width=5%>主题</td>
						<td width=8%>${meet.meetTheme} <input type='hidden'
							id='meetTheme' value='${meet.meetTheme}'>
						</td>
						<td width=5%>状态</td>
						<td width=10%>${meet.meetState}</td>
					</tr>
					<tr>
						<td>会议时间</td>
						<td colspan="2">${meet.staTime?string('yyyy-MM-dd HH:mm')} 至
							${meet.endTime?string('HH:mm')} <input type='hidden' id='staTime'
							value="${meet.staTime?string('yyyy-MM-dd HH:mm')}"> <input
							type='hidden' id='endTime'
							value="${meet.endTime?string('yyyy-MM-dd HH:mm')}">
						</td>
						<td>申请时间</td>
						<td colspan="2">${meet.meetCreateTime?string('yyyy-MM-dd
							HH:mm')}</td>
					</tr>
					<tr class="info">
						<td style="text-align: left; font-size: 15px" colspan="6">&nbsp;&nbsp;&nbsp;账号密码</td>
					</tr>
					<tr>
						<!-- <td>服务器地址</td>
						<td><input type="text" class="form-control" id="serverAdd"
							value="121.9.9.38" placeholder="服务器地址" required></td> -->
						<td>视频会议号</td>
						<td colspan="2"><input type="text" id="audioMeetNo"></td>
						<td>视频会议密码</td>
						<td colspan="2"><input type="text" id="audioMeetPa"></td>
					</tr>
					<#list roomAndEmpList as list>
					<tr class="info">
						<td style="text-align: left; font-size: 15px" colspan="6">&nbsp;&nbsp;&nbsp;${list_index+1}号参会方</td>
					</tr>
					<tr>
						<td>会议室名称</td>
						<td colspan="2">${list.roomName}<input type='hidden' name='roomName' value='${list.roomName}' /></td>
						<td>参会人员</td>
						<td colspan="2">${list.employeeName!} <input type="hidden"
							name="meetEmpNo" value="${list.number}"> <input
							type='hidden' name='meetEmpName' value='${list.employeeName}' />
						</td>
					</tr>
					<tr>
						<#if list.roomName?index_of("00")!=-1>
							<td colspan=6><input type="hidden"
								name="account" value="${list.roomName}">
							<input type="hidden"
								name="password" value="${list.password}"></td>
						<#else>
							<td colspan=6><input type="hidden" name="account"
								value="不需要">
							<input type="hidden" name="password"
								value="不需要"></td>
						</#if>
					</tr>
					</#list>
				</table>

			</form>
			<div class="container-fluid text-center">
				<button class="btn btn-primary btn-lg" data-toggle="modal"
					data-target="#myModal">推 送</button>

				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">推送前确认</h4>
							</div>
							<div class="modal-body">所填信息将会推送给各参会人员</div>
							<div style="text-align:center;" class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button style="width: 90px" onclick="sendMeetInfo()"
								class="btn btn-success">确 定</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
			</div>
		</div>
</body>
</html>