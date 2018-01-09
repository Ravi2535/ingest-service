package com.iat.epoints.ingestservice.objects;

import com.google.common.collect.Lists;

import java.util.List;

public enum UserAdminRole {
	superAdmin("SUPER_ADMIN"), admin("ADMIN"), none("NONE");
	
	private String value; 
	
	private UserAdminRole(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static List<UserAdminRole> getAdminRoles() {
		return Lists.newArrayList(superAdmin, admin);
	}
	
	public static UserAdminRole getRole(String val) {
		for (UserAdminRole s: UserAdminRole.values()) {			
			if (s.getValue().equalsIgnoreCase(val))
				return s;

		}
		return null;
	}	
}