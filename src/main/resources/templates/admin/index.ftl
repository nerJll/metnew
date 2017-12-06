<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<base id="ctx" href="ctx">
<meta charset="UTF-8">
<meta name="renderer" content="webkit">   
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>密码管理</title>
<link rel="stylesheet" type="text/css"
	href="${ctx}/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${ctx}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<script>
	//端口、视频切换
	function initVal(stutas) {
		$("#type").val(stutas);
	}
	//提交更改
	function modiRas(id, acc) {
		$('#type1').val(id)
		$('#account').val(acc)
	}
	//视频密码赋值
	function fuzhi(){
		if('${type}'!='端口'){
			var p1 = $('#password1').val()
			var p2 = $('#password2').val()
			$('#password').val(p1+','+p2)
			//console.log($('#password').val())
		}
	}
</script>
</head>
<body>
	<div class="panel panel-default">
		<div style="text-align: center;" class="panel-heading">
			<font size=5px><b>密码管理</b></font>
		</div>
		<div class="panel-body">
			<div class="head">
				<form action="${ctx}/room/index" method="Get">
					<input type="hidden" id="type" name="type" />
					<div class="row">
						<div class="col-md-1 col-xs-3">
							<button type="submit" onclick="initVal('端口');"
								class="btn btn-warning">
								端口&nbsp;&nbsp;<b><span style="color: blue; font-size: 15px;"
									id="unCheckNum"></span></b>
							</button>
						</div>
						<div class="col-md-1 col-xs-3">
							<button type="submit" onclick="initVal('视频号');"
								class="btn btn-info">视频号</button>
						</div>
					</div>
				</form>

				<hr>
			</div>
			<br>
			<form class="form-group">
				<table class="table table-bordered table-hover">
					<tr class='info'>
						<th style="text-align: center">序号</th>
						<th style="text-align: center">账号</th>
						<#if type=='端口'>
							<th style="text-align: center">密码</th>
						<#else>
							<th style="text-align: center">主持方密码</th>
							<th style="text-align: center">参会方密码</th>
						</#if>
						<th style="text-align: center">操作</th>
					</tr>
					<#if type=="端口"> <#list ras.list as rasi>
					<tr>
						<td style="text-align: center">${rasi_index+1}</td>
						<td style="text-align: center">${rasi.meetRoomName}</td>
						<td style="text-align: center">${rasi.resOne}</td>
						<td style="text-align: center"><a
							onclick='modiRas("端口","${rasi.meetRoomName}")'
							data-toggle="modal" data-target="#myModal"
							class="btn btn-success">修改</a></td>
					</tr>
					</#list> <#else> <#list ras.list as rasi>
					<tr>
						<td style="text-align: center">${rasi_index+1}</td>
						<td style="text-align: center">${rasi.auAccount}</td>
						<td style="text-align: center">${rasi.auPassword}</td>
						<td style="text-align: center">${rasi.auResone}</td>
						<td style="text-align: center"><a
							onclick='modiRas("视频号","${rasi.auAccount}")' data-toggle="modal"
							data-target="#myModal" class="btn btn-success">修改</a></td>
					</tr>
					</#list></#if>
				</table>
				<nav aria-label="Page navigation">
					<ul class="pagination">
						<li><#if ras.total !=0> <span>第${ras.pageNum}/${ras.pages}页</#if>
							总记录数：${ras.total} <#if ras.total
								!=0>每页显示:${ras.pageSize}&nbsp;&nbsp;&nbsp;</span></#if></li>
						<#if ras.pageNum!=1>
						<li><a href="${ctx}/room/index?currentPage=1">首页</a></li>
						<li><a href="${ctx}/room/index?currentPage=${ras.pageNum-1}"
							aria-label="Previous"> <span aria-hidden="true">&lt;&lt;</span>
						</a></li>
						</#if>
						<#if ras.pageNum !=ras.pages && ras.pages!=0>
						<li><a href="${ctx}/room/index?currentPage=${ras.pageNum+1}"
							aria-label="Next"> <span aria-hidden="true">&gt;&gt;</span>
						</a></li>
						<li><a href="${ctx}/room/index?currentPage=${ras.pages}">尾页</a></li>
						</#if>
					</ul>
				</nav>
			</form>
		</div>
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">密码修改</h4>
				</div>
				<form action='${ctx}/room/updateRas' method='post' onsubmit='fuzhi()'>
				<div class="modal-body">
						<input type='hidden' name='type' id='type1'> <label for="account">&nbsp;账号</label>
						<input type="text" class="form-control" name='account' id="account" readonly>
						<hr>
						<#if type=='端口'>
							<label for="account">&nbsp;新密码</label> <input type="text"
							class="form-control" name='password' required>
						<#else>
							<input type='hidden' id='password' name='password'>
							<label for="account">&nbsp;主持方新密码</label> <input type="text"
							class="form-control" id="password1" required>
							<label for="account">&nbsp;参会方新密码</label> <input type="text"
							class="form-control" id="password2" required>
						</#if>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary">提交更改</button>
				</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</body>
</html>