package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDtest {

	@Test(priority=1 ,dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testPostUser(String userId,String userName,String fname,String lname,String useremail,String pwd,String phone) {

		User userPayload = new User();

		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(userName);
		userPayload.setFirstName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);

		Response response=	UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);

	}
	@Test(priority=2 ,dataProvider="UserNames",dataProviderClass=DataProviders.class)

	public void testDeleteByUser(String userName) {

		Response response1=UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response1.getStatusCode(), 200);

	}

}
