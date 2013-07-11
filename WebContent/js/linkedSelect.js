/**
 * LinkedSelect: 联动下拉框控件，支持N级联动。
 * 根据每个Select的定义中的url和id为Select做初始化，后台返回的数据为[{value:"",label:""},{value:"",label:""}]形式的数组json
 * @author senton
 * @version 1.0
 * 
 * 以选国家、省、市的联动为例，调用示例如下：
 * <pre>
 *  // 声明一个select变量
 * 	var select = new LinkedSelect();
 *  // 调用selct的init()方法，注意，该方法的参数是一个数组，用[]括起来，每个select的定义用{}括起来，多个select定义之间以,分割
 * 	select.init([
 * 		{
 * 			id:"country",
 * 			url:"获取country列表的url",
 * 			nullable:false,
 * 			defaultValue:2
 * 		},
 * 		{
 * 			id:"province",
 * 			url:"获取province列表的url",
 * 			nullable:false
 * 		},
 * 		{
 * 			id:"city",
 * 			url:"获取city列表的url",
 * 			nullable:false
 * 		}
 *  ]); 
 * </pre>
 */
/**
 * 定义一个LinkedSelect函数
 */
function LinkedSelect(){
	
	return this;
}

/**
 * LinkedSelect的初始化方法
 * @param init_params 定义option的value和name字段名
 * @param allSelectInputs 所有的需要联动显示的下拉框，是一个数组。
 * @returns
 */
LinkedSelect.prototype.init = function(init_params, allSelectInputs){
	var label_name = init_params.label_name;
	var value_name = init_params.value_name;
	
	// 定义一个内部方法，用于加载一个下拉框，参数：
	// 	allSelectInputs：所有的下拉框定义
	//  parentId: 上一个被选中的ID，即<option>的value属性值
	//  currentIndex: 要初始化的下拉框在allSelectInputs中的索引
	initNextSelect = function(allSelectInputs, parentId, currentIndex){
		// 如果没有allSelectInputs值或者allSelectInputs的长度小于等于currentIndex，说明没有需要初始化的下拉框了，就返回
		if(!allSelectInputs || allSelectInputs.length <= currentIndex){
			return;
		}
		// 取出当前需要初始化的select的定义
		var currentSelect = allSelectInputs[currentIndex];
		// 清空currentSelect的option
		$("#"+currentSelect.id).empty();
		// 如果还有下一个，则为当前的Select加上onchange事件
		if(allSelectInputs.length > currentIndex + 1){
			$("#"+currentSelect.id).unbind("change");
			$("#"+currentSelect.id).bind("change", function(){
				initNextSelect(allSelectInputs, $(this).val(), currentIndex + 1);
			});
		}
		// 如果不是第一个，则需要判断parentId是否为空，如果为空，则递归清空后面的所有下拉框
		if(currentIndex != 0){
			if(!parentId || parentId == ''){
				$("#"+currentSelect.id).append("<option value=''></option>");
				initNextSelect(allSelectInputs, $("#"+currentSelect.id).val(), currentIndex + 1);
				return;
			}
		}
		// 如果不为空，则根据parentId取出所有的SelectItem初始化currentSelect
		// 对url的占位符{parent_id}替换
		var url = currentSelect.url.replace("{parent_id}", parentId);
		$.post(url, { parentId:parentId },
			function(data){
				// 如果currentSelect在被定义时nullable为true，则说明可以为空，在第一个加上一个空的option
				if(currentSelect.nullable){
					$("#"+currentSelect.id).append("<option value=''>请选择</option>");
				}
				// 取出所有的selectItem加到currentSelect上
				$.each(data, function (index, selectItem) {
					// 如果currentSelect在被定义时的defaultValue等于当前selectItem的值，则选中它
					if(index == currentSelect.defaultIndex){
						$("#"+currentSelect.id).append("<option selected='selected' value='" + selectItem[value_name] + "'>" + selectItem[label_name] + "</option>");
					}
					else {
						$("#"+currentSelect.id).append("<option value='" + selectItem[value_name] + "'>" + selectItem[label_name] + "</option>");
					}
				});
				// 初始化完毕后，取出当前currentSelect选中的值，作为parentId初始化下一个select
				initNextSelect(allSelectInputs, $("#"+currentSelect.id).val(), currentIndex + 1);
			},"json"
		);
	};

	// 调用initNextSelect，启动第一个下拉框的加载
	initNextSelect(allSelectInputs, "", 0);
	
};