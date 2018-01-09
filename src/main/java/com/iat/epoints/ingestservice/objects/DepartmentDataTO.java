package com.iat.epoints.ingestservice.objects;

import org.hibernate.validator.constraints.NotBlank;

public class DepartmentDataTO {
	
	@NotBlank
	private Long id;
	
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
