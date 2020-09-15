package net.qihoo.ehr.peoplesoft.ws.service;

import java.io.IOException;
import java.util.HashMap;

import net.qihoo.ehr.peoplesoft.ws.util.HttpUtil;
import net.qihoo.ehr.peoplesoft.ws.util.JsonUtil;
import net.sf.json.JSONObject;

public class PeopleSoftHttpService {

	private String gatewayUrl;

	/**
	 * 构造函数
	 * 
	 * @param properties
	 */
	public PeopleSoftHttpService(String gatewayUrl) {
		this.gatewayUrl = gatewayUrl;
	}

	/**
	 * 原始请求
	 * 
	 * @param soapAction
	 * @param requestStr
	 * @return
	 * @throws IOException
	 */
	public JSONObject post(String soapAction, String requestStr) throws IOException {

//		String gatewayUrl="http://10.18.167.41:8030/PSIGW/PeopleSoftServiceListeningConnector/PSFT_HR/";

		String response = HttpUtil.post(this.gatewayUrl, soapAction, requestStr);

		return JsonUtil.xmlString2Json(response);
	}

	/**
	 * 
	 * @param soapAction
	 * @param requestBody
	 * @return
	 */
	public JSONObject postBody(String soapAction, RequestBody requestBody) {

		try {

			HashMap<String, String> map = new HashMap<String, String>();
			map.put("OPERATOR_ID", requestBody.getOperatorId());
			map.put("SYSTEM_ID", requestBody.getSystemId());
			map.put("MODULE_NAME", requestBody.getModuleName());
			map.put("OPERATION_NAME", requestBody.getOperationName());
			map.put("REQUEST", requestBody.getRequestBody());

			JSONObject jsonObject = JSONObject.fromObject(map);

			// 请求
			JSONObject response = this.post(soapAction, jsonObject.toString());

			return response.getJSONObject("RESPONSE");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 带安全头的POST请求
	 * 
	 * @param soapAction
	 * @param requestBody
	 * @return
	 */
	public JSONObject postSecurityBody(String soapAction, RequestBody requestBody) {

		return null;
	}

}
