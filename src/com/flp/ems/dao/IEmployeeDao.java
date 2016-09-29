package com.flp.ems.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import com.flp.ems.domain.Employee;

public interface IEmployeeDao {

	void addEmployee(Employee employee);
	void modifyEmployee();
	void removeEmployee();
	ArrayList<Employee> searchEmployee(Employee employee);
	ArrayList<Employee> getAllEmployee();
	
	
}
