package dwzcons;

import org.eweb4j.util.JsonConverter;

/**
 * DWZ的callback json对象
 * 
 * @author weiwei
 * 
 */
public class CallBackJson {
	private String statusCode = "";
	private String message = "";
	private String navTabId = "";
	private String forwardUrl = "";
	private String callbackType = "reloadTab";
	private String title = "";

	public CallBackJson() {
	}

	public CallBackJson(String error) {
		init("300", error, "", "", "reload", "");
	}
	
	public CallBackJson(String s,String statuscode) {
		init("200", s, "", "", "", "");
	}
	public CallBackJson(String statusCode, String message, String navTabId,
			String forwardUrl, String callbackType, String title) {
		this.init(statusCode, message, navTabId, forwardUrl, callbackType,
				title);
	}

	public void init(String statusCode, String message, String navTabId,
			String forwardUrl, String callbackType, String title) {
		if (statusCode == null) {
			statusCode = "200";
		} else {
			this.statusCode = statusCode;
		}
		if (message == null) {
			if ("200".equals(statusCode)) {
				message = "操作成功";
			} else if ("300".equals(statusCode)) {
				message = "操作失败";
			}
		} else {
			this.message = message;
		}
		this.navTabId = navTabId;
		this.forwardUrl = forwardUrl;
		this.title = title;

		this.callbackType = callbackType;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getForwardUrl() {
		return forwardUrl;
	}

	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}

	public String getCallbackType() {
		return callbackType;
	}

	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}

	public String getNavTabId() {
		return navTabId;
	}

	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}

	public String toString() {
		return JsonConverter.convert(this);
	}
}
