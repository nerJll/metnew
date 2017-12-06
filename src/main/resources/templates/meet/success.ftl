<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">   
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>信息界面</title>
		<link rel="icon" type="image/png" href="${ctx}/images/favicon.png">
		<link href="https://cdn.bootcss.com/amazeui/2.7.2/css/amazeui.min.css" rel="stylesheet">
	</head>
	<body>
		
  		<header data-am-widget="header" class="am-header am-header-default" data-am-sticky>
		      <div class="am-header-left am-header-nav">
		          <a href="javascript:void(0);" onclick="browserRedirect()">
		              <i class="am-header-icon am-icon-home"></i>
		          </a>
		      </div>
		      <h1 class="am-header-title">信息界面</h1>
  		</header>
  		<div class="am-container">
  			<h1 style="color: #009ACD;">
  					您预定成功，请留意微信企业号通知 :)
  					<a href="javascript:void(0);" style='float:right;color:green;' onclick="browserRedirect()">返回首页>></a>
  			</h1>
  			<table class="am-table am-table-bordered am-table-radius am-table-striped">
  				<tr><td class="am-primary">发起人</td><td>${meetInfo.applyEmpName}</td></tr>
  				<tr><td class="am-primary">主题</td><td>${meetInfo.meetTheme}</td></tr>
  				<tr><td class="am-primary">类型</td><td>${meetInfo.meetType}</td></tr>
  				<tr><td class="am-primary">时间</td><td>${meetInfo.staTime?string('yyyy-MM-dd HH:mm:ss')}~${meetInfo.endTime?string('yyyy-MM-dd HH:mm:ss')}</td></tr>
  			</table>
  			<table class="am-table am-table-bordered am-table-radius am-table-striped">
  				<thead>
  					<tr><th class="am-primary">会议室</th><th class="am-primary">参会人员</th></tr>
  				</thead>
  				<tbody>
  					<#list rooms as vo>
  						<tr><td>${vo.roomName}</td><td>${vo.employeeName}</td></tr>
  					</#list>
  				</tbody>
  			</table>
  		</div>
  		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  		<script src="https://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min.js"></script>
  		<script type="text/javascript">
  			function browserRedirect() {
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
	</body>
</html>
