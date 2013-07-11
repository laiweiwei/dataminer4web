/**
 * 弹出窗口报警CSS类
 */
var FLASH_CLASS = new Array("red","black");
 /**
 * Code : chenyoca ( chenyoca@163.com )
 * Date : 2011-11-30
 * Desc : 显示对话框的API集合。依赖artDialog插件的显示效果。
 */
 
/**
 * 显示警告框
 * @param {} title 标题
 * @param {} msg 警告信息
 * @param {} time 显示时间（秒）
 */
ShowAlertMessageDelay = function(title,msg,time){
	_chenyoca_show_dialog(title,msg,time,'warning');
};

/**
 * 显示一个错误提示框
 * @param {} title 标题
 * @param {} msg 消息
 * @param {} time 显示时间
 */
ShowErrorMessageDelay = function(title,msg,time){
	_chenyoca_show_dialog(title,msg,time,'error',true);
};

/**
 * 显示一个请求确认的模态对话框
 * @param {} title 标题
 * @param {} msg 信息
 * @param {} callback 确认回调函数
 */
ShowConfirmDialog = function(title,msg,callback){
	art.dialog({
		lock:true,
		title:title,
		content:msg,
		icon:'question',
		resize:false,
		top:'50%',
		left:'50%',
		okVal:'确认',
		ok:callback,
		cancelVal:'取消',
		cancel:true
	});
};

/**
 * 在屏幕顶部显示一个文字闪烁的对话框
 * @param {} title 标题
 * @param {} msg 信息
 */
ShowTopWarningMessage = function(title,msg){
	var message_id = "warning-message";
	var message = '<span id="'+message_id+'">'+msg+'</span>';
	var timer = undefined;
	art.dialog({
	    id: 'msg',
	    content: message,
	    title:title,
	    icon:'warning',
	    width: 320,
	    height: 45,
	    left: '50%',
	    top: '0%',
	    fixed: true,
	    drag: false,
	    resize: false,
	    esc:false,
	    init:function(){
	    	var index = 0;
	    	var flash = function(){
	    		index++;
	    		$('#'+message_id).css('color',FLASH_CLASS[index % FLASH_CLASS.length]);
	    	};
	    	timer = setInterval(flash,500);
	    },
	    close:function(){
	    	clearInterval(timer);
	    }
	});
};

/**
 * 显示一个窗口
 * @param {} title 标题
 * @param {} msg 窗口信息
 * @param {} time 显示时间
 * @param {} type 图标类型
 * @param {} lock 是否锁定屏幕
 */
_chenyoca_show_dialog = function(title,msg,time,type,lock){
	if(DIALOG_SHOW_DELAY_TIME) title += " ("+time+"秒后自动关闭)";
	if(lock == undefined) lock=false;
	
	art.dialog({
		lock:lock,
		time:time,
		title:title,
		content:msg,
		icon:type,
		okVal:'关闭',
		ok:true,
		esc:true
	});
};