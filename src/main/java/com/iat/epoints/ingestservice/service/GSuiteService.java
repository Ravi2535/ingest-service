package com.iat.epoints.ingestservice.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.api.services.admin.directory.model.User;

/*
 * Service Interface for GsuiteBulkUpload
 * 
 */

@Service
public interface GSuiteService {

	public List<User> pullBulkUsersFromGsuite(String org_name) throws IOException;

	public List<User> pullNewUser(String org_name) throws IOException;

	public List<User> pullDeletedUser(String org_name) throws IOException;

	public List<User> pullUpdatedUser(String org_name) throws IOException;
}
