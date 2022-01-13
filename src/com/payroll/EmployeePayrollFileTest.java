package com.payroll;

import static org.junit.Assert.*;

import org.junit.Test;

import com.payroll.Service.IOStream;

public class EmployeePayrollFileTest {

	@Test
	public void test() {
		Employee[] empsData = { new Employee(1, "Jeff Bezos", 100000), new Employee(2, "Mark Zukerberg", 200000),
				new Employee(4, "Bill Gates", 400000), new Employee(3, "Elon Musk", 300000), };
				
		Service service = new Service(empsData);
		service.writeempdata(IOStream.FILE_IO);
		long count = service.countentries();
		System.out.println(count);
		assertEquals(12,count);
	}

}
