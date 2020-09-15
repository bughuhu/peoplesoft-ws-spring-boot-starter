package net.qihoo.ehr.peoplesoft.ws.service;

/**
 * 请求体
 * 
 * @author huguobiao
 *
 */
public class RequestBody {
	
	/**
	 * 当前操作人
	 */
	private String operatorId;
	
	/**
	 * 调用方ID
	 */
	private String systemId;
	
	/**
	 * 模块名
	 */
	private String moduleName;
	
	/**
	 * 操作方法
	 */
	private String operationName;
	
	/**
	 * 请求字符串
	 */
	private String requestBody;

	
	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}
	
}
