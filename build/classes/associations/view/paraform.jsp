<%@ page contentType="text/html; charset=utf-8" language="java"
	pageEncoding="utf-8"%>
<h2 class="contentTitle">参数设置</h2>


<div class="pageContent">
	
	<form method="post" action="${BaseURL}associations/paraform" onsubmit="return validateCallback(this)">
		<div class="pageFormContent nowrap" layoutH="97">

			<dl>
				<dt>参数设置</dt>
				<dd>
					<input type="text" name="para" />
					<span class="info">选填</span>
				</dd>
			</dl>


		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>