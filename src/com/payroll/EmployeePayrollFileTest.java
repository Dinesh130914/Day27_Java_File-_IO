package com.payroll;

import static org.junit.Assert.*;

import org.junit.Test;

import com.payroll.Service.IOStream;

public class EmployeePayrollFileTest {

	@Test
	public void test() {
		Employee[] empsData = { 
				new Employee(1, "Jeff Bezos", 100000), 
				new Employee(2, "Mark Zukerberg", 200000),
				new Employee(4, "Bill Gates", 400000),
				new Employee(3, "Elon Musk", 300000), };

		Service service = new Service(empsData);
		service.readempdata(IOStream.FILE_IO);
		service.writeempdata(IOStream.FILE_IO);
		long count = service.countentries();
		System.out.println("Number of entries :" + count);
		assertEquals(4, count);
	}

	@Test
	public void getEmployeeDataFromFile() {
		EmployeePayrollFile employeePayrollFile = new EmployeePayrollFile();
		System.out.println(employeePayrollFile.getEmpPayrollData().size());
		int length = employeePayrollFile.getEmpPayrollData().size();
		System.out.println(length);
		assertEquals(4, length);
	}

}
