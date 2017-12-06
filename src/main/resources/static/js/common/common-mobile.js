// 全局变量
var number = 1
// 已占用视频会议室数
var kysphyss
// 已占用端口号数组
var xunisAlready = new Array()

//通用函数：获取当前项目路径
function propath () {
	// 获取项目路径信息
	var curWwwPath = window.document.location.href
	var pathName = window.document.location.pathname
	var pos = curWwwPath.indexOf(pathName)
	var localhostPath = curWwwPath.substring(0, pos)
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1)
	return localhostPath + projectName
}

// 判断开始于结束时间
function judgeTime (statime, endtime) {
	var s1 = statime.replace(/T/, " ")
	var e1 = endtime.replace(/T/, " ")
	s1 = s1.replace(/-/g, "/")
	e1 = e1.replace(/-/g, "/")
	var date1 = new Date(s1)
	var date2 = new Date(e1)
	return date1.getTime() - date2.getTime()
}
//日期转换工具
	Date.prototype.format = function (format) {
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

// 格式化年月日时分秒
function formatDateModi(value){
	var unixTimestamp = new Date(value); 
	return unixTimestamp.format("yyyy-MM-dd hh:mm:ss"); 
}
	
// ajax查询
$(function() {
	
	// 加载提示
	alert('预订前请先查询，请点击左上角')
	
	// 加载时按钮不可点击
	$('.base').each(function () {
		$(this).find('button[name="pick"]').removeClass('am-icon-check').addClass('am-icon-lock').attr('disabled', true)
	})
	
	// 测试checkBox
	$('#isvideo').on('switchChange.bootstrapSwitch',function (event, state) {
		if (state) {
			$('#isvideohidden').val('视频会议')
			// 重置默认
			$('.xuni').each(function () {
				$(this).css('background', '#009CDA').find('button[name="pick"]').attr('disabled',false).html('选择这个')
			})
			// 不充值占用的
			for (var i = 0; i < xunisAlready.length; i++) {
				$('#'+xunisAlready[i]).css('background', '#DCDCDC').removeClass("selected").find('button[name="pick"]').attr('disabled',true).html('被占用')
			}
		} else {
			$('#isvideohidden').val('普通会议')
			$('.xuni').each(function () {
				$(this).css('background', '#DCDCDC').removeClass("selected").find('button[name="pick"]').attr('disabled',true).html('不可用')
			})
		}
	})
	// 日期限制
	$(function() {
				var nowTemp = new Date();
				var nowDay = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0).valueOf();
				var nowMoth = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), 1, 0, 0, 0, 0).valueOf();
				var nowYear = new Date(nowTemp.getFullYear(), 0, 1, 0, 0, 0, 0).valueOf();
				var $myStart2 = $('#mydate');

				var checkin = $myStart2.datepicker({
					onRender: function(date, viewMode) {
						// 默认 days 视图，与当前日期比较
						var viewDate = nowDay;

						switch(viewMode) {
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
					if(ev.date.valueOf() > checkout.date.valueOf()) {
						var newDate = new Date(ev.date)
						newDate.setDate(newDate.getDate() + 1);
						checkout.setValue(newDate);
					}
					checkin.close();
					$('#my-end-2')[0].focus();
				}).data('amui.datepicker');

				var checkout = $('#my-end-2').datepicker({
					onRender: function(date, viewMode) {
						var inTime = checkin.date;
						var inDay = inTime.valueOf();
						var inMoth = new Date(inTime.getFullYear(), inTime.getMonth(), 1, 0, 0, 0, 0).valueOf();
						var inYear = new Date(inTime.getFullYear(), 0, 1, 0, 0, 0, 0).valueOf();

						// 默认 days 视图，与当前日期比较
						var viewDate = inDay;

						switch(viewMode) {
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
			});
	
	// 条件查询
	$('#myquery').click(function() {
		var $selecteds = $('.selected')
		var $date = $('#mydate').val()
		var $sta = $('#staTime').val()
		var $end = $('#endTime').val()
		var date = myform.mydate.value
		var statime = date+' '+myform.staTime.value+':00'
		var endtime = date+' '+myform.endTime.value+':00'
		// 类型
		var type = $('input[name="myType"]:checked').val()
		// 格式化为字符串
		var nowStr = formatDateModi(new Date().getTime())
		// 校验时间段
		var t = judgeTime(statime, endtime)
		// 校验现在时间
		var t1 = judgeTime(nowStr, statime)
		if ($date == '' || $date == null || $sta == '' || $sta == null || $end == '' || $end == null || type == '' || type == null) {
			alert('查询条件不能为空！')
		} else {
			if ($selecteds.length > 0) {
				alert('查询前先取消选择')
			} else if (t > 0 || t1 > 0) {
				alert('请选择正确的时间')
			} else {
				var staTime = date+' '+$('#staTime').val()+':00'
				var endTime = date+' '+$('#endTime').val()+':00'
				if (type === '视频会议') {
					checkNumber(staTime, endTime)
					if (number == 0) {
						alert('当前时间段视频会议室预订达到上限！')
					} else {
						$.ajax({
							type: "POST",
							url: propath() + '/meet/list-meet',
							data: { 'staTime': staTime, 'endTime': endTime },
							dataType : "json",
							success: function (data) {
								// 重置默认
								$('.base').css('background', '#009CDA')
								$('button[name="pick"]').removeClass('am-icon-lock').addClass('am-icon-check').attr('disabled',false).html('选择这个')
								// 锁定非视频会议
								$('.notvideo').css('background', '#DCDCDC').find('button[name="pick"]').attr('disabled',true).html('不可用')
								// 遍历
								for (var i = 0; i < data.length; i++) {
									var id = data[i].meetRoomId
									$('#' + id).css('background', '#DCDCDC')
									var mybutton = $('#' + id).find('button[name="pick"]')
									mybutton.attr('disabled',true).html('被占了')
								}
							}
						})
						// 关闭侧栏
						$('#my-collopse').offCanvas('close')
					}
				} else {
					$.ajax({
						type: "POST",
						url: propath()+'/meet/list-meet',
						data: { 'staTime': staTime, 'endTime': endTime },
						dataType : "json",
						success: function (data) {
							// 重置默认
							$('.base').css('background', '#009CDA')
							$('button[name="pick"]').removeClass('am-icon-lock').addClass('am-icon-check').attr('disabled',false).html('选择这个')
							// 禁用虚拟端
							$('.xuni').css('background', '#DCDCDC')
							var xunibutton = $('.xuni').find('button[name="pick"]')
							xunibutton.attr('disabled',true).html('不可用')
							// 遍历填充颜色
							for (var i = 0; i < data.length; i ++) {
								var id = data[i].meetRoomId
								$('#' + id).css('background', '#DCDCDC')
								var mybutton = $('#' + id).find('button[name="pick"]')
								mybutton.attr('disabled',true).html('被占了')
							}
						}
					})
					$('#my-collopse').offCanvas('close')// 关闭侧栏
				}
			}
		}
	})
})

// 查询会议室详情以及预订信息
function getRoomInfo (roomId) {
	var date = myform.mydate.value
	// get异步请求
	$.get(propath() + '/room/getRoomInfo?roomId=' + roomId + '&&appDate=' + date, function (data) {
		var $model = $('#room-info')
		$('#roomInfot').empty()
		$('#meetInfot').empty()
		//填充会议室信息
		var infoTpl = '<li>名称：' + data.roomInfo.meetRoomName + '</li>' + 
					  '<li>容量：' + data.roomInfo.meetRoomNum + '人&nbsp;&nbsp;&nbsp;&nbsp;支持视频？' + data.roomInfo.isVideoRoom + '</li>'
		$('#roomInfot').append(infoTpl)
		// 填充会议信息
		if (data.meetInfo.length != 0 && data.meetInfo != null) {
			for(var i = 0; i < data.meetInfo.length; i++){
				var meetInfoTpl = '<li>' + (i + 1) + '&nbsp;' + data.meetInfo[i].applyEmpName + '&nbsp;&nbsp;时间：' + formatDate(data.meetInfo[i].staTime) + '~' + formatDate(data.meetInfo[i].endTime) + '</li>'
				$('#meetInfot').append(meetInfoTpl)
			}
		} else {
			$('#meetInfot').append('<li class="am-icon-frown-o">&nbsp;没有预订信息</li>')
		}
		// 开启模态窗口
		$model.modal()
	})
}

// div会议室点击显示事件
function clickShowDOM (obj) {
	$(obj).find('button').each(function (event) {
		if ($(this).css('visibility') === 'hidden')
			$(this).css('visibility', 'visible')
		else
			$(this).css('visibility', 'hidden')
	})
}

// 选择按钮事件
function selectInChart (obj, roomId) {
	// 获得爸爸
	var room = $(obj).parent().parent().parent().parent()
	if (!room.hasClass('selected')) {
		// 页面效果
		room.addClass('selected')
		$(obj).removeClass('am-icon-check').addClass('am-icon-heart').css('visibility','visible').html('已选中')
		return false
	} else {
		// 页面效果
		room.removeClass('selected')
		$(obj).removeClass('am-icon-heart').addClass('am-icon-check').html('选择这个')
		return false
	}
	
}

// 预定按钮检查
function toOrder () {
	var $selecteds = $('.selected') // 获取选取 总数
	var arr = new Array()
	var date = myform.mydate.value // 日期
	var $st = myform.staTime.value // 开始
	var $ed = myform.endTime.value // 结束
	var st = date+' '+myform.staTime.value+':00'
	var et = date+' '+myform.endTime.value+':00'
	var type = $('input[name="myType"]:checked').val() // 会议类型
	var nowStr = formatDateModi(new Date().getTime()) // 格式化为字符串
	var t = judgeTime(st, et) // 校验时间段
	var t1 = judgeTime(nowStr, st) // 校验现在时间
	if ($selecteds.length === 0) {
		alert('至少选择一个')
	} else if (t > 0 || t1 > 0) {
		alert('请选择正确的时间')
	} else if (date == '' || $st == '' || $st == null || $ed == '' || $ed == null) {alert('请先查询')} else {
		// 会议类型判断
		if (type === '视频会议') {
			checkNumber(st, et)
			if (number === 0) {
				alert('当前时间段视频会议室预订达到上限！')
			} else {
				getKysphyss(st, et)
				var myCount = $selecteds.length + kysphyss
				if (myCount > 10) {
					alert('当前预订会议室数以达到上限，请选择其他时间段')
				} else {
					// 视频
					var state = $('input[name="myType"]:checked').val()
					var am = $('#isvideo').val()
					// 会议室id存入数组
					$('.selected').each(function () {arr.push($(this).attr('id'))})
					var url1 = propath() + "/room/order-page-mobile";
					var form1 = $("<form></form>").attr("action", url1).attr("method", "post");
					form1.append($("<input></input>").attr("type", "hidden").attr("name", "staTime").attr("value", st))
					.append($("<input></input>").attr("type", "hidden").attr("name", "endTime").attr("value", et))
					.append($("<input></input>").attr("type", "hidden").attr("name", "state").attr("value", state))
					.append($("<input></input>").attr("type", "hidden").attr("name", "rooms").attr("value", arr));
					form1.appendTo('body').submit().remove();
					//window.location.href = propath() + '/room/order-page-mobile?staTime='+st+'&&endTime='+et+'&&state='+state+'&&rooms='+arr
				}
			}
		} else {
			// 普通会议
			var state = $('input[name="myType"]:checked').val()
			var am = $('#isvideo').val()
			// 会议室id存入数组
			$('.selected').each(function () {arr.push($(this).attr('id'))})
			var url = propath() + "/room/order-page-mobile";
			var form = $("<form></form>").attr("action", url).attr("method", "post");
			form.append($("<input></input>").attr("type", "hidden").attr("name", "staTime").attr("value", st))
			.append($("<input></input>").attr("type", "hidden").attr("name", "endTime").attr("value", et))
			.append($("<input></input>").attr("type", "hidden").attr("name", "state").attr("value", state))
			.append($("<input></input>").attr("type", "hidden").attr("name", "rooms").attr("value", arr));
			form.appendTo('body').submit().remove();
			// window.location.href = propath() + '/room/order-page-mobile?staTime='+st+'&&endTime='+et+'&&state='+state+'&&rooms='+arr
		}
	}
}


// 检查可用视频会议
function checkNumber (sta, end) {
		$.ajax({
			type: 'GET',
			async: false,
			url: propath() + '/meet/getAudioInfo?staTime='+sta+'&&endTime='+end,
			success: function (data) {
				number = data
			}
		});
}

function getKysphyss(staTime,endTime){
	$.ajax({
		url: propath() + '/meet/getFreeRoomsAndDks/?staTime='+staTime+'&&endTime='+endTime,
		type: 'GET',
		async: false,
		dataType: 'json',
		success: function(data){
			kysphyss = data
		}
	})
}