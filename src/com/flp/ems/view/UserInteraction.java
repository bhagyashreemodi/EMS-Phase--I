package com.flp.ems.view;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.util.Validate;

public class UserInteraction {

	
	static int id;
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
	public void addEmployee() {
		String name, kinId, emailId, phoneNumber, address, birthDate, joiningDate, departmentId, projectId, roleId;
		HashMap<String, String> employee= new HashMap<String, String>();
		System.out.println("Enter Your personal information:");
		Scanner information = new Scanner(System.in);
		System.out.println("Name:");
		name = information.nextLine();
		System.out.println("Phone Number:");
		phoneNumber = information.nextLine();
		System.out.println("Address:");
		address = information.nextLine();
		System.out.println("Date of birth(dd/mm/yyyy):");
		birthDate = information.nextLine();
		try {
			Validate.validateDate(birthDate);
		} catch (Exception e1) {
			
			e1.printStackTrace();
			System.out.println("Date of birth(dd/mm/yyyy):");
			birthDate = information.nextLine();
		}
		System.out.println("Date of joining(dd/mm/yyyy):");
		joiningDate = information.nextLine();
		try {
			Validate.validateDate(joiningDate);
		} catch (Exception e1) {
			
			e1.printStackTrace();
			System.out.println("Date of joining(dd/mm/yyyy):");
			joiningDate = information.nextLine();
		}
		id++;
		kinId = id + "_FS";
		emailId = kinId + "." + name + "@barclays.com";
		System.out.println("Please select one of the following departments :\n1. Barclaycard\n2. PCB");
		departmentId = information.nextLine();
		System.out.println("Please select one of the following Projects :\n1. CWS\n2. BAPI");
		projectId = information.nextLine();
		System.out.println("Please select one of the following Roles :\n1. BA3\n2. BA4");
		roleId = information.nextLine();
		employee.put("name", name);
		employee.put("kinId", kinId);
		employee.put("emailId", emailId);
		employee.put("phoneNumber", phoneNumber);
		employee.put("address", address);
		employee.put("birthDate", birthDate);
		employee.put("joiningDate", joiningDate);
		employee.put("departmentId", departmentId);
		employee.put("projectId", projectId);
		employee.put("roleId", roleId);
		try {
			
			employeeService.addEmployee(employee);
		} catch (ParseException e) {
			
			e.printStackTrace();
			addEmployee();
		}
	}

	public static void ModifyEmployee() {
		
		System.out.println("Please provide the ");
	}

	public static void RemoveEmployee() {
		
		
	}

	public void SearchEmployee() {
		
		System.out.println("Please select a search criteria from the following menu:\n1.Only name\n2.Only Kin Id\n3.Only Email  Id\n4. name and kin Id\n5. name and email id\n6. email and kin id\n7. all three\n");
		Scanner search = new Scanner(System.in);
		int choice = search.nextInt();
		HashMap<String,String> searchEmp = new HashMap<String, String>();
		switch(choice){
		case 1:
			System.out.println("Name:");
			searchEmp.put("name", new Scanner(System.in).nextLine());
			break;
		case 2:
			System.out.println("Kin Id:");
			searchEmp.put("kinId", new Scanner(System.in).nextLine());
			break;
			
		case 3:
			System.out.println("Email Id:");
			searchEmp.put("emailId",new Scanner(System.in).nextLine());
			break;
		case 4:
			System.out.println("Kin Id:");
			searchEmp.put("kinId", new Scanner(System.in).nextLine());
			System.out.println("Name:");
			searchEmp.put("name", new Scanner(System.in).nextLine());
			break;
		case 5:
			System.out.println("Email Id:");
			searchEmp.put("emailId", search.nextLine());
			System.out.println("Name:");
			searchEmp.put("name", new Scanner(System.in).nextLine());
			break;
		case 6:
			System.out.println("Kin Id:");
			searchEmp.put("kinId",new Scanner(System.in).nextLine());
			System.out.println("Email Id:");
			searchEmp.put("emailId", new Scanner(System.in).nextLine());
			break;
		case 7:
			System.out.println("Kin Id:");
			searchEmp.put("kinId",new Scanner(System.in).nextLine());
			System.out.println("Email Id:");
			searchEmp.put("emailId", new Scanner(System.in).nextLine());
			System.out.println("Name:");
			searchEmp.put("name", new Scanner(System.in).nextLine());
			break;
		
		default :
				System.out.println("Please enter valid option");
				SearchEmployee();
		}
		ArrayList<HashMap<String, String>> employeeMap = this.employeeService.searchEmployee(searchEmp);
		if(employeeMap.size() == 0){
			System.out.println("The required employee does not exist");
			
		}
		else{
			System.out.println(employeeMap.get(0).entrySet().toString());
		}
	}

	public void getAllEmployee() {
	
		ArrayList<HashMap<String, String>> employeesList = employeeService.getAllEmployee();
		System.out.println(employeesList.get(0).entrySet().toString());
		
		
		
		
		
		
	}

}
