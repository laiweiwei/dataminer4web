<%@ page contentType="text/html; charset=utf-8" language="java"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<meta name="author" content="cfuture" />
<title>GoldMiner队参赛作品</title>
<jsp:include page="css.jsp" />
<jsp:include page="javascript.jsp" />
<script type="text/javascript">
$(function(){
	DWZ.init("${BaseURL}dwzres/dwz.frag.xml", {
		//loginUrl:"../loginsub.jsp", loginTitle:"登录",	// 弹出登录对话框
		//loginUrl:"../login",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"themes"});
		}
	});
});
</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="">logo</a>
				<ul class="nav">
					<li><a href="javascript:;">欢迎 [<b>{loginUser.account}</b>]
					</a></li>
					
					<li><a href="${BaseURL}users/profile" target="dialog"
						height="380">[我的资料 ]</a></li>
					<li><a href="${BaseURL}users/logout"
						onclick="var f = document.createElement('form');f.style.display = 'none'; this.parentNode.appendChild(f); f.method='POST'; f.action = this.href; var m = document.createElement('input');m.setAttribute('type','hidden');m.setAttribute('name','_method');m.setAttribute('value','put'); f.appendChild(m);f.submit();return false;">[退出
							]</a></li>
					<li><a href="${BaseURL}main/about-us" target="dialog">关于</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>

			<div id="navMenu">
				<ul>

					<li><a href="{BaseURL}{navMenu.href}"><span>{navMenu.name}</span></a></li>

				</ul>
			</div>
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse">
						<div></div>
					</div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse">
					<h2>主菜单</h2>
					<div>收缩</div>
				</div>

				<div class="accordion" fillSpace="sidebar">
					<div class="accordionHeader">
						<h2>
							<span>Folder</span>界面组件
						</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="">数据源选择</a>
								<ul>

									<li><a href="/datasource" target="navTab" rel="datasource">数据源选择</a></li>

								</ul></li>

							<li><a href="">关联分析</a>
								<ul>
									<li><span>Apriori</span>
										<ul>

											<li><a href="/associations/para" target="navTab"
												rel="associationspara">参数选择</a></li>
											<li><a href="/associations/run" target="navTab"
												rel="associationsrun">开始分析</a></li>
										</ul></li>
								</ul></li>



							<li><a href="">分类</a>
								<ul>

									<li><span>IncrementalBayes</span>
										<ul>

											<li><a href="/incrementalbayes/para" target="navTab"
												rel="incrementalbayespara">参数选择</a></li>
											<li><a href="/incrementalbayes/run" target="navTab"
												rel="incrementalbayesrun">开始分析</a></li>
										</ul></li>

									<li><span>NaiveBayes</span>
										<ul>

											<li><a href="/naivebayes/para" target="navTab"
												rel="naivebayespara">参数选择</a></li>
											<li><a href="/naivebayes/run" target="navTab"
												rel="naivebayesrun">开始分析</a></li>
										</ul></li>

									<li><span>J48</span>
										<ul>

											<li><a href="/j48/para" target="navTab" rel="j48para">参数选择</a></li>
											<li><a href="/j48/run" target="navTab" rel="j48run">开始分析</a></li>
										</ul></li>

									<li><span>SMO</span>
										<ul>

											<li><a href="/smo/para" target="navTab" rel="smopara">参数选择</a></li>
											<li><a href="/smo/run" target="navTab" rel="smorun">开始分析</a></li>
										</ul></li>


								</ul></li>


							<li><span>聚类分析</span>
								<ul>
									<li><span>KMeams</span>
										<ul>

											<li><a href="/kmeans/para" target="navTab"
												rel="kmeanspara">参数选择</a></li>

											<li><a href="/kmeans/run" target="navTab"
												rel="kmeansrun">开始分析</a></li>
										</ul></li>
								</ul></li>
						</ul>

					
				</div>
			</div>
			</div>
			</div>
		

		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="page">
						<div class="pageContent">
							<div class="pageFormContent" style="padding: 20px 0 0 50px;"
								layoutH="58">
								<p>GoldMiner队信息</p>
								<p>题目7：基于R语言的数据挖掘平台</p>
								<p>队长：肖齐天 QQ：948738850</p>
								<p>指导老师：李玉强</p>
								<p>学校：武汉理工大学</p>
							</div>
						</div>
					</div>
					<div class="tabsPageHeaderContent">
						<!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span
										class="home_icon">桌面</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div>
					<!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div>
					<!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">桌面</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent">
					<div class="page">
						<div class="pageContent">
							<div
								style="overflow: auto; width: 100%; height: 100%; background: #ccc;"></div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div id="taskbar" style="left: 0px; display: none;">
			<div class="taskbarContent">
				<ul></ul>
			</div>
			<div class="taskbarLeft taskbarLeftDisabled" style="display: none;">taskbarLeft</div>
			<div class="taskbarRight" style="display: none;">taskbarRight</div>
		</div>
		<div id="splitBar"></div>
		<div id="splitBarProxy"></div>
	</div>

	<div id="footer">{MainModel.copyRight}</div>

	<!--拖动效果-->
	<div class="resizable"></div>
	<!--阴影-->
	<div class="shadow" style="width: 508px; top: 148px; left: 296px;">
		<div class="shadow_h">
			<div class="shadow_h_l"></div>
			<div class="shadow_h_r"></div>
			<div class="shadow_h_c"></div>
		</div>
		<div class="shadow_c">
			<div class="shadow_c_l" style="height: 296px;"></div>
			<div class="shadow_c_r" style="height: 296px;"></div>
			<div class="shadow_c_c" style="height: 296px;"></div>
		</div>
		<div class="shadow_f">
			<div class="shadow_f_l"></div>
			<div class="shadow_f_r"></div>
			<div class="shadow_f_c"></div>
		</div>
	</div>
	<!--遮盖屏幕-->
	<div id="alertBackground" class="alertBackground"></div>
	<div id="dialogBackground" class="dialogBackground"></div>

	<div id='background' class='background'></div>
	<div id='progressBar' class='progressBar'>数据加载中，请稍等...</div>
</body>
</html>
