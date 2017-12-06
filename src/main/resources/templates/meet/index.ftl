<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<base id="ctx" href="${ctx}">
<title>爱旭-会议室预订</title>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">   
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<link rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/icon.css">
<script type="text/javascript" src="${ctx}/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/easyui/locale/easyui-lang-zh_CN.js"></script>
<style type="text/css">
.p {
	font-size: 18px;
}
</style>
<script>
var x = true
//可预订视频会议数
var kysph = 1
//可用视频会议室数
var kysphyss = 0
//不可用会议室号
var akNoAudioMeetRoom=new Array("aiko_2","aiko_4","aiko_5","aiko_6","aiko_8","aiko_10","aiko_12")
var axNoAudioMeetRoom=new Array("aixu_5","aixu_6","aixu_7","aixu_8","aixu_11","aixu_12","aixu_14","aixu_15")
var romi = ''
var dkmi = ''

	//页面加载启动
	$(function() {
		
		//判断跳转
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
			//window.location.href= '${ctx}/meet/index';
		} else {
			window.location.href = '${ctx}/mobile';
		}
		
		//判断IE
		if(navigator.appName == "Microsoft Internet Explorer"&& 
				(navigator.appVersion .split(";")[1].replace(/[ ]/g,"")=="MSIE6.0" 
				|| navigator.appName == "Microsoft Internet Explorer" 
				&& navigator.appVersion .split(";")[1].replace(/[ ]/g,"")=="MSIE7.0" 
				|| navigator.appName == "Microsoft Internet Explorer" 
				&& navigator.appVersion .split(";")[1].replace(/[ ]/g,"")=="MSIE8.0" 
				|| navigator.appName == "Microsoft Internet Explorer" 
				&& navigator.appVersion .split(";")[1].replace(/[ ]/g,"")=="MSIE9.0")){
			$.messager.alert('消息提示',"您的浏览器版本过低，请下载IE10及以上版本或者更换其他浏览器访问本站");
		}
		
		//遮盖未开放的会议室div层
		//$.messager.alert("",checkTime(x1,new Date()))
		$("#metdate").datebox().datebox('calendar').calendar({ validator:function(day){ return (day > new Date()-86400000)&&(new Date() > day-86400000*7); } })
		
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
			$("#aiko_" + i).css("background-color", "#4b5f7b")
			$("#aiko_" + i + "c").show()
		}
		for (var i = 1; i < 17; i++) {
			$("#aixu_" + i).css("background-color", "#4b5f7b")
			$("#aixu_" + i + "c").show()
		}
		for (var i = 1; i < 11; i++) {
			$("#dk_" + i).css("background-color", "#4b5f7b")
			$("#dk_" + i + "c").show()
		}
	}
	
	//查询会议室
	function queryRoom() {
		var st = $('#metdate').datebox('getValue')+' '+$("#statime").val()+':00'
		var et = $('#metdate').datebox('getValue')+' '+$("#endtime").val()+':00'
		var am = $("input:radio[name='audiomeet']:checked").val()
		if($('#metdate').datebox('getValue')!='' && $("#statime").val()!='' && $("#endtime").val()!=''){
			getKysphm(st,et)		//视频会议号
		}
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
		}else if(am=='视频会议' && kysph==0){
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
					$("#"+akNoAudioMeetRoom[i]).css("background-color", "#4b5f7b")
				}
				for(var i=0; i<axNoAudioMeetRoom.length; i++){
					$("#"+axNoAudioMeetRoom[i]).css("background-color", "#4b5f7b")
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
			$('#appMeet').linkbutton('enable')	//打开预订按钮
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
			$.messager.alert('消息提示','虚拟终端不支持普通会议，请检查选择！')
		}else if(am=='视频会议' && kysph==0){
			$.messager.alert('消息提示','该时间段视频会议预订已达上限，请换个时间段吧')
		}else if(am=='视频会议' && roms.length+kysphyss>10){
			$.messager.alert('消息提示','该时间段视频会议室预订已达上限，请减少会议室数或换个时间段吧')
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
							+"<td>预订人：</td>"
							+'<th class="p">'+data.meetInfo[i].resFour+'</th>'
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
			cache:false,
			success:function(data){
                kysph = data
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
			cache:false,
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
<body class="easyui-layout,fit:true">
	<!-- 总 -->
	<div class="easyui-layout,fit:true" style="width: 100%; height: 680px;">
		<!-- 主页面 -->
		<div data-options="region:'center'">
			<!-- 查询栏 -->
			<div style="border-radius:3px;padding-left:40px;padding-top:10px;padding-bottom:10px;width: 98%; height: 7%; background-color: #4b5f7b;">
				<span style="font-size: 15px; font-weight:bold; color: white;">会议日期：</span>
				<span><input class="easyui-datebox" id="metdate" value=""
							data-options="editable:false" style="width: 100px; height: 30px;"></span>
				<span style="font-size: 15px; font-weight:bold; color: white;">&nbsp;&nbsp;时间段：</span>
				<span><select style="width: 70px; height: 30px"
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
						</select></span>
				<span><span style="font-size: 15px; font-weight:bold; color: white;">&nbsp;至&nbsp;</span></span>
				<span><select style="width: 70px; height: 30px"
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
						</select></span>
				<span><span style="font-size: 15px; font-weight:bold; color: white;">&nbsp;&nbsp;视频会议：</span></span>
				<span><input style="width: 18px; height: 18px" type="radio"
							id="audiomeet" name="audiomeet" value="视频会议"></span> 
				<span style="font-size: 15px; font-weight:bold; color: white;">是</span>
				<span><input style="width: 18px; height: 18px" type="radio"
							id="audiomeet" name="audiomeet" value="普通会议"> </span>
				<span style="font-size: 15px; font-weight:bold; color: white;">否</span>
				<span>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="javascript:void(0)" class="easyui-linkbutton"
							data-options="iconCls:'icon-search',plain:true" id="queryRoom"
							style="width: 80px; height: 40px;font-weight:bold; color: white;"
							onclick="queryRoom()">查询</a></span>
				<span><a style="width: 80px; height: 40px; font-weight:bold; color: white;"
							id="appMeet" onclick="applyMeet()" class="easyui-linkbutton"
							data-options="iconCls:'icon-add',plain:true">提交</a></span>
				<!-- <span><a style="width: 90px; height: 40px; 
							font-size: 20px; color: white; font-weight: bold;"
							id='ApplyRode' onclick="applyFlow()" class="easyui-linkbutton"
							data-options="plain:true">预订流程</a>
				</span> -->
			</div>
			<!-- 会议室信息栏 -->
			<div
				style="margin: 0 auto;width: 99%; height: 83%;">
				<!-- 左 -->
				<div
					style="width: 80%; height: 100%; float: left; background-color: #FFFFFF;">
					<!-- 左-左 -->
					<div
						style="width: 42%; height: 100%; float: left; background-color: #FFFFFF;">
						<div
							style="width: 100%; height: 35px; background-color: #FFFFFF; margin: 3px 0 0 0">
							<table style="width: 100%; text-align: center; font-size: 20px">
								<tr>
									<td style='color: #4b5f7b; font-weight: bold' colspan="3">广东爱旭</td>
								</tr>
								<tr style="height: 5px"></tr>
								<!-- 一排 -->
								<tr>
									<td colspan="2">
										<div id="aiko_1"
											style="width: 230px; height: 170px; background-color: #4b5f7b; border-radius: 20px;">
											<table
												style="width: 100%; text-align: center; font-size: 30px">
												<tr style="height: 40px">
													<td colspan="2"><img alt="视频会议"
														src="${ctx}/images/camera6.png" width=35px height=30px>
													</td>
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
																	style="width: 110px; height: 70px" id='queroom1'
																	onclick="getRoomInfo('aiko_1')"></a>
															</div>
															<div id="aiko_1c" style="float: right">
																<a href="javascript:void(0)" class="easyui-linkbutton"
																	data-options="iconCls:'icon-ok',plain:true"
																	style="width: 110px; height: 70px" id='selectroom1'
																	onclick="checkDiv('aiko_1')"></a>
															</div>
														</div>
														<div id="aiko_1d" style="float: right">
															<a href="javascript:void(0)" class="easyui-linkbutton"
																data-options="iconCls:'icon-ok',plain:true"
																style="width: 110px; height: 70px" id='disecroom1'
																onclick="RemoveCk('aiko_1')"></a>
														</div>
													</td>
												</tr>
											</table>
										</div>
									</td>
									<td>
										<div id="aiko_2"
											style="width: 180px; height: 170px; background-color: #4b5f7b; border-radius: 15px;">
											<table
												style="width: 100%; text-align: center; font-size: 30px">
												<tr style="height: 40px"></tr>
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
																	style="width: 85px; height: 65px" id='queroom2'
																	onclick="getRoomInfo('aiko_2')"></a>
															</div>
															<div id="aiko_2c" style="float: right">
																<a href="javascript:void(0)" class="easyui-linkbutton"
																	data-options="iconCls:'icon-ok',plain:true"
																	style="width: 85px; height: 65px" id='selectroom2'
																	onclick="checkDiv('aiko_2')"></a>
															</div>
														</div>
														<div id="aiko_2d" style="float: right">
															<a href="javascript:void(0)" class="easyui-linkbutton"
																data-options="iconCls:'icon-ok',plain:true"
																style="width: 85px; height: 65px" id='disecroom2'
																onclick="RemoveCk('aiko_2')"></a>
														</div>
													</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
								<!-- 二排 -->
								<tr>
									<td colspan="2">
										<div id="aiko_4"
											style="width: 230px; height: 140px; background-color: #4b5f7b; border-radius: 15px;">
											<table
												style="width: 100%; text-align: center; font-size: 30px">
												<tr height=35px></tr>
												<tr>
													<td style="color: white" colspan="2"><b>1-1F-2</b></td>
												</tr>
												<tr>
													<td>
														<div id="aiko_4a">
															<div id="aiko_4b" style="float: left">
																<a href="javascript:void(0)" class="easyui-linkbutton"
																	data-options="iconCls:'icon-search',plain:true"
																	style="width: 110px; height: 55px" id='queroom3'
																	onclick="getRoomInfo('aiko_4')"></a>
															</div>
															<div id="aiko_4c" style="float: right">
																<a href="javascript:void(0)" class="easyui-linkbutton"
																	data-options="iconCls:'icon-ok',plain:true"
																	style="width: 110px; height: 55px" id='selectroom3'
																	onclick="checkDiv('aiko_4')"></a>
															</div>
														</div>
														<div id="aiko_4d" style="float: right">
															<a href="javascript:void(0)" class="easyui-linkbutton"
																data-options="iconCls:'icon-ok',plain:true"
																style="width: 110px; height: 55px" id='disecroom3'
																onclick="RemoveCk('aiko_4')"></a>
														</div>
													</td>
												</tr>
											</table>
										</div>
									</td>
									<td>
										<div id="aiko_3"
											style="width: 180px; height: 140px; background-color: #4b5f7b; border-radius: 15px;">
											<table
												style="width: 100%; text-align: center; font-size: 30px">
												<tr style="height: 30px">
													<td colspan="2"><img alt="视频会议"
														src="${ctx}/images/camera6.png" width=30px height=30px>
													</td>
												</tr>
												<tr>
													<td style="color: white" colspan="3"><b>1-2F-2</b></td>
												</tr>
												<tr>
													<td>
														<div id="aiko_3a">
															<div id="aiko_3b" style="float: left">
																<a href="javascript:void(0)" class="easyui-linkbutton"
																	data-options="iconCls:'icon-search',plain:true"
																	style="width: 85px; height: 45px" id='queroom4'
																	onclick="getRoomInfo('aiko_3')"></a>
															</div>
															<div id="aiko_3c" style="float: right">
																<a href="javascript:void(0)" class="easyui-linkbutton"
																	data-options="iconCls:'icon-ok',plain:true"
																	style="width: 85px; height: 45px" id='selectroom4'
																	onclick="checkDiv('aiko_3')"></a>
															</div>
														</div>
														<div id="aiko_3d" style="float: right">
															<a href="javascript:void(0)" class="easyui-linkbutton"
																data-options="iconCls:'icon-ok',plain:true"
																style="width: 85px; height: 45px" id='disecroom4'
																onclick="RemoveCk('aiko_3')"></a>
														</div>
													</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
								<tr>
									<td colspan='2'>
										<div id="aiko_5"
											style="width: 230px; height: 150px; background-color: #4b5f7b; border-radius: 15px;">
											<table
												style="width: 100%; text-align: center; font-size: 30px">
												<tr style="height: 35px">
												</tr>
												<tr>
													<td style="color: white" colspan="3"><b>2-1F-1</b></td>
												</tr>
												<tr>
													<td>
														<div id="aiko_5a">
															<div id="aiko_5b" style="float: left">
																<a href="javascript:void(0)" class="easyui-linkbutton"
																	data-options="iconCls:'icon-search',plain:true"
																	style="width: 110px; height:65px" id='queroom5'
																	onclick="getRoomInfo('aiko_5')"></a>
															</div>
															<div id="aiko_5c" style="float: right">
																<a href="javascript:void(0)" class="easyui-linkbutton"
																	data-options="iconCls:'icon-ok',plain:true"
																	style="width: 110px; height: 65px" id='selectroom5'
																	onclick="checkDiv('aiko_5')"></a>
															</div>
														</div>
														<div id="aiko_5d" style="float: right">
															<a href="javascript:void(0)" class="easyui-linkbutton"
																data-options="iconCls:'icon-ok',plain:true"
																style="width: 110px; height: 65px" id='disecroom5'
																onclick="RemoveCk('aiko_5')"></a>
														</div>
													</td>
												</tr>
											</table>
										</div>
									</td>
									<td>
										<div id="aiko_12"
											style="width: 180px; height: 150px; background-color: #4b5f7b; border-radius: 15px;">
											<table
												style="width: 100%; text-align: center; font-size: 30px">
												<tr style="height: 35px">
												</tr>
												<tr>
													<td style="color: white" colspan="3"><b>2-2F-PX</b></td>
												</tr>
												<tr>
													<td>
														<div id="aiko_12a">
															<div id="aiko_12b" style="float: left">
																<a href="javascript:void(0)" class="easyui-linkbutton"
																	data-options="iconCls:'icon-search',plain:true"
																	style="width: 85px; height:65px" id='queroom12'
																	onclick="getRoomInfo('aiko_12')"></a>
															</div>
															<div id="aiko_12c" style="float: right">
																<a href="javascript:void(0)" class="easyui-linkbutton"
																	data-options="iconCls:'icon-ok',plain:true"
																	style="width: 85px; height: 65px" id='selectroom12'
																	onclick="checkDiv('aiko_12')"></a>
															</div>
														</div>
														<div id="aiko_12d" style="float: right">
															<a href="javascript:void(0)" class="easyui-linkbutton"
																data-options="iconCls:'icon-ok',plain:true"
																style="width: 85px; height: 65px" id='disecroom12'
																onclick="RemoveCk('aiko_12')"></a>
														</div>
													</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
								<tr>
								<td colspan="2">
										<div id="aiko_11"
											style="width: 230px; height: 150px; background-color: #4b5f7b; border-radius: 20px;">
											<table
												style="width: 100%; text-align: center; font-size: 25px">
												<tr style="height: 30px">
													<td colspan="2"><img alt="视频会议"
														src="${ctx}/images/camera6.png" width=30px height=30px>
													</td>
												</tr>
												<tr>
													<td style="color: white" colspan="2"><b>陈董办公室</b></td>
												</tr>
												<tr>
													<td>
														<div id="aiko_11a">
															<div id="aiko_11b" style="float: left">
																<a href="javascript:void(0)" class="easyui-linkbutton"
																	data-options="iconCls:'icon-search',plain:true"
																	style="width: 110px; height: 63px" id='queroom11'
																	onclick="getRoomInfo('aiko_11')"></a>
															</div>
															<div id="aiko_11c" style="float: right">
																<a href="javascript:void(0)" class="easyui-linkbutton"
																	data-options="iconCls:'icon-ok',plain:true"
																	style="width: 110px; height: 63px" id='selectroom11'
																	onclick="checkDiv('aiko_11')"></a>
															</div>
														</div>
														<div id="aiko_11d" style="float: right">
															<a href="javascript:void(0)" class="easyui-linkbutton"
																data-options="iconCls:'icon-ok',plain:true"
																style="width: 110px; height: 63px" id='disecroom11'
																onclick="RemoveCk('aiko_11')"></a>
														</div>
													</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
							</table>
						</div>
					</div>
					<!-- 左-右 -->
					<div
						style="width: 52%; height: 100%; float: right; background-color: #FFFFFF;">
						<div
							style="width: 100%; height: 35px; background-color: #FFFFFF; margin: 3px 0 0 0">
							<table style="width: 100%; text-align: center; font-size: 20px">
								<tr>
									<td style='color: #4b5f7b; font-weight: bold' colspan="4">浙江爱旭</td>
								</tr>
								<tr style="height: 5px"></tr>
								<!-- 一排 -->
								<tr>
									<td width=25px></td>
									<td>
										<div id="aixu_1"
											style="width: 240px; height: 170px; background-color: #4b5f7b; border-radius: 20px;">
											<table
												style="width: 100%; text-align: center; font-size: 35px">
												<tr style="height: 40px">
													<td colspan="2"><img alt="视频会议"
														src="${ctx}/images/camera6.png" width=35px height=35px>
													</td>
												</tr>
												<tr>
													<td style="color: white" colspan="2"><b>1#</b></td>
												</tr>
												<tr>
													<td>
														<div id="aixu_1a">
															<div id="aixu_1b" style="float: left">
																<a href="javascript:void(0)" class="easyui-linkbutton"
																	data-options="iconCls:'icon-search',plain:true"
																	style="width: 115px; height: 60px" id='queroom13'
																	onclick="getRoomInfo('aixu_1')"></a>
															</div>
															<div id="aixu_1c" style="float: right">
																<a href="javascript:void(0)" class="easyui-linkbutton"
																	data-options="iconCls:'icon-ok',plain:true"
																	style="width: 115px; height: 60px" id='selectroom13'
																	onclick="checkDiv('aixu_1')"></a>
															</div>
														</div>
														<div id="aixu_1d" style="float: right">
															<a href="javascript:void(0)" class="easyui-linkbutton"
																data-options="iconCls:'icon-ok',plain:true"
																style="width: 115px; height: 60px" id='disecroom13'
																onclick="RemoveCk('aixu_1')"></a>
														</div>
													</td>
												</tr>
											</table>
										</div>
									</td>
									<td colspan="2">
										<div id="aixu_2"
											style="width: 240px; height: 170px; background-color: #4b5f7b; border-radius: 20px;">
											<table
												style="width: 100%; text-align: center; font-size: 35px">
												<tr style="height: 40px">
													<td colspan="2"><img alt="视频会议"
														src="${ctx}/images/camera6.png" width=35px height=35px>
													</td>
												</tr>
												<tr>
													<td style="color: white" colspan="3"><b>2#</b></td>
												</tr>
												<tr>
													<td>
														<div id="aixu_2a">
															<div id="aixu_2b" style="float: left">
																<a href="javascript:void(0)" class="easyui-linkbutton"
																	data-options="iconCls:'icon-search',plain:true"
																	style="width: 115px; height: 60px" id='queroom14'
																	onclick="getRoomInfo('aixu_2')"></a>
															</div>
															<div id="aixu_2c" style="float: right">
																<a href="javascript:void(0)" class="easyui-linkbutton"
																	data-options="iconCls:'icon-ok',plain:true"
																	style="width: 115px; height: 60px" id='selectroom14'
																	onclick="checkDiv('aixu_2')"></a>
															</div>
														</div>
														<div id="aixu_2d" style="float: right">
															<a href="javascript:void(0)" class="easyui-linkbutton"
																data-options="iconCls:'icon-ok',plain:true"
																style="width: 115px; height: 60px" id='disecroom14'
																onclick="RemoveCk('aixu_2')"></a>
														</div>
													</td>
												</tr>
											</table>
										</div>
									</td>
									<td width=35px></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<!-- 右 -->
				<div
					style="width: 16%; height: 100%; text-align: center; float: right; background-color: #FFFFFF;">
					<div
						style="width: 100%; height: 35px; background-color: #FFFFFF; margin: 3px 0 0 0">
						<table style="width: 100%; text-align: center; font-size: 20px">
							<tr>
								<td style='color: #4b5f7b; font-weight: bold'>虚拟终端</td>
							</tr>
							<tr style="height: 5px"></tr>
							<!-- 一排 -->
							<tr>
								<td>
									<div id="dk_1"
										style="width: 180px; height: 48px; background-color: #4b5f7b; border-radius: 15px;">
										<table
											style="align: center; width: 100%; text-align: center; font-size: 20px">
											<tr style="height: 10px">
											</tr>
											<tr>
												<td>
													<div id="dk_1a" style="float: left">
														<a href="javascript:void(0)" class="easyui-linkbutton"
															style="width: 60px; height: 30px" id='queroom26'
															data-options="iconCls:'icon-search',plain:true"
															onclick="getRoomInfo('dk_1')"></a>
													</div>
												<td style="color: white"><b>6001</b></td>
												<td>
													<div id="dk_1b">
														<div id="dk_1c" style="float: right">
															<a href="javascript:void(0)" class="easyui-linkbutton"
																style="width: 60px; height: 30px" id='selectroom26'
																data-options="iconCls:'icon-ok',plain:true"
																onclick="checkDK('dk_1')"></a>
														</div>
													</div>
													<div id="dk_1d" style="float: right">
														<a href="javascript:void(0)" class="easyui-linkbutton"
															style="width: 60px; height: 30px" id='disecroom26'
															data-options="iconCls:'icon-ok',plain:true"
															onclick="RemoveDK('dk_1')"></a>
													</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div id="dk_2"
										style="width: 180px; height: 48px; background-color: #4b5f7b; border-radius: 15px;">
										<table
											style="align: center; width: 100%; text-align: center; font-size: 20px">
											<tr style="height: 10px">
											</tr>
											<tr>
												<td>
													<div id="dk_2a" style="float: left">
														<a href="javascript:void(0)" class="easyui-linkbutton"
															style="width: 60px; height: 30px" id='queroom27'
															data-options="iconCls:'icon-search',plain:true"
															onclick="getRoomInfo('dk_2')"></a>
													</div>
												<td style="color: white"><b>6002</b></td>
												<td>
													<div id="dk_2b">
														<div id="dk_2c" style="float: right">
															<a href="javascript:void(0)" class="easyui-linkbutton"
																style="width: 60px; height: 30px" id='selectroom27'
																data-options="iconCls:'icon-ok',plain:true"
																onclick="checkDK('dk_2')"></a>
														</div>
													</div>
													<div id="dk_2d" style="float: right">
														<a href="javascript:void(0)" class="easyui-linkbutton"
															style="width: 60px; height: 30px" id='disecroom27'
															data-options="iconCls:'icon-ok',plain:true"
															onclick="RemoveDK('dk_2')"></a>
													</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
							<!-- 二排 -->
							<tr>
								<td>
									<div id="dk_3"
										style="width: 180px; height: 48px; background-color: #4b5f7b; border-radius: 15px;">
										<table
											style="align: center; width: 100%; text-align: center; font-size: 20px">
											<tr style="height: 10px">
											</tr>
											<tr>
												<td>
													<div id="dk_3a" style="float: left">
														<a href="javascript:void(0)" class="easyui-linkbutton"
															style="width: 60px; height: 30px" id='queroom28'
															data-options="iconCls:'icon-search',plain:true"
															onclick="getRoomInfo('dk_3')"></a>
													</div>
												<td style="color: white"><b>6003</b></td>
												<td>
													<div id="dk_3b">
														<div id="dk_3c" style="float: right">
															<a href="javascript:void(0)" class="easyui-linkbutton"
																style="width: 60px; height: 30px" id='selectroom28'
																data-options="iconCls:'icon-ok',plain:true"
																onclick="checkDK('dk_3')"></a>
														</div>
													</div>
													<div id="dk_3d" style="float: right">
														<a href="javascript:void(0)" class="easyui-linkbutton"
															style="width: 60px; height: 30px" id='disecroom28'
															data-options="iconCls:'icon-ok',plain:true"
															onclick="RemoveDK('dk_3')"></a>
													</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div id="dk_4"
										style="width: 180px; height: 48px; background-color: #4b5f7b; border-radius: 15px;">
										<table
											style="align: center; width: 100%; text-align: center; font-size: 20px">
											<tr style="height: 10px">
											</tr>
											<tr>
												<td>
													<div id="dk_4a" style="float: left">
														<a href="javascript:void(0)" class="easyui-linkbutton"
															style="width: 60px; height: 30px" id='queroom29'
															data-options="iconCls:'icon-search',plain:true"
															onclick="getRoomInfo('dk_4')"></a>
													</div>
												<td style="color: white"><b>6004</b></td>
												<td>
													<div id="dk_4b">
														<div id="dk_4c" style="float: right">
															<a href="javascript:void(0)" class="easyui-linkbutton"
																style="width: 60px; height: 30px" id='selectroom29'
																data-options="iconCls:'icon-ok',plain:true"
																onclick="checkDK('dk_4')"></a>
														</div>
													</div>
													<div id="dk_4d" style="float: right">
														<a href="javascript:void(0)" class="easyui-linkbutton"
															style="width: 60px; height: 30px" id='disecroom29'
															data-options="iconCls:'icon-ok',plain:true"
															onclick="RemoveDK('dk_4')"></a>
													</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
							<!-- 三排 -->
							<tr>
								<td>
									<div id="dk_5"
										style="width: 180px; height: 48px; background-color: #4b5f7b; border-radius: 15px;">
										<table
											style="align: center; width: 100%; text-align: center; font-size: 20px">
											<tr style="height: 10px">
											</tr>
											<tr>
												<td>
													<div id="dk_5a" style="float: left">
														<a href="javascript:void(0)" class="easyui-linkbutton"
															style="width: 60px; height: 30px" id='queroom30'
															data-options="iconCls:'icon-search',plain:true"
															onclick="getRoomInfo('dk_5')"></a>
													</div>
												<td style="color: white"><b>6005</b></td>
												<td>
													<div id="dk_5b">
														<div id="dk_5c" style="float: right">
															<a href="javascript:void(0)" class="easyui-linkbutton"
																style="width: 60px; height: 30px" id='selectroom30'
																data-options="iconCls:'icon-ok',plain:true"
																onclick="checkDK('dk_5')"></a>
														</div>
													</div>
													<div id="dk_5d" style="float: right">
														<a href="javascript:void(0)" class="easyui-linkbutton"
															style="width: 60px; height: 30px" id='disecroom30'
															data-options="iconCls:'icon-ok',plain:true"
															onclick="RemoveDK('dk_5')"></a>
													</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div id="dk_6"
										style="width: 180px; height: 48px; background-color: #4b5f7b; border-radius: 15px;">
										<table
											style="align: center; width: 100%; text-align: center; font-size: 20px">
											<tr style="height: 10px">
											</tr>
											<tr>
												<td>
													<div id="dk_6a" style="float: left">
														<a href="javascript:void(0)" class="easyui-linkbutton"
															style="width: 60px; height: 30px" id='queroom31'
															data-options="iconCls:'icon-search',plain:true"
															onclick="getRoomInfo('dk_6')"></a>
													</div>
												<td style="color: white"><b>6006</b></td>
												<td>
													<div id="dk_6b">
														<div id="dk_6c" style="float: right">
															<a href="javascript:void(0)" class="easyui-linkbutton"
																style="width: 60px; height: 30px" id='selectroom31'
																data-options="iconCls:'icon-ok',plain:true"
																onclick="checkDK('dk_6')"></a>
														</div>
													</div>
													<div id="dk_6d" style="float: right">
														<a href="javascript:void(0)" class="easyui-linkbutton"
															style="width: 60px; height: 30px" id='disecroom31'
															data-options="iconCls:'icon-ok',plain:true"
															onclick="RemoveDK('dk_6')"></a>
													</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
							<!-- 四排 -->
							<tr>
								<td>
									<div id="dk_7"
										style="width: 180px; height: 48px; background-color: #4b5f7b; border-radius: 15px;">
										<table
											style="align: center; width: 100%; text-align: center; font-size: 20px">
											<tr style="height: 10px">
											</tr>
											<tr>
												<td>
													<div id="dk_7a" style="float: left">
														<a href="javascript:void(0)" class="easyui-linkbutton"
															style="width: 60px; height: 30px" id='queroom32'
															data-options="iconCls:'icon-search',plain:true"
															onclick="getRoomInfo('dk_7')"></a>
													</div>
												<td style="color: white"><b>6007</b></td>
												<td>
													<div id="dk_7b">
														<div id="dk_7c" style="float: right">
															<a href="javascript:void(0)" class="easyui-linkbutton"
																style="width: 60px; height: 30px" id='selectroom32'
																data-options="iconCls:'icon-ok',plain:true"
																onclick="checkDK('dk_7')"></a>
														</div>
													</div>
													<div id="dk_7d" style="float: right">
														<a href="javascript:void(0)" class="easyui-linkbutton"
															style="width: 60px; height: 30px" id='disecroom32'
															data-options="iconCls:'icon-ok',plain:true"
															onclick="RemoveDK('dk_7')"></a>
													</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div id="dk_8"
										style="width: 180px; height: 48px; background-color: #4b5f7b; border-radius: 15px;">
										<table
											style="align: center; width: 100%; text-align: center; font-size: 20px">
											<tr style="height: 10px">
											</tr>
											<tr>
												<td>
													<div id="dk_8a" style="float: left">
														<a href="javascript:void(0)" class="easyui-linkbutton"
															style="width: 60px; height: 30px" id='queroom33'
															data-options="iconCls:'icon-search',plain:true"
															onclick="getRoomInfo('dk_8')"></a>
													</div>
												<td style="color: white"><b>6008</b></td>
												<td>
													<div id="dk_8b">
														<div id="dk_8c" style="float: right">
															<a href="javascript:void(0)" class="easyui-linkbutton"
																style="width: 60px; height: 30px" id='selectroom33'
																data-options="iconCls:'icon-ok',plain:true"
																onclick="checkDK('dk_8')"></a>
														</div>
													</div>
													<div id="dk_8d" style="float: right">
														<a href="javascript:void(0)" class="easyui-linkbutton"
															style="width: 60px; height: 30px" id='disecroom33'
															data-options="iconCls:'icon-ok',plain:true"
															onclick="RemoveDK('dk_8')"></a>
													</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
							<!-- 五排 -->
							<tr>
								<td>
									<div id="dk_9"
										style="width: 180px; height: 48px; background-color: #4b5f7b; border-radius: 15px;">
										<table
											style="align: center; width: 100%; text-align: center; font-size: 20px">
											<tr style="height: 10px">
											</tr>
											<tr>
												<td>
													<div id="dk_9a" style="float: left">
														<a href="javascript:void(0)" class="easyui-linkbutton"
															style="width: 60px; height: 30px" id='queroom34'
															data-options="iconCls:'icon-search',plain:true"
															onclick="getRoomInfo('dk_9')"></a>
													</div>
												<td style="color: white"><b>6009</b></td>
												<td>
													<div id="dk_9b">
														<div id="dk_9c" style="float: right">
															<a href="javascript:void(0)" class="easyui-linkbutton"
																style="width: 60px; height: 30px" id='selectroom34'
																data-options="iconCls:'icon-ok',plain:true"
																onclick="checkDK('dk_9')"></a>
														</div>
													</div>
													<div id="dk_9d" style="float: right">
														<a href="javascript:void(0)" class="easyui-linkbutton"
															style="width: 60px; height: 30px" id='disecroom34'
															data-options="iconCls:'icon-ok',plain:true"
															onclick="RemoveDK('dk_9')"></a>
													</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="roomInfo" class="easyui-window" title="会议室详情"
		data-options="modal:true,closed:true,iconCls:'icon-save'"
		style="width: 830px; height: 400px;">
		<table style='width: 100%; font-size: 15px; text-align: left;'
			id='roomInfot'>
		</table>
		<table style='width: 100%; font-size: 15px; text-align: left'
			id='meetInfot'>
		</table>
	</div>
	<div id="showApplyFlow" class="easyui-window" title="预订流程"
		data-options="modal:true,closed:true,iconCls:'icon-save'"
		style="width: 400px; height: 200px;">
		<table style='width: 100%; font-size: 15px; text-align: left;'
			id='appLyFlowT'>
			<tr height=40px>
				<td>&nbsp;&nbsp;&nbsp;&nbsp; 1.选择会议日期时间，查询会议室占用情况（灰色为已被预订或不可用）</td>
			</tr>
			<tr height=40px>
				<td>&nbsp;&nbsp;&nbsp;&nbsp; 2.选中可预订会议室点击预订</td>
			</tr>
			<tr height=40px>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;
					注：选择日期之后点击会议室上面的查询按钮可查看该会议室的预订信息，卡顿可刷新页面</td>
			</tr>
		</table>
	</div>
	
	
	<!--[if lt IE 8]>
	<script src="https://cdn.bootcss.com/ie8/0.7.1/ie8.js"></script>
	<![endif]-->
	<!--[if lt IE 9]>
	<script src="https://cdn.bootcss.com/ie8/0.7.1/ie8.js"></script>
	<![endif]-->
</body>
</html>