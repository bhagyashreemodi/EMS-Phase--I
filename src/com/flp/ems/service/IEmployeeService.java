package com.flp.ems.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public interface IEmployeeService {

	void addEmployee(HashMap<String, String> employee) throws ParseException;
	boolean modifyEmployee(HashMap<String, String> modifyEmp);
	boolean removeEmployee(HashMap<String, String> remEmployeeMap);
	ArrayList<HashMap<String, String>> searchEmployee(HashMap<String, String> searchEmp);
	ArrayList<HashMap<String, String>> getAllEmployee();
	
	
	
	
	
	
	
}
