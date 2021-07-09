package com.hexaware.ftp49.integration.test;


import java.util.Arrays;
//import io.restassured.RestAssured;
//import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import javax.management.RuntimeErrorException;
import java.text.ParseException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import static org.junit.Assert.assertArrayEquals;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;


public class LeaveDetailsRestTest {
    @Test
    public void testPendingLeave() throws URISyntaxException,AssertionError,ParseException {
        String s1 = "2018-07-10";
        String s2 = "2018-08-08";
        String s3 = "2018-08-14";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        LeaveDetails lev[] = given()
        .accept(ContentType.JSON)
        .when()
        .get(CommonUtil.getURI("/api/leavedetailsrest/2001/datafetch"))
        .getBody()
        .as(LeaveDetails[].class);
        LeaveDetails leav[] = new LeaveDetails[1];
        leav[0] = new LeaveDetails(3001,6,sf.parse(s1),6,sf.parse(s2),sf.parse(s3),LeaveType.EL,"BROTHER WEDDING",LeaveStatus.PENDING,"NOT YET PROCESSED");
        assertArrayEquals(leav,lev); 
    }        
}
    
      

public class LeaveDetailsRestTest {

@Test
public void postapply() throws AssertionError,ParseException {
String d1 = "2018-09-27";
String d2 = "2018-09-30";

Date leaveStartDate = new SimpleDateFormat("yyyy-MM-dd").parse(d1);
Date leaveEndDate = new SimpleDateFormat("yyyy-MM-dd").parse(d2);

given().accept(ContentType.JSON).with()
.body("{\"leaveStartDate\":leaveStartDate, \"leaveEndDate\":leaveEndDate}")
.expect().body("calculated", notNullValue()).when()
.post("http://localhost:8080/FTP49-0.0.1-SNAPSHOT/api/leavedetailsrest/insertdata")
.then().
log().everything();
}
}
	@Test
	public final void testPOST() throws ParseException{
        given()
		.contentType(ContentType.JSON)
		.body(new HashMap<String,Object>() {{ 
        put("empId", "2000");
		put("leaveId", "0");
		put("leaveAppliedOn","2018-08-10");
		put("leaveDaysLeft", "3");
        put("leaveStartDate","2018-08-21");
        put("leaveEndDate", "2018-08-23");
        put("leaveType", "EL");
        put("leaveReason", "SICK");
        put("leaveStatus", "PENDING");
        put("leaveManagerComments", "NOT YET PROCESSED");
        }})
		.when()
		.post("http://localhost:8080/FTP49-0.0.1-SNAPSHOT/api/leavedetailsrest/Updation/2000")
		.then()
	    .statusCode(200).
		log().everything();
	}
}
   

public class LeaveDetailsRestTest {
    @Test
    public void testPendingLeave() throws URISyntaxException,AssertionError,ParseException {
        String s1 = "2018-07-10";
        String s2 = "2018-08-08";
        String s3 = "2018-08-14";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        LeaveDetails lev[] = given()
        .accept(ContentType.JSON)
        .when()
        .get(CommonUtil.getURI("/api/leavedetailsrest/2001/datafetch"))
        .getBody()
        .as(LeaveDetails[].class);
        LeaveDetails leav[] = new LeaveDetails[1];
        leav[0] = new LeaveDetails(3001,6,sf.parse(s1),6,sf.parse(s2),sf.parse(s3),LeaveType.EL,"BROTHER WEDDING",LeaveStatus.PENDING,"NOT YET PROCESSED");
        assertArrayEquals(leav,lev); 
    }        
}
    
      

