package com.iat.epoints.ingestservice.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iat.epoints.ingestservice.objects.DepartmentDataTO;
import com.iat.epoints.ingestservice.objects.UserDataTO;

public class UserTransformer implements Processor {

	public void process(Exchange exchange) throws Exception {
		System.out.println("MyProcessor started");
		ObjectMapper mapper = new ObjectMapper();
		String myString = exchange.getIn().getBody(String.class);
		JsonNode userInfo = mapper.readTree(myString);
		UserDataTO userTo = new UserDataTO();
		DepartmentDataTO department = new DepartmentDataTO();
		department.setId(1L);
		department.setName("Andy Company Test 1 Root");
		userTo.setActive(true);
		userTo.setAdminRole("ADMIN");
		userTo.setApiKey("apikeytesting");
		userTo.setBirthDate("10-06-1993");
		userTo.setCompanyStartDate("july-10-2017");
		userTo.setCreatedAt(new java.util.Date());
		userTo.setDepartment(department);
		userTo.setEmail(userInfo.get("primaryEmail").textValue());
		userTo.setEmailVerified(true);
		userTo.setEmployeeNumber("253545");
		userTo.setGender("male");
		userTo.setId("ravitejaid");
		userTo.setName(userInfo.get("name").get("familyName").textValue() + userInfo.get("name").get("givenName").textValue());
		userTo.setPartnerId(997L);
		userTo.setPassword("password");
		if (userInfo.get("isAdmin").asBoolean()) {
			userTo.setRole("ADMIN");
		}else{
			userTo.setRole("USER");
		}
		userTo.setStatus("active");
		String jsonInString = mapper.writeValueAsString(userTo);
		exchange.getIn().setBody(jsonInString);
	}
}
