package com.flp.ems.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public interface IEmployeeService {

	void addEmployee(HashMap<String, String> employee) throws ParseException;
	void modifyEmployee();
	void removeEmployee();
	ArrayList<HashMap<String, String>> searchEmployee(HashMap<String, String> searchEmp);
	ArrayList<HashMap<String, String>> getAllEmployee();
	
	
	
	
}
