var orderRoom = ""
var sub = true
$(function () {
	// 页面加载初始化选择框组件
	$('.chosen-select').chosen()
	// 页面加载进度
	var progress = $.AMUI.progress;
	progress.start()
	document.onreadystatechange = function () {
        if (document.readyState === 'complete') {
            progress.done()
        }
    }
})

// 重置复位键
function reMethod () {
	document.getElementById('myform').reset()
}

// 表单提交检查
function submitForm () {
	//遮罩层
	$("#mask").css("height",$(document).height());     
    $("#mask").css("width",$(document).width());     
    $("#mask").show();     
	//判断
//	var staTime = $('input[name="staTime"]').val()
//	var endTime = $('input[name="endTime"]').val()
//	var meetRoomId = ""
//	$('.am-icon-home').each(function(){
//		meetRoomId += $(this).prev().prev().val()+',' 
//	})
	//meetRoomId = meetRoomId.substring(0,meetRoomId.length-1)
	//alert(staTime + '\n' + endTime + '\n' + meetRoomId)
	/*$.ajax({
		url:propath()+'/meet/list-none-room',
		type:'post',
		data:{
			'staTime':staTime,
			'endTime':endTime,
			'roomIds':meetRoomId
		},
		dataType:'json',
		success:function(data){
			orderRoom = data
			//alert(orderRoom)
			console.log(orderRoom)
		}
	})
	//event.preventDefault()
	if(orderRoom!=""&&orderRoom!=null){
		alert("该时间段内 " + orderRoom + " 等会议室已被占用，请返回首页重新预订其他可用会议室")
		orderRoom = ''
		event.preventDefault()
	}else{*/
		$('.am-icon-home').each(function () {
			var hiddeDom = $(this).prev()
			var personNo = hiddeDom.parent().find('select').val()
			var salt = '' 
			for (var i = 0; i < personNo.length; i++) {
				salt += ' ' + personNo[i]
			}
			hiddeDom.val(salt)
		})
		if(sub){
			$('#myform').submit()
			sub = false
		}
	//}
}

function propath() {
	// 获取项目路径信息
	var curWwwPath = window.document.location.href;
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	var localhostPath = curWwwPath.substring(0, pos);
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	
	return localhostPath + projectName;
}