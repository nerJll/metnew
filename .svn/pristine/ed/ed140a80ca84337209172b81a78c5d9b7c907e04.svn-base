var orderRoom = ''
// 全局变量 
var flag = true
$(function () {
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
	var tpl = '<i class="am-icon-spinner am-icon-spin"></i>稍等'
	$('#careful').attr('disabled', 'disabled').empty().append(tpl)
	//判断
	$('.am-icon-home').each(function () {
		var hiddeDom = $(this).prev()
		var personNo = hiddeDom.parent().find('select').val()
		var salt = '' 
		for (var i = 0; i < personNo.length; i++) {
			salt += ' ' + personNo[i]
		}
		hiddeDom.val(salt)
	})
	// 防止二次提交
	if (flag) {
		$('#myform').submit()
		flag = false
	}
	
}

function propath() {
	// 获取项目路径信息
	var curWwwPath = window.document.location.href;
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	var localhostPath = curWwwPath.substring(0, pos);
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	return localhostPath + projectName;
}