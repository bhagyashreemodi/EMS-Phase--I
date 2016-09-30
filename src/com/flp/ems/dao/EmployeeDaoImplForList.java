package com.flp.ems.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.flp.ems.domain.Employee;

public class EmployeeDaoImplForList implements IEmployeeDao{

	ArrayList<Employee> employees = new ArrayList<Employee>();
	
	
	@Override
	public void addEmployee(Employee employee) {
		
		employees.add(employee);
	}

	@Override
	public boolean modifyEmployee(Employee modifyEmployee) {
		
		if(modifyEmployee != null){
			String token[] = modifyEmployee.getKinId().split("_");
			System.out.println(token[0]);
			int index = Integer.parseInt(token[0]);
			employees.set(index-1, modifyEmployee);
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean removeEmployee(String kinId) {
		
		if(kinId != null){
			String token[] = kinId.split("_");
			int index = Integer.parseInt(token[0]);
			
			employees.remove(index-1);
			return true;
		}
		else{
			return false;
		}
		
		
		
	}

	@Override
	public ArrayList<Employee> searchEmployee(Employee employee) {
		
		ArrayList<Employee> empl = new ArrayList<Employee>();
		
		for (Employee entry : employees) {
			if(entry.getKinId().equalsIgnoreCase(employee.getKinId()) || entry.getEmailId().equalsIgnoreCase(employee.getEmailId()) || entry.getName().equalsIgnoreCase(employee.getName())){
				
				empl.add(entry);
			}
			
		}
		
		return empl;
		
	}

	@Override
	public ArrayList getAllEmployee() {
		return employees;
		
		
		
	}

	@Override
	public Employee getEmpForModification(String kinId) {
		
		for (Employee employee : employees) {
			if(employee.getKinId().equals(kinId)){
				return employee;
			}
			
		}
		return null;
	}

	

	

	
	
	
	
}
