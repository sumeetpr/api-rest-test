package org.spr.helpers;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.spr.costants.EndPoints;
import org.spr.models.PersonPojo;
import org.spr.utils.ConfigManager;
import org.testng.Assert;
import java.util.List;



public class PersonServiceHelper {

private static final String BASE_URL = ConfigManager.getInstance().getProperty("baseUrl");
    private static final String PORT = ConfigManager.getInstance().getProperty("port");

public PersonServiceHelper(){
    RestAssured.baseURI = BASE_URL;
    RestAssured.port= Integer.parseInt(PORT);
    RestAssured.useRelaxedHTTPSValidation();
}

public List<PersonPojo> getAllPersons(){

    Response res = RestAssured.given().log().all().when().get(EndPoints.GET_ALL_PERSONS).thenReturn();

    List<PersonPojo> personList = res.as(new TypeReference<List<PersonPojo>>(){}.getType());

    Assert.assertEquals(res.statusCode(), HttpStatus.SC_OK);

    return personList;

}
}
