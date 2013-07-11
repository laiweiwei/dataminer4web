<h2 class="contentTitle">数据源选择</h2>


<div class="pageContent">
	
	<form method="post" action="/datasourceform" class="pageForm required-validate" onsubmit="return validateCallback(this)">
		<div class="pageFormContent nowrap" layoutH="97">

			<dl>
				<dt>数据库用户名</dt>
				<dd>
					<input type="text" name="username"  class="required" />
					<span class="info">必填</span>
				</dd>
			</dl>
			<dl>
				<dt>密码：</dt>
				<dd>
					<input  type="password" name="password" class="required "  alt=""/>
					<span class="info">必填</span>
				</dd>
			</dl>
				<dl>
				<dt>数据表名</dt>
				<dd>
					<input type="text" name="tablename"  class="required" />
					<span class="info">必填</span>
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