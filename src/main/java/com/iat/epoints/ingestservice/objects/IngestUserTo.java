package com.iat.epoints.ingestservice.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(content = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IngestUserTo {

	private String firstName;
	private String lastName;
	private String email;
	private boolean isAdmin;

	public IngestUserTo() {
		super();
	}

	public IngestUserTo(String firstName, String lastName, String email, boolean isAdmin) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.isAdmin = isAdmin;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
