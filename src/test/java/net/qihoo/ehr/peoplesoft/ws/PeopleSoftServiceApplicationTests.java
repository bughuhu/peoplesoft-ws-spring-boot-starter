package net.qihoo.ehr.peoplesoft.ws;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.qihoo.ehr.peoplesoft.ws.service.PeopleSoftHttpService;
import net.sf.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeopleSoftServiceApplicationTests {

	@Autowired
	private PeopleSoftHttpService peopleSoftHttpService;

	@Test
	public void test1() throws IOException {

		System.out.println("---------------");

		String requestStr = "";

		requestStr = "{\"QH_APP_INT_001_REQUEST\":{\"OPERATOR_ID\":\"Q016260\",\"TRANSACTION_NAME\":\"QH_HR_019\",\"OPERATION_NAME\":\"DoProcessInstance\",\"REQUEST\":\"{\\\"instance_id\\\":\\\"7504\\\"}\"}}";

		JSONObject reponse = peopleSoftHttpService.post("QH_APP_01_ACTION.v1", requestStr);
		
		System.out.println(reponse.toString());
	}
}
