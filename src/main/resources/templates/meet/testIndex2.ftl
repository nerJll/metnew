<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base id="ctx" href="ctx">
<title>爱旭-会议室预订系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${ctx}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/bootstrap/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/pcIndex.css">
<script type="text/javascript" src="${ctx}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${ctx}/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${ctx}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${ctx}/easyui/locale/easyui-lang-zh_CN.js"></script>
<style type="text/css">
.p {
	font-size: 18px;
}
</style>
<script>
//可用视频会议号和密码
var kysph = ''
var spmm = ''
//可用视频会议室数
var kysphyss = 0
//不可用会议室号
var akNoAudioMeetRoom=new Array("aiko_2","aiko_4","aiko_5","aiko_6","aiko_8","aiko_10","aiko_12")
var axNoAudioMeetRoom=new Array("aixu_5","aixu_6","aixu_7","aixu_8","aixu_11","aixu_12","aixu_14","aixu_15")
var romi = ''
var dkmi = ''

	//页面加载启动
	$(function() {
		
		//遮盖未开放的会议室div层
		//$.messager.alert("",checkTime(x1,new Date()))
		$("#metdate").datebox().datebox('calendar').calendar({ validator:function(day){ return day > new Date()-86400000; } })
		
		 $('#metdate').datebox('textbox').css('background','#F7F7F7')
		 $('#statime').combobox('textbox').css('background','#F7F7F7')
		 $('#endtime').combobox('textbox').css('background','#F7F7F7')
		
		//$('#myApp').linkbutton('disable')
		$('#appMeet').linkbutton('disable')
		
		//alert(romi+'--'+dkmi)
		
		for(var i=1; i<36; i++){
			$('#queroom'+i).attr('title','查询会议室信息')
			$('#selectroom'+i).attr('title','选中')
			$('#disecroom'+i).attr('title','取消选中')
		}
		
		for (var i = 1; i < 13; i++) {
			showHidden(i)
		}
		for (var i = 1; i < 17; i++) {
			showHiddenXu(i)
		}
		for (var i = 1; i < 11; i++) {
			showHiddenDK(i)
		}
	})
	
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
	    return unixTimestamp.format("hh:mm"); 
	 }
	//移除所有特定字符串
	function replaceAll(str,substr){
		for(var i=0;; i++){
			if(str.indexOf(substr) == -1){
				break;
			}else{
				str = str.replace(substr,'')
			}
		}
		return str
	}
	
	//显示隐藏赋初值
	function showHidden(i) {
		$("#aiko_" + i + "a").hide()
		$("#aiko_" + i + "c").hide();
		$("#aiko_" + i + "d").hide()
		$("#aiko_" + i).hover(function() {
			$("#aiko_" + i + "a").show()
		}, function() {
			$("#aiko_" + i + "a").hide()
		})
	}
	
	function showHiddenXu(i) {
		$("#aixu_" + i + "a").hide()
		$("#aixu_" + i + "c").hide();
		$("#aixu_" + i + "d").hide()
		$("#aixu_" + i).hover(function() {
			$("#aixu_" + i + "a").show()
		}, function() {
			$("#aixu_" + i + "a").hide()
		})
	}
	function showHiddenDK(i) {
		$("#dk_" + i + "a").hide()
		$("#dk_" + i + "b").hide()
		$("#dk_" + i + "c").hide();
		$("#dk_" + i + "d").hide()
		$("#dk_" + i).hover(function() {
			$("#dk_" + i + "a").show()
			$("#dk_" + i + "b").show()
		}, function() {
			$("#dk_" + i + "a").hide()
			$("#dk_" + i + "b").hide()
		})
	}

	//打开隐藏
	function showC(){
		for (var i = 1; i < 13; i++) {
			$("#aiko_" + i).css("background-color", "#006666")
			$("#aiko_" + i + "c").show()
		}
		for (var i = 1; i < 17; i++) {
			$("#aixu_" + i).css("background-color", "#006666")
			$("#aixu_" + i + "c").show()
		}
		for (var i = 1; i < 11; i++) {
			$("#dk_" + i).css("background-color", "#006666")
			$("#dk_" + i + "c").show()
		}
	}
	
	//查询会议室
	function queryRoom() {
		var st = $('#metdate').datebox('getValue')+' '+$("#statime").val()+':00'
		var et = $('#metdate').datebox('getValue')+' '+$("#endtime").val()+':00'
		var am = $("input:radio[name='audiomeet']:checked").val()
		getKysphm(st,et)		//视频会议号
		//$.messager.alert('',kysph)
		if(romi!=''||dkmi!=''){
			$.messager.alert('提示','请先取消所有选中再进行查询')
		}else if ($('#metdate').datebox('getValue')==''||st == "" || et == "") {
			$.messager.alert("消息提示","请选择完整的会议时间")
		}else if(!checkTime(st,new Date())||!checkTime(et.replace(/-/g,'/'),new Date())){
			//console.log(st)
			$.messager.alert('消息提示','会议时间不能是过去时')
		}else if(checkTime(st,et.replace(/-/g,'/'))){
			$.messager.alert('消息提示','会议开始时间不能大于结束时间')
		} else if(am==''||am==null){
			$.messager.alert('消息提示','请选择会议类型')
		}else if(am=='视频会议' && kysph=='' && spmm== ''){
			$.messager.alert('消息提示','该时间段视频会议预订已达上限，请换个时间段吧')
		}else {
			showC()
			if(am=="视频会议"){
				for(var i=0; i<akNoAudioMeetRoom.length; i++){
					$("#"+akNoAudioMeetRoom[i]).css("background-color", "#DCDCDC")
					$("#"+akNoAudioMeetRoom[i]+"c").hide()
				}
				for(var i=0; i<axNoAudioMeetRoom.length; i++){
					$("#"+axNoAudioMeetRoom[i]).css("background-color", "#DCDCDC")
					$("#"+axNoAudioMeetRoom[i]+"c").hide()
				}
			}else{
				for(var i=0; i<akNoAudioMeetRoom.length; i++){
					$("#"+akNoAudioMeetRoom[i]).css("background-color", "#006666")
				}
				for(var i=0; i<axNoAudioMeetRoom.length; i++){
					$("#"+axNoAudioMeetRoom[i]).css("background-color", "#006666")
				}
				for(var i=0; i<11; i++){
					$("#dk_"+i).css("background-color", "#DCDCDC")
					$("#dk_" + i + "c").hide()
				}
				
				//后期有需要就开放：普通会议只能选普通会议室，不能选视频会议室
				/* $("#aiko_1").css("background-color", "#DCDCDC")
				$("#aiko_1"+ "c").hide()
				$("#aiko_1"+ "d").hide()
				$("#aiko_3").css("background-color", "#DCDCDC")
				$("#aiko_3"+ "c").hide()
				$("#aiko_3"+ "d").hide()
				$("#aixu_1").css("background-color", "#DCDCDC")
				$("#aixu_1"+ "c").hide()
				$("#aixu_1"+ "d").hide() */
			}
			$('#appMeet').linkbutton('enable')
			$.ajax({
				url:'${ctx}/meet/list-meet',
				type:'post',
				data:{
					'staTime':st,
					'endTime':et
				},
				dataType:'json',
				success:function(data){
					for(var i=0; i<data.length; i++){
						$("#"+data[i].meetRoomId).css("background-color", "#DCDCDC")
						if(data[i].meetRoomId.substring(0,4)=="aiko"||data[i].meetRoomId.substring(0,4)=="aixu"){
							$("#" + data[i].meetRoomId + "c").hide()
						}else if(data[i].meetRoomId.substring(0,2)=="dk"){
							$("#" + data[i].meetRoomId + "c").hide()
						}
					}
				}
				
			})
		}
	}
	//预订会议
	function applyMeet() {
		var st = $('#metdate').datebox('getValue')+' '+$("#statime").val()+':00'
		var et = $('#metdate').datebox('getValue')+' '+$("#endtime").val()+':00'
		getKysphm(st,et)		//视频会议号
		getKysphyss(st,et)
		var am = $("input:radio[name='audiomeet']:checked").val()
		var rom = romi.substring(0,romi.length-1)
		var dmi = dkmi.substring(0,dkmi.length-1)
		if(dmi!='' && rom!==''){
			rom += ',' + dmi
		}else if(rom == ''){
			rom = dmi
		}
		var roms = rom.split(',')
		console.log(roms.length)
		if ($('#metdate').datebox('getValue')==''||st == "" || et == "") {
			$.messager.alert("消息提示", "${ctx}" + "请选择完整的会议时间")
		} else if(!checkTime(st,new Date())||!checkTime(et.replace(/-/g,'/'),new Date())){
			$.messager.alert('消息提示','会议时间不能是过去时')
		}else if(checkTime(st,et.replace(/-/g,'/'))){
			$.messager.alert('消息提示','会议开始时间不能大于结束时间')
		}else if(rom==''&&dmi==''){
			$.messager.alert('消息提示','请选择会议室或端口')
		} else if(am==''||am==null){
			$.messager.alert('消息提示','请选择会议类型')
		}else if(am=='视频会议' && (rom.indexOf('aiko_2')!=-1 || rom.indexOf('aiko_4')!=-1 || rom.indexOf('aiko_12')!=-1)){
			$.messager.alert('消息提示','普通会议室不支持视频会议，请检查选择！')
		}else if(am=='普通会议' && rom.indexOf('dk')>=0 ){
			$.messager.alert('消息提示','虚拟端口不支持普通会议，请检查选择！')
		}else if(am=='视频会议' && kysph=='' && spmm== ''){
			$.messager.alert('消息提示','该时间段视频会议预订已达上限，请换个时间段吧')
		}else if(am=='视频会议' && roms.length+kysphyss>10){
			$.messager.alert('消息提示','该时间段视频会议预订已达上限，请减少会议室数或换个时间段吧')
		}else {
			//$.messager.alert("消息提示", "开始时间：" + st + "<br>结束时间：" + et + "<br>会议类型：" + am + "<br>会议室：" + rom )
			//openPostWindow('${ctx}/room/order-page', st,et,am,rom)
			$.messager.progress({ 
		       title: '提示', 
		       msg: '数据提交中，请稍候……', 
		    })
			//window.location.href='${ctx}/room/order-page?staTime='+st+'&&endTime='+et+'&&state='+am+'&&rooms='+rom
			//模拟表单提交
		    var url = "${ctx}/room/order-page"
			var form = $("<form></form>").attr("action", url).attr("method", "post")
			form.append($("<input></input>").attr("type", "hidden").attr("name", "staTime").attr("value", st))
			form.append($("<input></input>").attr("type", "hidden").attr("name", "endTime").attr("value", et))
			form.append($("<input></input>").attr("type", "hidden").attr("name", "state").attr("value", am))
			form.append($("<input></input>").attr("type", "hidden").attr("name", "rooms").attr("value", rom))
			form.appendTo('body').submit().remove();
		}
	}
	
	//查看会议室详情
	function getRoomInfo(roomId) {
		$('#roomInfot').empty()
		$('#meetInfot').empty()
		$('#roomInfo').window('open')
		var st = $('#metdate').datebox('getValue')
		var sts = st==''?'今天':st
		//alert(st)
		$.ajax({
			url:'${ctx}/room/getRoomInfo?roomId='+roomId+'&&appDate='+st,
			type:'get',
			dataType:'json',
			//cache:true,
			beforeSend: function () {
			    $.messager.progress({ 
			       title: '提示', 
			       msg: '数据加载中，请稍候……', 
			       text: '' 
			    });
			},
			complete: function () {
			         $.messager.progress('close');
			},
			success:function(data){
				//$.messager.alert("",data.roomInfo.meetRoomName)
				$('#roomInfot').append(
						"<tr>"
						+"<td colspan='4' style='color:blue;font-weight:bold;font-size:19px'>基本信息<hr size='1'/></td>"
						+"</tr>"
						+"<tr>"
						+"<td>名称：</td>"
						+'<th class="p">'+data.roomInfo.meetRoomName+'</th>'
						+"<td>容纳人数：</td>"
						+'<th class="p">'+data.roomInfo.meetRoomNum+'</th>'
						+"</tr>"
						+"<tr height=5></tr>"
						+"<tr>"
						+"<td>视频会议：</td>"
						+'<th class="p">'+data.roomInfo.isVideoRoom+'</th>'
						+"<td>所属：</td>"
						+'<th class="p">'+data.roomInfo.location+'</th>'
						+"</tr>"
						+"<tr height=20></tr>"
						)
				//$.messager.alert("",data.meetInfo)
				$('#meetInfot').append(
					"<tr><td colspan='8' style='color:blue;font-weight:bold;font-size:19px'>预订情况（"+sts+"）<hr size='1'/></td></tr>"
				)
				console.log(data.meetInfo)
				if(data.meetInfo.length==0){
					$('#meetInfot').append(
							"<tr>"
							+'<th class="p">暂无预订</th>'
							+"</tr>"
						)
				}else{
					for(var i=0; i<data.meetInfo.length; i++){
						var resTwo = data.meetInfo[i].resTwo==null?'--':data.meetInfo[i].resTwo
						$('#meetInfot').append(
							'<tr><td style="width:5%;color:red" class="p">'+(i+1)+'.'+'</td>'
							+"<td>发起人：</td>"
							+'<th class="p">'+data.meetInfo[i].applyEmpName+'</th>'
							+"<td>主题：</td>"
							+'<th class="p">'+data.meetInfo[i].meetTheme+'</th>'
							+"<td>类型：</td>"
							+'<th class="p">'+data.meetInfo[i].meetType+'</th>'
							+"<td>视频号：</td>"
							+'<th class="p">'+resTwo+'</th>'
							+"<td>时间：</td>"
							+'<th class="p">'+formatDate(data.meetInfo[i].staTime)+' — '+formatDate(data.meetInfo[i].endTime)+'</th>'
							+"</tr>"
						)
					}
				}
			}
		})
	}
	//选中框
	function checkDiv(roomId) {
		romi += roomId + ','
		$("#" + roomId).css("border", "2px solid red")
		$("#" + roomId + "c").hide()
		$("#" + roomId + "d").show()
	}
	//取消选中框
	function RemoveCk(roomId) {
		romi = replaceAll(romi,roomId+',')
		$("#" + roomId).css("border", "0")
		$("#" + roomId + "c").show()
		$("#" + roomId + "d").hide()
	}
	//端口选中框
	function checkDK(roomId) {
		dkmi += roomId + ','
		$("#" + roomId).css("border", "2px solid red")
		$("#" + roomId + "c").hide()
		$("#" + roomId + "d").show()
	}
	//端口取消选中框
	function RemoveDK(roomId) {
		dkmi = replaceAll(dkmi,roomId+',')
		$("#" + roomId).css("border", "0")
		$("#" + roomId + "c").show()
		$("#" + roomId + "d").hide()
	}
	//判断会议时间是否是过去时间
	function checkTime(time1,time2){
		//console.log(time1.replace(/-/g,'/'))
		var timestamp1 = Date.parse(time1.replace(/-/g,'/'))
		var timestamp2 = Date.parse(time2)
		return timestamp1>timestamp2
	}
	//查看预订流程
	function applyFlow(){
		$('#showApplyFlow').window('open')
	}
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
	//根据时间返回可用视频会议室数
	function getKysphyss(staTime,endTime){
		$.ajax({
			url:'${ctx}/meet/getFreeRoomsAndDks/?staTime='+staTime+'&&endTime='+endTime,
			type:'get',
			async:false,
			dataType:'json',
			success:function(data){
				kysphyss = data
			}
		})
	}
	//查看我的申请
	function myApplyMeet(){
		window.open('${ctx}/meet/showMyApply')
	}
</script>
</head>
<body>
	<!-- header -->
	<div id='head' class='container-fluid'>
		<div class='row'>
			<div class='col-md-4'>
				<a href='${ctx}/meet/index' style='text-decoration: none;'> <span
					style='color: #FAFAFA'>爱旭 - 会议室预订系统</span></a>
			</div>
		</div>
	</div>

	<!-- body -->
	<div id='body' class='container'>
		<div class='row'>
			<div class='col-md-7'>
				<span style="color: #006666;">日期：</span> <input
					class="easyui-datebox" id="metdate" value=""
					data-options="editable:false" style="width: 100px; height: 30px;">
				<span style="color: #006666;">&nbsp;&nbsp;时间：</span> <select
					style="width: 70px; height: 30px"
					data-options="editable:false,panelHeight:250"
					class="easyui-combobox" id="statime">
					<option value=""> </option>
					<option value="08:30">08:30</option>
					<option value="09:00">09:00</option>
					<option value="09:30">09:30</option>
					<option value="10:00">10:00</option>
					<option value="10:30">10:30</option>
					<option value="11:00">11:00</option>
					<option value="11:30">11:30</option>
					<option value="12:00">12:00</option>
					<option value="12:30">12:30</option>
					<option value="13:00">13:00</option>
					<option value="13:30">13:30</option>
					<option value="14:00">14:00</option>
					<option value="14:30">14:30</option>
					<option value="15:00">15:00</option>
					<option value="15:30">15:30</option>
					<option value="16:00">16:00</option>
					<option value="16:30">16:30</option>
					<option value="17:00">17:00</option>
					<option value="17:30">17:30</option>
					<option value="18:00">18:00</option>
					<option value="18:30">18:30</option>
					<option value="19:00">19:00</option>
					<option value="19:30">19:30</option>
					<option value="20:00">20:00</option>
					<option value="20:30">20:30</option>
					<option value="21:00">21:00</option>
					<option value="21:30">21:30</option>
					<option value="22:00">22:00</option>
					<option value="22:30">22:30</option>
					<option value="23:00">23:00</option>
					<option value="23:30">23:30</option>
					<option value="00:00">00:00</option>
					<option value="00:30">00:30</option>
					<option value="01:00">01:00</option>
					<option value="01:30">01:30</option>
					<option value="02:00">02:00</option>
					<option value="02:30">02:30</option>
					<option value="03:00">03:00</option>
					<option value="03:30">03:30</option>
					<option value="04:00">04:00</option>
					<option value="04:30">04:30</option>
					<option value="05:00">05:00</option>
					<option value="05:30">05:30</option>
					<option value="06:00">06:00</option>
					<option value="06:30">06:30</option>
					<option value="07:00">07:00</option>
					<option value="07:30">07:30</option>
					<option value="08:00">08:00</option>
				</select> <span style="color: #006666;">&nbsp;至&nbsp;</span> <select
					style="width: 70px; height: 30px"
					data-options="editable:false,panelHeight:250"
					class="easyui-combobox" id="endtime">
					<option value=""> </option>
					<option value="08:30">08:30</option>
					<option value="09:00">09:00</option>
					<option value="09:30">09:30</option>
					<option value="10:00">10:00</option>
					<option value="10:30">10:30</option>
					<option value="11:00">11:00</option>
					<option value="11:30">11:30</option>
					<option value="12:00">12:00</option>
					<option value="12:30">12:30</option>
					<option value="13:00">13:00</option>
					<option value="13:30">13:30</option>
					<option value="14:00">14:00</option>
					<option value="14:30">14:30</option>
					<option value="15:00">15:00</option>
					<option value="15:30">15:30</option>
					<option value="16:00">16:00</option>
					<option value="16:30">16:30</option>
					<option value="17:00">17:00</option>
					<option value="17:30">17:30</option>
					<option value="18:00">18:00</option>
					<option value="18:30">18:30</option>
					<option value="19:00">19:00</option>
					<option value="19:30">19:30</option>
					<option value="20:00">20:00</option>
					<option value="20:30">20:30</option>
					<option value="21:00">21:00</option>
					<option value="21:30">21:30</option>
					<option value="22:00">22:00</option>
					<option value="22:30">22:30</option>
					<option value="23:00">23:00</option>
					<option value="23:30">23:30</option>
					<option value="00:00">00:00</option>
					<option value="00:30">00:30</option>
					<option value="01:00">01:00</option>
					<option value="01:30">01:30</option>
					<option value="02:00">02:00</option>
					<option value="02:30">02:30</option>
					<option value="03:00">03:00</option>
					<option value="03:30">03:30</option>
					<option value="04:00">04:00</option>
					<option value="04:30">04:30</option>
					<option value="05:00">05:00</option>
					<option value="05:30">05:30</option>
					<option value="06:00">06:00</option>
					<option value="06:30">06:30</option>
					<option value="07:00">07:00</option>
					<option value="07:30">07:30</option>
					<option value="08:00">08:00</option>
				</select> <span style="color: #006666;">&nbsp;&nbsp;&nbsp;&nbsp;视频会议：</span>
				<input style="width: 18px; height: 18px" type="radio" id="audiomeet"
					name="audiomeet" value="视频会议"> <span
					style="color: #006666;">是&nbsp;</span> <input
					style="width: 18px; height: 18px" type="radio" id="audiomeet"
					name="audiomeet" value="普通会议"> <span
					style="color: #006666;">否</span>
			</div>
			<div class='col-md-5'>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-search',plain:true" id="queryRoom"
					style="width: 80px; height: 35px; color: #006666;"
					onclick="queryRoom()">查询</a> <a
					style="width: 80px; height: 35px; color: #006666;" id="appMeet"
					onclick="applyMeet()" class="easyui-linkbutton"
					data-options="iconCls:'icon-add',plain:true">预订</a> <a
					style="width: 90px; height: 35px; color: #006666;" id='myApp'
					onclick="myApplyMeet()" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok',plain:true" target="_blank">我的申请</a>
				<a style="width: 90px; height: 35px; color: #006666;" id='ApplyRode'
					onclick="applyFlow()" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok',plain:true">预订流程</a>
			</div>
		</div>
		<div style='margin-top: 5px' class='row'>
			<div class='col-md-2 col-md-offset-1'>
				<span
					style='font-size: 20px; text-align: right; color: #006666; font-weight: bold'>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					广东爱旭</span>
			</div>
			<div class='col-md-2 col-md-offset-3'>
				<span
					style='font-size: 20px; text-align: center; color: #006666; font-weight: bold'>浙江爱旭</span>
			</div>
			<div class='col-md-2 col-md-offset-2'>
				<span
					style='font-size: 20px; text-align: center; color: #006666; font-weight: bold'>虚拟端口
				</span>
			</div>
		</div>
		<div style='margin-top: 5px' class='row'>
			<div style='border: 1px solid red' class='col-md-1'>1</div>
			<div style='border: 1px solid red' class='col-md-1'>1</div>
			<div style='border: 1px solid red' class='col-md-1'>1</div>
			<div style='border: 1px solid red' class='col-md-1'>1</div>
			<div style='border: 1px solid red' class='col-md-1'>1</div>
			<div style='border: 1px solid red' class='col-md-1'>1</div>
			<div style='border: 1px solid red' class='col-md-1'>1</div>
			<div style='border: 1px solid red' class='col-md-1'>1</div>
			<div style='border: 1px solid red' class='col-md-1'>1</div>
			<div style='border: 1px solid red' class='col-md-1'>1</div>
			<div style='border: 1px solid red' class='col-md-1'>1</div>
			<div style='border: 1px solid red' class='col-md-1'>1</div>
		</div>

		<div style='margin-top: 5px' class='row'>
			<div class='col-md-5'>
				<div id="aiko_1"
					style="float: left; width: 230px; height: 170px; background-color: #006666; border-radius: 20px;">
					<table style="width: 100%; text-align: center; font-size: 35px">
						<tr style="height: 40px">
							<td colspan="2"><img alt="视频会议"
								src="${ctx}/images/camera6.png" width=35px height=35px></td>
						</tr>
						<tr>
							<td style="color: white" colspan="2"><b>1-2F-1</b></td>
						</tr>
						<tr>
							<td>
								<div id="aiko_1a">
									<div id="aiko_1b" style="float: left">
										<a href="javascript:void(0)" class="easyui-linkbutton"
											data-options="iconCls:'icon-search',plain:true"
											style="width: 110px; height: 60px" id='queroom1'
											onclick="getRoomInfo('aiko_1')"></a>
									</div>
									<div id="aiko_1c" style="float: right">
										<a href="javascript:void(0)" class="easyui-linkbutton"
											data-options="iconCls:'icon-ok',plain:true"
											style="width: 110px; height: 60px" id='selectroom1'
											onclick="checkDiv('aiko_1')"></a>
									</div>
								</div>
								<div id="aiko_1d" style="float: right">
									<a href="javascript:void(0)" class="easyui-linkbutton"
										data-options="iconCls:'icon-ok',plain:true"
										style="width: 110px; height: 60px" id='disecroom1'
										onclick="RemoveCk('aiko_1')"></a>
								</div>
							</td>
						</tr>
					</table>
				</div>

				<div id="aiko_2"
					style="float:right;width: 180px; height: 170px; background-color: #006666; border-radius: 15px;">
					<table style="width: 100%; text-align: center; font-size: 30px">
						<tr style="height: 20px"></tr>
						<tr>
							<td style="color: white" colspan="3"><b>1-1F-1</b></td>
						</tr>
						<tr style="height: 10px"></tr>
						<tr>
							<td>
								<div id="aiko_2a">
									<div id="aiko_2b" style="float: left">
										<a href="javascript:void(0)" class="easyui-linkbutton"
											data-options="iconCls:'icon-search',plain:true"
											style="width: 85px; height: 75px" id='queroom2'
											onclick="getRoomInfo('aiko_2')"></a>
									</div>
									<div id="aiko_2c" style="float: right">
										<a href="javascript:void(0)" class="easyui-linkbutton"
											data-options="iconCls:'icon-ok',plain:true"
											style="width: 85px; height: 75px" id='selectroom2'
											onclick="checkDiv('aiko_2')"></a>
									</div>
								</div>
								<div id="aiko_2d" style="float: right">
									<a href="javascript:void(0)" class="easyui-linkbutton"
										data-options="iconCls:'icon-ok',plain:true"
										style="width: 85px; height: 75px" id='disecroom2'
										onclick="RemoveCk('aiko_2')"></a>
								</div>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>