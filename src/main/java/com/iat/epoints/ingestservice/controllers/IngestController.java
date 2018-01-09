package com.iat.epoints.ingestservice.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.admin.directory.model.User;
import com.iat.epoints.ingestservice.expections.ResourceNotFoundException;
import com.iat.epoints.ingestservice.objects.IngestUserTo;
import com.iat.epoints.ingestservice.objects.RestUserTO;
import com.iat.epoints.ingestservice.service.GSuiteService;

/**
 * CamelController class creates RestFul Endpoint that the Apache camel consume
 * and create a route for Json Formatted Data.
 *
 */

@RestController
@RequestMapping(value = "/ingest")
public class IngestController {

	private static Logger logger = LoggerFactory.getLogger(IngestController.class);

	@Autowired
	private GSuiteService gSuiteService;

	@Autowired
	private ProducerTemplate producerTemplate;

	@Autowired
	ObjectMapper mapper;

	//bulk pull
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> ingestGsuiteUsersToSQS(@RequestParam("org_name") String org_name) throws IOException {
		logger.info("CamelController.pullUsersFromGSuite() Successfully Got all the users from Gsuite ");
		List<IngestUserTo> listTo = new ArrayList<IngestUserTo>();
		List<User> gsuiteList = gSuiteService.pullBulkUsersFromGsuite(org_name);
		if (gsuiteList == null || gsuiteList.size() == 0) {
			throw new ResourceNotFoundException("No User Data Found");
		} else {
			for (User user : gsuiteList) {
				System.out.println(user.getPrimaryEmail() + ":" + user.getIsAdmin());
			}
		}
		for (User user : gsuiteList) {
			producerTemplate.sendBody("direct:ingestRoute", mapper.writeValueAsString(user));
		}
		return new ResponseEntity<Object>(listTo, HttpStatus.OK);
	}
	
	//new user
	@RequestMapping(value = "/users/newusers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> ingestNewlyAddedUsersGsuiteUsersToSQS(@RequestParam("org_name") String org_name)
			throws IOException {
		logger.info(
				"CamelController.ingestNewlyAddedUsersGsuiteUsersToSQS() Successfully Got all the new users from Gsuite ");
		List<User> listTo = new ArrayList<User>();
		List<User> gsuiteList = gSuiteService.pullNewUser("suv");
		if (gsuiteList == null || gsuiteList.size() == 0) {
			throw new ResourceNotFoundException("No User Data Found");
		}
		for (User user : gsuiteList) {
			producerTemplate.sendBody("direct:newUser", mapper.writeValueAsString(user));
			listTo.add(user);
		}
		return new ResponseEntity<Object>(listTo, HttpStatus.OK);
	}
	
	//edit users
	@RequestMapping(value = "/users/updatedusers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listenUpdatedUsersFromGsuiteToSQS(@RequestParam("org_name") String org_name)
			throws IOException {
		List<User> updatedUsers = gSuiteService.pullUpdatedUser("suv");
		if (updatedUsers == null || updatedUsers.size() == 0) {
			throw new ResourceNotFoundException("No User Data Found");
		}
		for (User user : updatedUsers) {
			IngestUserTo userTo = new IngestUserTo();
			userTo.setFirstName(user.getName().getGivenName());
			userTo.setLastName(user.getName().getFamilyName());
			userTo.setEmail(user.getPrimaryEmail());
			if (userTo != null) {
				producerTemplate.sendBody("direct:editedUser", mapper.writeValueAsString(userTo));
			}
		}
		return new ResponseEntity<Object>(updatedUsers, HttpStatus.OK);
	}
	

	// delete users
	@RequestMapping(value = "/users/deletedusers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listenDeletedUsersFromGsuiteToSQS(@RequestParam("org_name") String org_name)
			throws IOException {
		List<User> deletedUsers = gSuiteService.pullDeletedUser(org_name);
		if (deletedUsers == null || deletedUsers.size() == 0) {
			throw new ResourceNotFoundException("No User Data Found");
		}
		for (User user : deletedUsers) {
			RestUserTO deleteUser = new RestUserTO();
			deleteUser.setUsername(user.getPrimaryEmail());
				producerTemplate.sendBody("direct:deletedUser", mapper.writeValueAsString(deleteUser));
		}
		return new ResponseEntity<Object>(deletedUsers, HttpStatus.OK);
	}

}