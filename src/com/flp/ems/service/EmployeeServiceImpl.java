package com.flp.ems.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.domain.Employee;

public class EmployeeServiceImpl implements IEmployeeService{

	
	EmployeeDaoImplForList employees = new EmployeeDaoImplForList();
	
	@Override
	public void addEmployee(HashMap<String, String> employeeInfo) throws ParseException {
		
		Employee employee = new Employee();
		employee.setName(employeeInfo.get("name"));
		employee.setKinId(employeeInfo.get("kinId"));
		employee.setEmailId(employeeInfo.get("emailId"));
		employee.setPhoneNumber(Long.valueOf(employeeInfo.get("phoneNumber")));
		employee.setAddres(employeeInfo.get("address"));
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date birthDate = format.parse(employeeInfo.get("birthDate"));
		employee.setBirthDate(birthDate);
		Date joiningDate = format.parse(employeeInfo.get("joiningDate"));
		employee.setJoiningDate(joiningDate);
		employee.setDepartmentId(Long.valueOf(employeeInfo.get("departmentId")));
		employee.setProjectId(Long.valueOf(employeeInfo.get("projectId")));
		employee.setRoleId(Long.valueOf(employeeInfo.get("roleId")));
		employees.addEmployee(employee);
	
	}
	

	@Override
	public boolean modifyEmployee(HashMap<String, String> modifyEmp) {
		
		ArrayList<Employee> employees = this.employees.getAllEmployee();
		Employee modifyEmployee = this.employees.getEmpForModification(modifyEmp.get("kinId"));
		if(modifyEmployee == null){
			return false;
		}
		if(modifyEmp.containsKey("phoneNumber")){
			modifyEmployee.setPhoneNumber(Long.parseLong(modifyEmp.get("phoneNumber")));
		}
		if(modifyEmp.containsKey("address")){
			modifyEmployee.setAddres(modifyEmp.get("address"));
		}
		return this.employees.modifyEmployee(modifyEmployee);
	}

	@Override
	public boolean removeEmployee(HashMap<String, String> remEmployeeMap) {
		
		Employee employee = new Employee();
		employee.setName(remEmployeeMap.get("name"));
		employee.setKinId(remEmployeeMap.get("kinId"));
		employee.setEmailId(remEmployeeMap.get("emailId"));
		ArrayList<Employee> employeesArr = this.employees.searchEmployee(employee);
		if(employeesArr == null){
			System.out.println("No such employee found");
		}
		else{
			System.out.println("Do u want to delete?\n1.yes\n2. no");
			if(new Scanner(System.in).nextInt() == 1){
				
				for (Employee employee2 : employeesArr) {
					boolean flag = this.employees.removeEmployee(employee2.getKinId());
					if(flag == false){
						return false;
					}
					else{
						continue;
					}
				}
			}
			else{
				return false;
				
			}
		}
		return true;
	}

	@Override
	public ArrayList<HashMap<String, String>> searchEmployee(HashMap<String, String> employeeInfo) {
		Employee employee = new Employee();
		employee.setName(employeeInfo.get("name"));
		employee.setKinId(employeeInfo.get("kinId"));
		employee.setEmailId(employeeInfo.get("emailId"));
		ArrayList<Employee> employeesArr = this.employees.searchEmployee(employee);
		ArrayList	<HashMap<String, String>> employeesMap = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < employeesArr.size(); i++) {
			HashMap<String,String> map = new HashMap<String, String>();
			map.put("kinId", (employeesArr.get(i).getKinId()));
			map.put("emailId", (employeesArr.get(i).getEmailId()));
			map.put("name", (employeesArr.get(i).getName()));
			employeesMap.add(map);
		}
		return employeesMap;
	}

	@Override
	public ArrayList<HashMap<String, String>> getAllEmployee() {
		ArrayList<Employee> employeesArr = this.employees.getAllEmployee();
	ArrayList	<HashMap<String, String>> employeesMap = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < employeesArr.size(); i++) {
			HashMap<String,String> map = new HashMap<String, String>();
			map.put("kinId", (employeesArr.get(i).getKinId()));
			map.put("emailId", (employeesArr.get(i).getEmailId()));
			map.put("name", (employeesArr.get(i).getName()));
			employeesMap.add(map);
		}
		return employeesMap;
	}

}
