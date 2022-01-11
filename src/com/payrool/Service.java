package com.payrool;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
	List<Employee> servicelist;

	public Service() {
		servicelist = new ArrayList<>();
	}

	public static void main(String[] args) {
		Service service = new Service();
		service.readinputfromconsole();
		service.printservicelist();
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
	public void printservicelist() 
	{
		System.out.println(servicelist);
	}
}
