package com.payroll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFile {

	public static String EMP_FILE_PATH = "emp_payroll-data.txt";

	public void writeempdata(List<Employee> emplist) {
		StringBuffer empBuffer = new StringBuffer();
		emplist.forEach(emp -> {
			empBuffer.append(emp + "\n");
		});
		try {
			Files.write(Paths.get(EMP_FILE_PATH), empBuffer.toString().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public long countLines() {
		long count = 0;
		try {
			count = Files.lines(Paths.get(EMP_FILE_PATH)).count();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	

}
