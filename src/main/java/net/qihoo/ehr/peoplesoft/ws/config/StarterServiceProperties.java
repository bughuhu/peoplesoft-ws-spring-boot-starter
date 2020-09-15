package net.qihoo.ehr.peoplesoft.ws.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Carrot
 * @date 2020/09/14 ---------------------------------------------------- 版本 描述
 *       v1.0 Starter服务配置类
 *       <p>
 *       ----------------------------------------------------
 */
@ConfigurationProperties("peoplesoft.gateway")
public class StarterServiceProperties {

	/**
	 * 网关URL
	 */
	private String url = "http://10.18.167.41:8030/PSIGW/PeopleSoftServiceListeningConnector/PSFT_HR/";;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
