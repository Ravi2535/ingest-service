package com.iat.epoints.ingestservice.objects;

public enum UserRole { 
	manager("MANAGER"), user("USER"); 
	
	private String value; 
	
	private UserRole(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static UserRole getRole(String val) {	
		
		for (UserRole s: UserRole.values()) {
			if (s.getValue().equalsIgnoreCase(val))
				return s;
		}
		return null;
	}
}
