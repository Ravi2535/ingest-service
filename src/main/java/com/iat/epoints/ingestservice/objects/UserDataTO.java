package com.iat.epoints.ingestservice.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@JsonInclude(content = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDataTO {

    private String id;
    private String employeeNumber;

    @NotBlank(message = "may not be blank")
    private String email;

    private String name;
    private String gender;
    private String birthDate;
    private Date createdAt;

    @NotNull(message = "may not be empty")
    private DepartmentDataTO department;
    private String role;
    private String adminRole;
    private String status;    
    private String companyStartDate;
    private boolean active;
    private String password;
    private Boolean emailVerified;
    private Long partnerId;
    private String apiKey;
    
    private List<EmailUpdateTO> emailChanges;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public DepartmentDataTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDataTO department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public String getCompanyStartDate() {
		return companyStartDate;
	}

	public void setCompanyStartDate(String companyStartDate) {
		this.companyStartDate = companyStartDate;
	}

	public List<EmailUpdateTO> getEmailChanges() {
		return emailChanges;
	}

	public void setEmailChanges(List<EmailUpdateTO> emailChanges) {
		this.emailChanges = emailChanges;
	}
}
