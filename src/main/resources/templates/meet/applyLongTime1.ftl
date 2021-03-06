<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>长期预订</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="icon" type="image/png" href="${ctx}/images/favicon.png">
<link rel="stylesheet" type="text/css" href="${ctx}/css/amazeui.min.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/css/amazeui.chosen.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/order-base.css">
<style type="text/css">
.mask {
	position: absolute;
	top: 0px;
	filter: alpha(opacity = 60);
	background-color: #777;
	z-index: 1002;
	left: 0px;
	opacity: 0.5;
	-moz-opacity: 0.5;
}
</style>
</head>
<body>
	<header data-am-widget="header" class="am-header am-header-default"
		data-am-sticky>
		<div class="am-header-left am-header-nav">
			<a href="${ctx}/meet/index" class="">&lt;&lt;返回 </a>
		</div>

		<h1 class="am-header-title">会议预订系统</h1>

		<div class="am-header-right am-header-nav">
			<a href="#right-link" class=""> <i
				class="am-header-icon am-icon-bars"></i>
			</a>
		</div>
	</header>
	<div class="am-container">
		<form class="am-form am-form-horizontal" id="myform" method="post"
			action="${ctx}/common/save-LongApply1" onsubmit="submitForm1()">
			<hr>
			<!-- 预定人 -->
			<input type='hidden' name='resFour' value='${userName}' />
			<!-- 申请人 -->
			<input type='hidden' name='spr' />
			<!-- 公司 -->
			<input type='hidden' name='company' />
			<!--发起人-->
			<div class="am-form-group">
				<label for="user-name" class="am-u-sm-3 am-form-label am-icon-user">&nbsp;&nbsp;发
					起 人&nbsp;&nbsp;<span style='color: red'>*</span>
				</label>
				<div class="am-u-sm-9">
					<select id="applyPerson" name="applyEmpNo" data-placeholder="发起人"
						class="chosen-select" required>
						<#list users as user> <#if user.name==userName>
						<option value="${userId}" selected>${userName}</option>
						<#else>
						<option value="${user.userid}">${user.name}（${user.deptName}）</option></#if>
						</#list>
					</select> <br>
				</div>
			</div>
			<!--会议室-->
			<div class="am-form-group">
				<label for="room" class="am-u-sm-3 am-form-label am-icon-tag">&nbsp;&nbsp;会议室
					&nbsp;&nbsp;<span style='color: red'>*</span>
				</label>
				<div class="am-u-sm-9">
					<select name='meetRoomId' class="chosen-select" required data-am-selected="{btnWidth: '100%'}">
						<option value=''></option>
						<option value='aiko_1'>广东爱旭一期二楼会议室1</option>
						<option value='aiko_2'>广东爱旭一期一楼会议室1</option>
						<option value='aiko_3'>广东爱旭一期二楼会议室2</option>
						<option value='aiko_4'>广东爱旭一期一楼会议室2</option>
						<option value='aiko_5'>广东爱旭二期一楼会议室1</option>
						<option value='aiko_11'>广东爱旭陈董办公室</option>
						<option value='aiko_12'>广东爱旭二期二楼培训室</option>
						<option value='aixu_1'>浙江爱旭1号会议室 </option>
						<option value='aixu_2'>浙江爱旭2号会议室</option>
						<option value='aixu_3'>浙江爱旭制造副总办公室</option>
						<option value='aixu_4'>浙江爱旭陈董办公室</option>
					</select>
				</div>
			</div>
			<!--理由-->
			<div class="am-form-group">
				<label for="reason" class="am-u-sm-3 am-form-label am-icon-tag">&nbsp;&nbsp;理由
					&nbsp;&nbsp;<span style='color: red'>*</span>
				</label>
				<div class="am-u-sm-9">
					<textarea rows='3' cols='30' id="reason" name="reason"
						placeholder="理由" required></textarea>
				</div>
			</div>
			<!--时间段-->
			<div class="am-form-group">
				<label for="meetEmpNum"
					class="am-u-sm-3 am-form-label am-icon-clock-o">&nbsp;&nbsp;时间段
					<span style='color: red'>*</span></label>
					<input type='hidden' name='staTime'>
					<input type='hidden' name='endTime'>
				<div class="am-u-sm-4">
					<input id='sta1' type="text" class="am-form-field" placeholder="开始日期"
						readonly required />
				</div>
				<div class="am-u-sm-1">至</div>
				<div class="am-u-sm-4">
					<input id='end1' type="text" class="am-form-field" placeholder="结束日期"
						readonly required />
				</div>
			</div>
			<!--会议类型-->
			<div class="am-form-group">
				<label for="meetEmpNum" class="am-u-sm-3 am-form-label am-icon-tag">&nbsp;&nbsp;会议类型</label>
				<input type="hidden" name="meetType" value="普通会议">
				<div class="am-u-sm-9">
					<span>普通会议</span>
				</div>
			</div>
			<#list rooms as room>
			<div class="am-form-group">
				<input type="hidden" name="meetRoomId" value="${room.meetRoomId}">
				<input class="submit-person" type="hidden" name="gonghao"> <label
					id="${room.meetRoomId}" for="meetEmpNum"
					class="am-u-sm-3 am-form-label am-icon-home">${room.meetRoomName}</label>
				<div class="am-u-sm-9">
					<select class="chosen-select" id="multiSel"
						data-placeholder="选择参会人员" multiple required>
						<optgroup label="总经办">
							<#list zzbs as user>
							<option value="${user.userid}">${user.name}</option>
							</#list>
						</optgroup>
						<optgroup label="流程与IT部">
							<#list its as user>
							<option value="${user.userid}">${user.name}</option>
							</#list>
						</optgroup>
						<optgroup label="人力资源与行政部">
							<#list rlzys as user>
							<option value="${user.userid}">${user.name}</option>
							</#list>
						</optgroup>
						<optgroup label="采购">
							<#list cgs as user>
							<option value="${user.userid}">${user.name}</option>
							</#list>
						</optgroup>
						<optgroup label="财务">
							<#list cws as user>
							<option value="${user.userid}">${user.name}</option>
							</#list>
						</optgroup>
						<optgroup label="销售">
							<#list xs as user>
							<option value="${user.userid}">${user.name}</option>
							</#list>
						</optgroup>
						<optgroup label="研发部">
							<#list yfs as user>
							<option value="${user.userid}">${user.name}</option>
							</#list>
						</optgroup>
						<optgroup label="设备部">
							<#list sbs as user>
							<option value="${user.userid}">${user.name}</option>
							</#list>
						</optgroup>
						<optgroup label="工艺部">
							<#list gys as user>
							<option value="${user.userid}">${user.name}</option>
							</#list>
						</optgroup>
						<optgroup label="动力部">
							<#list dls as user>
							<option value="${user.userid}">${user.name}</option>
							</#list>
						</optgroup>
						<optgroup label="品质部">
							<#list zps as user>
							<option value="${user.userid}">${user.name}</option>
							</#list>
						</optgroup>
						<optgroup label="计划控制部">
							<#list jhs as user>
							<option value="${user.userid}">${user.name}</option>
							</#list>
						</optgroup>
						<optgroup label="生管办">
							<#list sgbs as user>
							<option value="${user.userid}">${user.name}</option>
							</#list>
						</optgroup>
						<optgroup label="生产部">
							<#list scbs as user>
							<option value="${user.userid}">${user.name}</option>
							</#list>
						</optgroup>
					</select> &nbsp;&nbsp;<span style='font-size: 20px; color: red'>*</span>
				</div>
			</div>
			</#list>

			<div class="am-form-group" id="flag">
				<div class="am-u-sm-6 am-u-sm-push-3">
					<span style="color: red; font-weight: bold;"><small>提示：点击提交前请确认信息有无漏填和错填</small></span>
				</div>
			</div>

			<!--按钮-->
			<div class="am-form-group" id="flag">
				<div class="am-u-sm-6 am-u-sm-push-3">
					<input class="am-btn am-btn-success am-icon-check" type="submit"
						value="提交">
					<!--<button class="am-btn am-btn-success am-icon-check" id="doc-confirm-toggle" type="button" onclick="submitForm()">&nbsp;&nbsp;确定</button>-->
				</div>
				<div class="am-u-sm-6">
					<button type="button" class="am-btn am-btn-danger"
						onclick="reMethod()">重置</button>
				</div>
			</div>
	</div>
	</form>
	</div>
	<div id="mask" class="mask"></div>

	<script type="text/javascript"
		src="${ctx}/js/jquery/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/new-ui/amazeui.min.js"></script>
	<script type="text/javascript"
		src="${ctx}/js/new-ui/amazeui.chosen.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/common/order-common.js"></script>
	<script>
		$(function(){
			//获取登陆人申请id和公司
			$.ajax({
				url:'http://portal.aikosolar.com/aiko-oa/oaInerface/getHrmResource?loginid='+${userId},
				type:'get',
				success:function(data){
					//console.log(data.data.id+'\n'+data.data.subcompanyname)
					$('input[name=spr]').val(data.data.id)
					$('input[name=company]').val(data.data.subcompanyname.substring(0,4))
				}
			})
			
			checkTime()
		})
		
		//不能选择过去时
		function checkTime(){
			var nowTemp = new Date();
		    var nowDay = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0).valueOf();
		    var nowMoth = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), 1, 0, 0, 0, 0).valueOf();
		    var nowYear = new Date(nowTemp.getFullYear(), 0, 1, 0, 0, 0, 0).valueOf();
		    var $myStart2 = $('#sta1');

		    var checkin = $myStart2.datepicker({
		      onRender: function(date, viewMode) {
		        // 默认 days 视图，与当前日期比较
		        var viewDate = nowDay;

		        switch (viewMode) {
		          // moths 视图，与当前月份比较
		          case 1:
		            viewDate = nowMoth;
		            break;
		          // years 视图，与当前年份比较
		          case 2:
		            viewDate = nowYear;
		            break;
		        }

		        return date.valueOf() < viewDate ? 'am-disabled' : '';
		      }
		    }).on('changeDate.datepicker.amui', function(ev) {
		        if (ev.date.valueOf() > checkout.date.valueOf()) {
		          var newDate = new Date(ev.date)
		          newDate.setDate(newDate.getDate() + 1);
		          checkout.setValue(newDate);
		        }
		        checkin.close();
		        $('#end1')[0].focus();
		    }).data('amui.datepicker');

		    var checkout = $('#end1').datepicker({
		      onRender: function(date, viewMode) {
		        var inTime = checkin.date;
		        var inDay = inTime.valueOf();
		        var inMoth = new Date(inTime.getFullYear(), inTime.getMonth(), 1, 0, 0, 0, 0).valueOf();
		        var inYear = new Date(inTime.getFullYear(), 0, 1, 0, 0, 0, 0).valueOf();

		        // 默认 days 视图，与当前日期比较
		        var viewDate = inDay;

		        switch (viewMode) {
		          // moths 视图，与当前月份比较
		          case 1:
		            viewDate = inMoth;
		            break;
		          // years 视图，与当前年份比较
		          case 2:
		            viewDate = inYear;
		            break;
		        }

		        return date.valueOf() <= viewDate ? 'am-disabled' : '';
		      }
		    }).on('changeDate.datepicker.amui', function(ev) {
		      checkout.close();
		    }).data('amui.datepicker');
		}

		//提交前确认
		function submitForm1(){
			$('input[name=staTime]').val($('#sta1').val()+' 00:00:00')
			$('input[name=endTime]').val($('#end1').val()+' 23:59:59')
			$('#myform').submit()
		}
		</script>
</body>
</html>