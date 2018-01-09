package com.iat.epoints.ingestservice.objects;

import javax.validation.constraints.NotNull;

public class RestUserTO {
	
	@NotNull
	private UserRole userRole;
	
	@NotNull
	private UserAdminRole userAdminRole;
	
	@NotNull
	private Long partnerId;
	
	@NotNull
	private String username;
	
	@NotNull
	private String partnerApiKey;
	
	private Long departmentId;
	
	@NotNull
	private String uuid;

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPartnerApiKey() {
		return partnerApiKey;
	}
	public void setPartnerApiKey(String partnerApiKey) {
		this.partnerApiKey = partnerApiKey;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
		
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public UserAdminRole getUserAdminRole() {
		return userAdminRole;
	}
	public void setUserAdminRole(UserAdminRole userAdminRole) {
		this.userAdminRole = userAdminRole;
	}
	@Override
	public String toString() {
		return "RestUserTO [userRole=" + userRole + ", userAdminRole="
				+ userAdminRole + ", partnerId=" + partnerId + ", username="
				+ username + ", departmentId=" + departmentId + ", uuid="
				+ uuid + "]";
	}
}
