<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>长期预订</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="icon" type="image/png" href="${ctx}/images/favicon.png">
<link rel="stylesheet" type="text/css" href="${ctx}/css/amazeui.min.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/amazeui.chosen.css" />
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
			<a href="${ctx}/meet/index" class="">&lt;&lt;返回
			</a>
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
			action="${ctx}/common/save-LongApply" onsubmit="submitForm()">
			<hr>
			<!-- 预定人 -->
			<input type='hidden' name='resFour' value='${userName}'/>
			<!--发起人-->
			<div class="am-form-group">
				<label for="user-name" class="am-u-sm-3 am-form-label am-icon-user">&nbsp;&nbsp;发
					起 人&nbsp;&nbsp;<span style='color: red'>*</span>
				</label>
				<div class="am-u-sm-9">
					<select id="applyPerson" name="applyEmpNo" data-placeholder="发起人"
						class="chosen-select" required>
						<#list users as user>
						<#if user.name==userName>
							<option value="${userId}" selected>${userName}</option>
						<#else>
							<option value="${user.userid}">${user.name}（${user.deptName}）</option>
						</#if>
						</#list>
					</select> <br>
				</div>
			</div>
			<!--主题-->
			<div class="am-form-group">
				<label for="meetTheme" class="am-u-sm-3 am-form-label am-icon-tag">&nbsp;&nbsp;会议主题
					&nbsp;&nbsp;<span style='color: red'>*</span>
				</label>
				<div class="am-u-sm-9">
					<input type="text" id="meetTheme" name="meetTheme"
						placeholder="会议主题" required>
				</div>
			</div>
			<!--议程-->
			<div class="am-form-group">
				<label for="resFive" class="am-u-sm-3 am-form-label am-icon-tag">&nbsp;&nbsp;会议议程
					&nbsp;&nbsp;
				</label>
				<div class="am-u-sm-9">
					<textarea rows='3' cols='30' id="resFive" name="resFive"
						placeholder="会议议程"></textarea>
				</div>
			</div>
			<!--时间段-->
			<div class="am-form-group">
				<label for="meetEmpNum"
					class="am-u-sm-3 am-form-label am-icon-clock-o">&nbsp;&nbsp;时间段</label>
				<input type="hidden" name="staTime" value="${staTime}"> <input
					type="hidden" name="endTime" value="${endTime}">
				<div class="am-u-sm-9">
					<span>${staTime} ~ ${endTime}</span>
					<div id='sbcwb'>
					
					</div>
				</div>
			</div>
			<!--循环-->
			<div class="am-form-group">
				<label for="meetEmpNum"
					class="am-u-sm-3 am-form-label am-icon-clock-o">&nbsp;&nbsp;周期</label>
				<input type="hidden" name="staTime" value="${staTime}"> <input
					type="hidden" name="endTime" value="${endTime}">
				<div class="am-u-sm-9">
					持续类型：<select name="loopType" class="am-input-sm" required>
							<option value=""></option>
							<option value="日循环">每天</option>
							<option value="周循环">每周</option>
						</select>
					持续次数：<select name="loopTimes" class="am-input-sm" required>
						</select>
				</div>
			</div>
			<!--会议类型-->
			<div class="am-form-group">
				<label for="meetEmpNum" class="am-u-sm-3 am-form-label am-icon-tag">&nbsp;&nbsp;会议类型</label>
				<input type="hidden" name="meetType" value="${meetType}">
				<div class="am-u-sm-9">
					<span>${meetType}</span>
				</div>
			</div>
			<div class='am-form-group'>
				<label for="meetEmpNum" class="am-u-sm-3 am-form-label am-icon-tag">
					<span style='color: red'>*</span>
				</label>
				<span style="color: red; font-weight: bold;"><small>提示：请将发起人姓名也填入对应的会议室中，否则发起人将接收不到会议信息</small></span>
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

			<#if meetType=='视频会议'> <!--选择主持方-->
			<div class="am-form-group">
				<label for="resThree" class="am-u-sm-3 am-form-label am-icon-tag">&nbsp;&nbsp;主持方
					&nbsp;&nbsp;<span style='color: red'>*</span>
				</label>
				<div class="am-u-sm-9">
					<div class="am-form-group am-form-select">
						<select name="resThree" class="am-input-sm" required>
							<option value=""></option>
							<#list rooms as room>
							<option value="${room.meetRoomName}">${room.meetRoomName}</option>
							</#list>
						</select>
					</div>
				</div>
			</div>
			</#if>

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
	<script type="text/javascript" src="${ctx}/js/new-ui/amazeui.chosen.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/common/order-common.js"></script>
	<script>
		$(function(){
			var h1 = '<option value=""></option>'
					+'<option value="2">2天</option>'
					+'<option value="3">3天</option>'
					+'<option value="4">4天</option>'
					+'<option value="5">5天</option>'
					+'<option value="6">6天</option>'
					+'<option value="7">7天</option>'
					+'<option value="8">8天</option>'
					+'<option value="9">9天</option>'
					+'<option value="10">10天</option>'
					+'<option value="11">11天</option>'
					+'<option value="12">12天</option>'
					+'<option value="13">13天</option>'
					+'<option value="14">14天</option>'
					
			var h2 = '<option value=""></option>'
					+'<option value="2">2周</option>'
					+'<option value="3">3周</option>'
					+'<option value="4">4周</option>'
			$('select[name=loopType]').change(function(){
				var zhi = $('select[name=loopType]').find('option:selected').val()
				if(zhi=='日循环'){
					$('select[name=loopTimes]').empty().append(h1)
					$('#sbcwb').empty()
				}else if(zhi=='周循环'){
					$('select[name=loopTimes]').empty().append(h2)
					$('#sbcwb').empty()
				}
				//console.log($('select[name=loopTimes]').append()
			})
			$('select[name=loopTimes]').change(function(){
				var sta = '${staTime}'
				var eta = '${endTime}'
				var loopType = $('select[name=loopType]').find('option:selected').val()
				var loopTimes = $('select[name=loopTimes]').find('option:selected').val()
				var html = getDateTime(loopType,loopTimes,sta,eta)
				$('#sbcwb').empty().append(html)
			})
		})
		
		//返回一个时间段之后的日期
		function getDateTime(loopType,loopTimes,staTime,endTime){
			var sta1 = new Date(Date.parse(staTime.replace(/-/g,'/'))).getTime()		
			var sta2 = new Date(Date.parse(endTime.replace(/-/g,'/'))).getTime()
			var html = ''
			if(loopType=='日循环'){
				for(var i=1; i<loopTimes; i++){
					var sta3 = sta1+86400000*i
					var sta5 = sta2+86400000*i
					var sta4 = formatDate(sta3)
					var sta6 = formatDate(sta5)
					html += 
						'<input type="hidden" name="staTime" value="'+sta4+'">'
						+'<input type="hidden" name="endTime" value="'+sta6+'">'
						+sta4+' ~ '+sta6+'<br>'
				}
				
			}else if(loopType=='周循环'){
				for(var i=1; i<loopTimes; i++){
					var sta3 = sta1+86400000*i*7
					var sta5 = sta2+86400000*i*7
					var sta4 = formatDate(sta3)
					var sta6 = formatDate(sta5)
					html += '<input type="hidden" name="staTime" value="'+sta4+'">'
					+'<input type="hidden" name="endTime" value="'+sta6+'">'
					+sta4+' ~ '+sta6+'<br>'
					
				}
			}
			return html
		}
		//日期转换工具
		Date.prototype.format = function (format) // author: meizz
		{
		    var o = {
		        "M+": this.getMonth() + 1, // month
		        "d+": this.getDate(),    // day
		        "h+": this.getHours(),   // hour
		        "m+": this.getMinutes(), // minute
		        "s+": this.getSeconds(), // second
		        "q+": Math.floor((this.getMonth() + 3) / 3),  // quarter
		        "S": this.getMilliseconds() // millisecond
		    };
		    if (/(y+)/.test(format))
		        format = format.replace(RegExp.$1,
		                (this.getFullYear() + "").substr(4 - RegExp.$1.length));
		    for (var k in o)
		        if (new RegExp("(" + k + ")").test(format))
		            format = format.replace(RegExp.$1,
		                    RegExp.$1.length == 1 ? o[k] :
		                        ("00" + o[k]).substr(("" + o[k]).length));
		    return format;
		};
		//格式化日期
		function formatDate(value){
		    var unixTimestamp = new Date(value);  
		    return unixTimestamp.format("yyyy-MM-dd hh:mm:ss"); 
		}
	</script>
</body>
</html>