package com.flp.ems.domain;

import java.util.Date;

public class Employee {

//	private static long employeeId;
	private long phoneNumber;
	private String name, kinId, emailId, addres;
	private Date joiningDate, birthDate;
	private long departmentId, projectId, roleId;
	
	/*static {
		employeeId++;
	}


	public static long getEmployeeId() {
		return employeeId;
	}*/


	public long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getKinId() {
		return kinId;
	}


	public void setKinId(String kinId) {
		this.kinId = kinId;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getAddres() {
		return addres;
	}


	public void setAddres(String addres) {
		this.addres = addres;
	}


	public Date getJoiningDate() {
		return joiningDate;
	}


	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public long getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(Long long1) {
		this.departmentId = long1;
	}


	public long getProjectId() {
		return projectId;
	}


	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}


	public long getRoleId() {
		return roleId;
	}


	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
		
}
