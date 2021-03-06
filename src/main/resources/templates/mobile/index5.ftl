<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>会议室状态面板</title>
		<link href="https://cdn.bootcss.com/amazeui/2.7.2/css/amazeui.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/base1.css">
		<body>
			<header data-am-widget="header" class="am-header am-header-default" data-am-sticky>
				<div class="am-header-left am-header-nav">
					<a href="#my-collopse" data-am-offcanvas>
						<i class="am-header-icon am-icon-bars" ><small>&nbsp;预&nbsp;订</small></i>
					</a>
				</div>

				<h1 class="am-header-title">
            		会议预订系统
     			</h1>

				<div class="am-header-right am-header-nav">
					<a href="${ctx}/meet/showMyApply">
						<i class="am-header-icon am-icon-user"></i>
					</a>
				</div>
			</header>
			
			<div class="am-tabs" id="doc-my-tabs">
				<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
					<li class="am-active">
						<a>广东爱旭</a>
					</li>
					<li>
						<a>浙江爱旭</a>
					</li>
					<li>
						<a>虚拟终端</a>
					</li>
				</ul>
				<div class="am-tabs-bd">
					<div class="am-tab-panel am-active">
						<div class="am-g">
							<div class="am-container am-u-sm-6">
								<!--1-->
								<div class="am-g">
									<div id="aiko_2" class="aiko_1 base notvideo" onclick="clickShowDOM(this)" style="width: 98%;">
										<h2>1-1F-1</h2>
										<div class="am-container" style="margin: 0px 0px 5px 0px;">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" class="am-btn am-btn-xs am-btn-success am-round am-icon-search" onclick="getRoomInfo('aiko_2')" style="visibility: hidden;">查看详情</button>
												</div>
											</div>
										</div>
										<div class="am-container">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" name="pick" class="am-btn am-btn-xs am-btn-success am-round am-icon-check" onclick="selectInChart(this, 'aiko_2')" style="visibility: hidden;">选择这个</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!--2-->
								<div class="am-g">
									<div id="aiko_1" class="aiko_4 base" onclick="clickShowDOM(this)" style="width: 98%;">
										<h2 class="am-icon-video-camera">&nbsp;1-2F-1</h2>
										<div class="am-container" style="margin: 0px 0px 5px 0px;">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" class="am-btn am-btn-xs am-btn-success am-round am-icon-search" onclick="getRoomInfo('aiko_1')" style="visibility: hidden;">查看详情</button>
												</div>
											</div>
										</div>
										<div class="am-container">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" name="pick" class="am-btn am-btn-xs am-btn-success am-round am-icon-check" onclick="selectInChart(this, 'aiko_1')" style="visibility: hidden;">选择这个</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!--3-->
								<div class="am-g">
									<div id="aiko_11" class="aiko_5 base" onclick="clickShowDOM(this)" style="width: 98%;">
										<h2 class="am-icon-video-camera">&nbsp;陈董办公室</h2>
										<div class="am-container" style="margin: 0px 0px 5px 0px;">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" class="am-btn am-btn-xs am-btn-success am-round am-icon-search" onclick="getRoomInfo('aiko_11')" style="visibility: hidden;">查看详情</button>
												</div>
											</div>
										</div>
										<div class="am-container">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" name="pick" class="am-btn am-btn-xs am-btn-success am-round am-icon-check" onclick="selectInChart(this, 'aiko_11')" style="visibility: hidden;">选择这个</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- 5 -->
								<div class="am-g">
									<div id="aiko_5" class="aiko_1 base notvideo" onclick="clickShowDOM(this)" style="width: 98%;">
										<h2>2-1F-1</h2>
										<div class="am-container" style="margin: 0px 0px 5px 0px;">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" class="am-btn am-btn-xs am-btn-success am-round am-icon-search" onclick="getRoomInfo('aiko_5')" style="visibility: hidden;">查看详情</button>
												</div>
											</div>
										</div>
										<div class="am-container">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" name="pick" class="am-btn am-btn-xs am-btn-success am-round am-icon-check" onclick="selectInChart(this, 'aiko_5')" style="visibility: hidden;">选择这个</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="am-container am-u-sm-6">
								<!--4-->
								<div class="am-g">
									<div id="aiko_3" class="aiko_4 base" onclick="clickShowDOM(this)">
										<h2 class="am-icon-video-camera">&nbsp;1-2F-2</h2>
										<div class="am-container" style="margin: 0px 0px 5px 0px;">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" class="am-btn am-btn-xs am-btn-success am-round am-icon-search" onclick="getRoomInfo('aiko_3')" style="visibility: hidden;">查看详情</button>
												</div>
											</div>
										</div>
										<div class="am-container">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" name="pick" class="am-btn am-btn-xs am-btn-success am-round am-icon-check" onclick="selectInChart(this, 'aiko_3')" style="visibility: hidden;">选择这个</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!--5-->
								<div class="am-g">
									<div id="aiko_4" class="aiko_4 base notvideo" onclick="clickShowDOM(this)">
										<h2>1-1F-2</h2>
										<div class="am-container" style="margin: 0px 0px 5px 0px;">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" class="am-btn am-btn-xs am-btn-success am-round am-icon-search" onclick="getRoomInfo('aiko_4')" style="visibility: hidden;">查看详情</button>
												</div>
											</div>
										</div>
										<div class="am-container">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" name="pick" class="am-btn am-btn-xs am-btn-success am-round am-icon-check" onclick="selectInChart(this, 'aiko_4')" style="visibility: hidden;">选择这个</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!--6-->
								<div class="am-g">
									<div id="aiko_12" class="aiko_3 base notvideo" onclick="clickShowDOM(this)">
										<h2>2-2F-PX</h2>
										<div class="am-container" style="margin: 0px 0px 5px 0px;">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" class="am-btn am-btn-xs am-btn-success am-round am-icon-search" onclick="getRoomInfo('aiko_12')" style="visibility: hidden;">查看详情</button>
												</div>
											</div>
										</div>
										<div class="am-container">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" name="pick" class="am-btn am-btn-xs am-btn-success am-round am-icon-check" onclick="selectInChart(this, 'aiko_12')" style="visibility: hidden;">选择这个</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="am-tab-panel">
							<!--浙江爱旭科技-->
							<div class="am-container">
								<div id="aixu_1" class="am-g aixu1 base" onclick="clickShowDOM(this)">
									<h1 class="am-icon-video-camera">&nbsp;1#</h1>
									<br /><br /><br /><br />
									<div class="am-container">
										<div class="am-g">
											<div class="am-u-sm-6">
												<button type="button" class="am-btn am-btn-success am-round am-icon-search" onclick="getRoomInfo('aixu_1')" style="visibility: hidden;">查看详情</button>
											</div>
											<div class="am-u-sm-6">
												<button type="button" name="pick" class="am-btn am-btn-success am-round am-icon-check" onclick="selectInChart(this, 'aixu_1')" style="visibility: hidden;">选择这个</button>
											</div>
										</div>
									</div>
								</div>
								<div id="aixu_2" class="am-g aixu1 base" onclick="clickShowDOM(this)">
									<h1 class="am-icon-video-camera">&nbsp;2#</h1>
									<br /><br /><br /><br />
										<div>
											<div class="am-g">
											<div class="am-u-sm-6">
												<button type="button" class="am-btn am-btn-success am-round am-icon-search" onclick="getRoomInfo('aixu_2')" style="visibility: hidden;">查看详情</button>
											</div>
											<div class="am-u-sm-6">
												<button type="button" name="pick" class="am-btn am-btn-success am-round am-icon-check" onclick="selectInChart(this, 'aixu_2')" style="visibility: hidden;">选择这个</button>
											</div>
											</div>
										</div>
								</div>
							</div>
					</div>
					<!--虚拟-->
					<div class="am-tab-panel">
						<div class="am-g">
							<div class="am-container am-u-sm-6">
								<div class="am-g">
									<div id="dk_1" class="xuni xuni1 base" onclick="clickShowDOM(this)" style="width: 98%;">
										<h2>6001</h2>
										<div class="am-container" style="margin: 0px 0px 5px 0px;">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" class="am-btn am-btn-xs am-btn-success am-round am-icon-search" onclick="getRoomInfo('dk_1')" style="visibility: hidden;">查看详情</button>
												</div>
											</div>
										</div>
										<div class="am-container">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" name="pick" class="am-btn am-btn-xs am-btn-success am-round am-icon-check" onclick="selectInChart(this, 'dk_1')" style="visibility: hidden;">选择这个</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="am-g">
									<div id="dk_3" class="xuni xuni3 base" onclick="clickShowDOM(this)" style="width: 98%;">
										<h2>6003</h2>
										<div class="am-container" style="margin: 0px 0px 5px 0px;">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" class="am-btn am-btn-xs am-btn-success am-round am-icon-search" onclick="getRoomInfo('dk_3')" style="visibility: hidden;">查看详情</button>
												</div>
											</div>
										</div>
										<div class="am-container">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" name="pick" class="am-btn am-btn-xs am-btn-success am-round am-icon-check" onclick="selectInChart(this, 'dk_3')" style="visibility: hidden;">选择这个</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="am-g">
									<div id="dk_5" class="xuni xuni5 base" onclick="clickShowDOM(this)" style="width: 98%;">
										<h2>6005</h2>
										<div class="am-container" style="margin: 0px 0px 5px 0px;">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" class="am-btn am-btn-xs am-btn-success am-round am-icon-search" onclick="getRoomInfo('dk_5')" style="visibility: hidden;">查看详情</button>
												</div>
											</div>
										</div>
										<div class="am-container">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" name="pick" class="am-btn am-btn-xs am-btn-success am-round am-icon-check" onclick="selectInChart(this, 'dk_5')" style="visibility: hidden;">选择这个</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="am-g">
									<div id="dk_7" class="xuni xuni7 base" onclick="clickShowDOM(this)" style="width: 98%;">
										<h2>6007</h2>
										<div class="am-container" style="margin: 0px 0px 5px 0px;">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" class="am-btn am-btn-xs am-btn-success am-round am-icon-search" onclick="getRoomInfo('dk_7')" style="visibility: hidden;">查看详情</button>
												</div>
											</div>
										</div>
										<div class="am-container">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" name="pick" class="am-btn am-btn-xs am-btn-success am-round am-icon-check" onclick="selectInChart(this, 'dk_7')" style="visibility: hidden;">选择这个</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="am-g">
									<div id="dk_9" class="xuni xuni9 base" onclick="clickShowDOM(this)" style="width: 98%;">
										<h2>6009</h2>
										<div class="am-container" style="margin: 0px 0px 5px 0px;">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" class="am-btn am-btn-xs am-btn-success am-round am-icon-search" onclick="getRoomInfo('dk_9')" style="visibility: hidden;">查看详情</button>
												</div>
											</div>
										</div>
										<div class="am-container">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" name="pick" class="am-btn am-btn-xs am-btn-success am-round am-icon-check" onclick="selectInChart(this, 'dk_9')" style="visibility: hidden;">选择这个</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="am-container am-u-sm-6">
								<div class="am-g">
									<div id="dk_2" class="xuni xuni2 base" onclick="clickShowDOM(this)">
										<h2>6002</h2>
										<div class="am-container" style="margin: 0px 0px 5px 0px;">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" class="am-btn am-btn-xs am-btn-success am-round am-icon-search" onclick="getRoomInfo('dk_2')" style="visibility: hidden;">查看详情</button>
												</div>
											</div>
										</div>
										<div class="am-container">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" name="pick" class="am-btn am-btn-xs am-btn-success am-round am-icon-check" onclick="selectInChart(this, 'dk_2')" style="visibility: hidden;">选择这个</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="am-g">
									<div id="dk_4" class="xuni xuni4 base" onclick="clickShowDOM(this)">
										<h2>6004</h2>
										<div class="am-container" style="margin: 0px 0px 5px 0px;">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" class="am-btn am-btn-xs am-btn-success am-round am-icon-search" onclick="getRoomInfo('dk_4')" style="visibility: hidden;">查看详情</button>
												</div>
											</div>
										</div>
										<div class="am-container">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" name="pick" class="am-btn am-btn-xs am-btn-success am-round am-icon-check" onclick="selectInChart(this, 'dk_4')" style="visibility: hidden;">选择这个</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="am-g">
									<div id="dk_6" class="xuni xuni6 base" onclick="clickShowDOM(this)">
										<h2>6006</h2>
										<div class="am-container" style="margin: 0px 0px 5px 0px;">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" class="am-btn am-btn-xs am-btn-success am-round am-icon-search" onclick="getRoomInfo('dk_6')" style="visibility: hidden;">查看详情</button>
												</div>
											</div>
										</div>
										<div class="am-container">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" name="pick" class="am-btn am-btn-xs am-btn-success am-round am-icon-check" onclick="selectInChart(this, 'dk_6')" style="visibility: hidden;">选择这个</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="am-g">
									<div id="dk_8" class="xuni xuni8 base" onclick="clickShowDOM(this)">
										<h2>6008</h2>
										<div class="am-container" style="margin: 0px 0px 5px 0px;">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" class="am-btn am-btn-xs am-btn-success am-round am-icon-search" onclick="getRoomInfo('dk_8')" style="visibility: hidden;">查看详情</button>
												</div>
											</div>
										</div>
										<div class="am-container">
											<div class="am-g">
												<div class="am-u-sm-12">
													<button type="button" name="pick" class="am-btn am-btn-xs am-btn-success am-round am-icon-check" onclick="selectInChart(this, 'dk_8')" style="visibility: hidden;">选择这个</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								
							</div>
						</div>
					</div>
				</div>
				<!-- 模态窗口会议室Info -->
				<div class="am-modal am-modal-no-btn" tabindex="-1" id="room-info">
					<div class="am-modal-dialog">
					    <div class="am-modal-hd" style="color: deepskyblue;">会议室信息
					      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
					    </div>
					    <div class="am-modal-bd">
					      	<ul class="am-list am-list-static" id='roomInfot' style="text-align: left;"></ul>
					    </div>
					    <div class="am-modal-hd" style="color: deepskyblue;">当日预定信息</div>
					    <div class="am-modal-bd">
					       <ul class="am-list am-list-static" id='meetInfot' style="text-align: center;"></ul>
					    </div>
					</div>
				</div>
				<!--侧栏-->
				<div id="my-collopse" class="am-offcanvas">
		  			<div class="am-offcanvas-bar"> 	
					    <div class="am-offcanvas-content">
					      <div class="am-container">
							<form id="myform" class="am-form" method="post">
								<br />
								<!--日期-->
								<div class="am-g">
									<input type="text" class="am-form-field am-form-group-sm" id="mydate" placeholder="选个日期吧" readonly required>
									<input type="text" id="my-end-2" style="display: none;">
								</div>
								<br />
								<!--时间段-->
								<div class="am-g">
									<div class="am-form-group">
										<div class="am-u-sm-6">
											<select class="xbb" id="staTime" data-am-selected="{maxHeight: 300, btnWidth: '100%', btnStyle: 'warning'}">
												<!-- <option disabled selected value="">开始时间</option> -->
												<option selected value="bb">开始时间</option>
											</select>
										</div>
										<div class="am-u-sm-6">
											<select class="xbb" id="endTime" data-am-selected="{maxHeight: 300, btnWidth: '100%', btnStyle: 'warning'}">
												<option selected value="bb">结束时间</option>
											</select>
										</div>
									</div>
								</div>
								<br />
								<!--类型-->
								<div class="am-g">
									<div class="am-form-group">
										<label class="am-checkbox-inline">类型&nbsp;:</label>
										<label class="am-radio am-checkbox-inline">
											<input type="radio" name="myType" value="视频会议" data-am-ucheck>视频
										</label>
										<label class="am-radio am-checkbox-inline">
											<input type="radio" name="myType" value="普通会议" data-am-ucheck>普通
										</label>
									</div>
								</div>
								<br />
								<!--按钮组-->
								<div class="am-g">
									<div class="am-form-group">
										<div class="am-u-sm-4">
											<button id="myquery" type="button" class="am-btn am-btn-primary am-icon-search">&nbsp;查询</button>
										</div>
										<div class="am-u-sm-2"></div>
										<div class="am-u-sm-6">
											<button id="oeder" type="button" class="am-btn am-btn-success am-icon-paper-plane" onclick="toOrder()">&nbsp;预订</button>
										</div>
									</div>
								</div>
							</form>
						  </div>
					    </div>
		  			</div>
				</div>
			</div>
			<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
			<script src="https://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min.js"></script>
			<script type="text/javascript" src="js/common/common-mobile.js"></script>
			<script>
				$(function() {
					// 初始化选项卡
					$('#doc-my-tabs').tabs();
					// 初始化填充时间段
					$(".xbb").append(
							'<option value="08:30">08:30</option><option value="08:45">08:45</option><option value="09:00">09:00</option><option value="09:15">09:15</option><option value="09:30">09:30</option><option value="09:45">09:45</option><option value="10:00">10:00</option>' +
							'<option value="10:15">10:15</option><option value="10:30">10:30</option><option value="10:45">10:45</option><option value="11:00">11:00</option><option value="11:15">11:15</option><option value="11:30">11:30</option><option value="11:45">11:45</option><option value="12:00">12:00</option><option value="12:15">12:15</option><option value="12:30">12:30</option><option value="12:45">12:45</option><option value="13:00">13:00</option><option value="13:15">13:15</option><option value="13:30">13:30</option><option value="13:45">13:45</option>' +
							'<option value="14:00">14:00</option><option value="14:15">14:15</option><option value="14:30">14:30</option><option value="14:45">14:45</option><option value="15:00">15:00</option><option value="15:15">15:15</option><option value="15:30">15:30</option><option value="15:45">15:45</option>'+
							'<option value="16:00">16:00</option><option value="16:15">16:15</option><option value="16:30">16:30</option><option value="16:45">16:45</option><option value="17:00">17:00</option><option value="17:15">17:15</option><option value="17:30">17:30</option><option value="17:45">17:45</option>' +
							'<option value="18:00">18:00</option><option value="18:15">18:15</option><option value="18:30">18:30</option><option value="18:45">18:45</option><option value="19:00">19:00</option><option value="19:15">19:15</option><option value="19:30">19:30</option><option value="19:45">19:45</option>'+
							'<option value="20:00">20:00</option><option value="20:15">20:15</option><option value="20:30">20:30</option><option value="20:45">20:45</option><option value="21:00">21:00</option><option value="21:15">21:15</option>' +
							'<option value="21:30">21:30</option><option value="21:45">21:45</option><option value="22:00">22:00</option><option value="22:15">22:15</option><option value="22:30">22:30</option><option value="22:45">22:45</option><option value="23:00">23:00</option><option value="23:15">23:15</option><option value="23:30">23:30</option><option value="23:45">23:45</option>' + 
							'<option value="00:00">00:00</option><option value="00:15">00:15</option><option value="00:30">00:30</option><option value="00:45">00:45</option><option value="01:00">01:00</option><option value="01:15">01:15</option><option value="01:30">01:30</option><option value="01:45">01:45</option><option value="02:00">02:00</option><option value="02:15">02:15</option><option value="02:30">02:30</option><option value="02:45">02:45</option><option value="03:00">03:00</option>' +
							'<option value="03:15">03:15</option><option value="03:30">03:30</option><option value="03:45">03:45</option><option value="04:00">04:00</option><option value="04:15">04:15</option><option value="04:30">04:30</option><option value="04:45">04:45</option><option value="05:00">05:00</option><option value="05:15">05:15</option><option value="05:30">05:30</option><option value="05:45">05:45</option><option value="06:00">06:00</option><option value="06:15">06:15</option><option value="06:30">06:30</option>' +
							'<option value="06:45">06:45</option><option value="07:00">07:00</option><option value="07:15">07:15</option><option value="07:30">07:30</option><option value="07:45">07:45</option><option value="08:00">08:00</option><option value="08:15">08:15</option>'
					)

				})

			</script>
		</body>

		<!--[if (gte IE 9)|!(IE)]><!-->
		<!--<![endif]-->
		<!--[if lte IE 8 ]>
		<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
		<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
		<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
		<![endif]-->

</html>