package com.payroll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Service {
	enum IOStream{
		CONSOLE_IO, FILE_IO,
	}
	List<Employee> servicelist;

	public Service() {
		servicelist = new ArrayList<>();
	}

	public Service(Employee[] empsData) {
		servicelist = Arrays.asList(empsData);
	}

	public static void main(String[] args) {
		Service service = new Service();
		service.readinputfromconsole();
		service.writeempdata(IOStream.CONSOLE_IO);
	}
	
	public void readinputfromconsole() 
	{
		Scanner consolescn = new Scanner(System.in);
		System.out.println("Enter the id");
		int id = consolescn.nextInt();
		
		System.out.println("Enter the name");
		String name = consolescn.next();
		
		System.out.println("Enter the salary");
		double salary = consolescn.nextInt();
		servicelist.add(new Employee(id, name, salary));
		
		consolescn.close();
	}
	public void writeempdata(IOStream iOStream) 
	{
		if(iOStream.equals(iOStream.CONSOLE_IO)) 
		{
			System.out.println("Employee Payroll Details"+servicelist);
		}else if(iOStream.equals(iOStream.FILE_IO)) {
			EmployeePayrollFile service =new EmployeePayrollFile();
			service.writeempdata(servicelist);
		}
	}
	
	public long countentries() {
		long count = 0;
		EmployeePayrollFile employeePayrollFile = new EmployeePayrollFile();
		count = employeePayrollFile.countLines();
		return count;
	}

	
}
