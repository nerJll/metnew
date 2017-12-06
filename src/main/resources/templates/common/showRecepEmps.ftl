<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>前台人员管理</title>
<meta name="renderer" content="webkit">   
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${ctx}/bootstrap/css/bootstrap.min.css">
<style type="text/css">
.p{
	font-size:20px;
	font-weight:bold;
}
#app-1{
	text-align:center;
}
table{
	text-align:center;
}
table th{
	text-align:center;
}
#app-3{
	text-align:left;
}
</style>
</head>
<body>
	<div class="panel panel-default">
		<div id='app-1' class="panel-heading">
			<span class='p'>{{ title1 }}</span>
		</div>
		
		<div class="panel-body">
			<div class='row'>
				<div class='col-md-1 col-xs-2'>
						<input type='button' 
						data-toggle="modal" data-target="#addModel"
						@click='javascript:void(0)' class="btn btn-primary" value='新增'>
				</div>
			</div>
			<hr>
			<div id='app-2'>
				<form class="form-group">
					<table class="table table-bordered table-hover">
						<tr class="info">
							<th>{{ index }}</th>
							<th>{{ name }}</th>
							<th>{{ empno }}</th>
							<th>{{ from }}</th>
							<th>{{ delete1 }}</th>
							<th>{{ modify }}</th>
						</tr>
						<#list recepemps.list as emp>
							<tr>
								<td>
									${emp_index+1}</td>
								<td>
									${emp.rempEname}</td>
								<td>
									${emp.rempEno}</td>
								<td>
									${emp.rempResone}</td>
								<td>
									<input type="button" @click='deleteEmp("${emp.rempId}")'
									data-toggle="modal" data-target="#deleteModel"
									 class="btn btn-danger" value='删除'></td>
								<td>
									<input type="button" @click='modifyEmp("${emp.rempId}","${emp.rempEno}","${emp.rempEname}","${emp.rempResone}")' 
									data-toggle="modal" data-target="#modiModel"
									class="btn btn-warning" value='修改'></td>
							</tr>
						</#list>
					</table>
					
					<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><#if recepemps.total !=0> <span>第${recepemps.pageNum}/${recepemps.pages}页</#if>
						总记录数：${recepemps.total} <#if recepemps.total
								!=0>每页显示:${recepemps.pageSize}&nbsp;&nbsp;&nbsp;</span></#if></li>
					<#if recepemps.pageNum!=1>
					<li><a href="${ctx}/user/recepemp?currentPage=1">首页</a></li>
					<li><a
						href="${ctx}/user/recepemp?currentPage=${recepemps.pageNum-1}"
						aria-label="Previous"> <span aria-hidden="true">&lt;&lt;</span>
					</a></li>
					</#if>
					<#if recepemps.pageNum !=recepemps.pages && recepemps.pages!=0>
					<li><a
						href="${ctx}/user/recepemp?currentPage=${recepemps.pageNum+1}"
						aria-label="Next"> <span aria-hidden="true">&gt;&gt;</span>
					</a></li>
					<li><a
						href="${ctx}/user/recepemp?currentPage=${recepemps.pages}">尾页</a></li>
					</#if>
				</ul>
			</nav>
				</form>
			</div>
		</div>
	</div>
	
	<!-- 新增模态框 -->
	<div class="modal fade" id="addModel" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div id='app-3' class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">{{ xzqtry }}</h4>
				</div>
				<form action='${ctx}/user/addRecepEmp' method='post'>
					<div class="modal-body">
						 <label for="empNo">{{ empNo }}</label>
						 <input type="text"
							class="form-control" name='rempEno'
							placeholder='工号' required>
						 <label for="empName">{{ name }}</label>
						 <input type="text"
							class="form-control" name="rempEname"
							placeholder='姓名' required>
						 <label for="empFrom">{{ from }}</label>
						 <select class='form-control' name='rempResone' required>
						 	<option value=''></option>
						 	<option :value='gdax'>{{ gdax }}</option>
						 	<option :value='zjax'>{{ zjax }}</option>
						 </select>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value='关闭'>
						<input type="submit" class="btn btn-primary" vlaue='提交'>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-- 删除模态框 -->
	<div class="modal fade" id="deleteModel" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">刪除前台员工</h4>
				</div>
				<form action='${ctx}/user/deleteRecepEmp' method='post'>
					<div class="modal-body">
						<input type='hidden' id='empId1' name='empId'> <span
							style='color: blue; font-weight: bold; font-size: 20px'>确认删除</span>
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
	<!-- 修改模态框 -->
	<div class="modal fade" id="modiModel" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div id='app-3' class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">{{ xgqtygxx }}</h4>
				</div>
				<form action='${ctx}/user/modifyRecepEmp' method='post'>
					<div class="modal-body">
						<input type='hidden' id='empId2' name='rempId'>
						 <label for="empNo">{{ empNo }}</label>
						 <input type="text"
							class="form-control" id='rempEno2' name='rempEno'
							placeholder='工号' required>
						 <label for="empName">{{ name }}</label>
						 <input type="text"
							class="form-control" id="rempEname2" name="rempEname"
							placeholder='姓名' required>
						 <label for="empFrom">{{ from }}</label>
						 <select class='form-control' id='rempResone2' name='rempResone' required>
						 	<option value=''></option>
						 	<option :value='gdax'>{{ gdax }}</option>
						 	<option :value='zjax'>{{ zjax }}</option>
						 </select>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value='关闭'>
						<input type="submit" class="btn btn-primary" vlaue='提交'>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	
	<script type="text/javascript" src="${ctx}/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/vue/vue.min.js"></script>
	
	<script>
		//删除
		function deleteEmp(empId){
			$('#empId1').val(empId)
		}
		//修改
		function modifyEmp(empId,empNo,empName,empFrom){
			$('#empId2').val(empId)
			$('#rempEno2').val(empNo)
			$('#rempEname2').val(empName)
			$('#rempResone2').val(empFrom)
		}
	
		var app1 = new Vue({
			el : '#app-1',
			data : {
				title1 : '前台接收人员信息管理'
			}
		})
		
		var app2 = new Vue({
			el : '#app-2',
			data : {
				index : '序号',
				name : '姓名',
				empno : '工号',
				from : '所属',
				delete1 : '删除',
				modify : '修改'
			}
		})
		
		var app3 = new Vue({
			el : '#app-3',
			data : {
				xzqtry : '新增前台人员',
				empNo : '工号',
				name : '姓名',
				from : '所属',
				gdax : '广东爱旭',
				zjax : '浙江爱旭'
			}
		})
		
		var app4 = new Vue({
			el : '#modiModel',
			data : {
				xgqtygxx : '修改前台员工信息',
				empNo : '工号',
				name : '姓名',
				from : '所属',
				gdax : '广东爱旭',
				zjax : '浙江爱旭'
			}
		})
		
	</script>
</body>
</html>