<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>预定界面</title>
		<style type="text/css">
			.my {
				display: flex;
				display: -webkit-flex;
				justify-content: center;
				align-items: center;
			}
		</style>
		<link rel="icon" type="image/png" href="${ctx}/images/favicon.png">
		<link href="https://cdn.bootcss.com/amazeui/2.7.2/css/amazeui.min.css" rel="stylesheet">
		<link href="${ctx}/js/nmslwsnd/dist/css/select2.min.css"  rel="stylesheet">
	</head>
	<body>
		<header data-am-widget="header" class="am-header am-header-default my">
          
		      <!--<div class="am-header-left am-header-nav">
		          <a href="#left-link" class="">
		              <span class="am-header-nav-title"></span>
		              <i class="am-header-icon am-icon-home"></i>
		          </a>
		      </div>-->
		
		      <h1 class="am-header-title">
		          	${meetType}预订
		      </h1>
		
		      <!--<div class="am-header-right am-header-nav">
		          <a href="#right-link" class="">
		              <span class="am-header-nav-title"></span>
		              <i class="am-header-icon am-icon-bars"></i>
		          </a>
		      </div>-->
  		</header>

  		<div class="am-container">
  			<br />
  			<form class="am-form am-form-horizontal" id="myform" method="post" action="${ctx}/meet/checkAndSaveMeet" onsubmit="submitForm()">
  				<!--发起人-->
  				<div class="am-form-group">
					<label for="user-name" class="am-u-sm-3 am-form-label am-icon-user" style="color: #009CDA; text-align: right;">发起人</label>
					<div class="am-u-sm-9">
						<select id="applyPerson" name="applyEmpNo" required></select>
					<br><span class="am-icon-bell-o" style="color:deepskyblue"><small>&nbsp;请将发起人姓名也填入对应的会议室中，否则发起人将接收不到会议信息</small></span>
					</div>
				</div>
				<!--主题-->
				<div class="am-form-group">
					<label for="meetTheme" class="am-u-sm-3 am-form-label am-icon-key" style="color: #009CDA; text-align: right;">主题</label>
					<div class="am-u-sm-9">
						<input class="am-disabled form-control" type="text" id="meetTheme" name="meetTheme" placeholder="会议主题" required>
						<span class="am-icon-clock-o" style="color: deepskyblue;"><small>&nbsp;${staTime}~${endTime}</small></span>
					</div>
				</div>
				<!--议程-->
				<div class="am-form-group">
					<label for="meetTheme" class="am-u-sm-3 am-form-label am-icon-star" style="color: #009CDA; text-align: right;">议程</label>
					<div class="am-u-sm-9">
						<textarea rows="3" cols="30" name="resFive" placeholder="会议议程"></textarea>
					</div>
				</div>
				<!--主持方-->
				<#if meetType == '视频会议'>
					<div class="am-form-group">
						<label for="meetTheme" class="am-u-sm-3 am-form-label am-icon-microphone" style="color: #009CDA; text-align: right;">主持方</label>
						<div class="am-u-sm-9">
							<select id="resThree" name="resThree" data-am-selected="{btnWidth: '100%'}" required>
								<#list rooms as zcf>
									<option value="${zcf.meetRoomName}">${zcf.meetRoomName}</option>
								</#list>
							</select>
						</div>
					</div>
				</#if>
				<!-- 隐藏域传参字段 -->
				<input type="hidden" name="staTime" value="${staTime}">
				<input type="hidden" name="endTime" value="${endTime}">
				<input type="hidden" name="meetType" value="${meetType}">
				<input type="hidden" name='resFour' value='${userName}'>
				<!-- 隐藏域传参字段 -->
				<#list rooms as room>
					<div class="am-form-group">
						<input type="hidden" name="meetRoomId" value="${room.meetRoomId}">
						<input class="submit-person" type="hidden" name="gonghao">
						<label id="${room.meetRoomId}" for="meetEmpNum" class="am-u-sm-3 am-form-label am-icon-home" style="color: #009CDA; text-align: right;">${room.resTwo}</label>
						<div class="am-u-sm-9">
							<select class="basic-multiple" id="multiSel" multiple required>
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
						</select>
						<br /><span class="am-icon-tag" style="color: #FF9900"><small>&nbsp;${room.meetRoomName}</small></span>
						</div>
					</div>
				</#list>
				<!--按钮-->
				<div class="am-form-group" id="flag">
					<div class="am-u-sm-6 am-u-sm-push-3">
						<!--<input id="careful" class="am-btn am-btn-success am-icon-check" type="submit" value="提交" >-->
						<button id="careful" class="am-btn am-btn-success" type="submit">提交</button>
					</div>
					<div class="am-u-sm-6">
						<button type="button" class="am-btn am-btn-danger" onclick="reMethod()">重置</button>
					</div>
				</div>
  			</form>
  		</div>
  		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  		<script src="https://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/nmslwsnd/dist/js/select2.full.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/common/order-common-mobile.js"></script>
		<script type="text/javascript">
			$(function () {
				// 发起人工号
				var employeeNo = ${userId}
				// 初始化
				$('.basic-multiple').select2({width: '100%'})
				$('#applyPerson').select2({width: '100%'})
				// 加载时填充选择框
				$.ajax({
					type: 'GET',
					url: '${ctx}/user/get-all-user',
					async: true,
					cache: true,
					success: function (data) {
						var tpl = ''
						for (var i = 0; i < data.length; i++) {
							// 工号判断选择
							if (employeeNo == data[i].userid) {
								tpl += '<option selected value="' + data[i].userid + '">' + data[i].name + '</option>'
							} else {
								tpl += '<option value="' + data[i].userid +	'">' + data[i].name + '</option>'
							}
						}
						$('#applyPerson').append(tpl)
					}
				});
			})
			
		</script>
	</body>
</html>