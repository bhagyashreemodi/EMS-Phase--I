package com.flp.ems.dao;

import java.util.ArrayList;

import com.flp.ems.domain.Employee;

public class EmployeeDaoImplForList implements IEmployeeDao{

	ArrayList<Employee> employees = new ArrayList<Employee>();
	
	
	@Override
	public void addEmployee(Employee employee) {
		
		employees.add(employee);
	}

	@Override
	public void modifyEmployee() {
		
		
	}

	@Override
	public void removeEmployee() {
		
		
	}

	@Override
	public ArrayList<Employee> searchEmployee(Employee employee) {
		
		ArrayList<Employee> empl = new ArrayList<Employee>();
		
		for (Employee entry : employees) {
			if(entry.getKinId().equals(employee.getKinId()) || entry.getEmailId().equals(employee.getEmailId()) || entry.getName().equals(employee.getName())){
				
				empl.add(entry);
			}
			
		}
		
		return empl;
		
	}

	@Override
	public ArrayList getAllEmployee() {
		return employees;
		
		
		
	}

	
	
	
	
}
