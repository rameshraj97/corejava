package com.chainsys.minproject.test;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.chainsys.minproject.dao.EmployeeDao;
import com.chainsys.minproject.pojo.Employee;
public class TestEmployeeDao {
	public static void testGetAllEmployees() {
		List<Employee> allEmployees = EmployeeDao.getAllEmployee();
		Iterator<Employee> empIterator = allEmployees.iterator();
		while(empIterator.hasNext()) {
			Employee emp = empIterator.next();
			System.out.println(emp.getEmp_Id()+" "+emp.getFirst_name()+" "+emp.getSalary());
		}
	}
public static void testGetEmployeeById() {
	Employee emp = EmployeeDao.getEmployeeById(126);
	System.out.println(emp.getEmp_Id()+" "+emp.getFirst_name()+" "+emp.getSalary());
}
public static void testInsertEmployee() {
	Employee newemp = new Employee();
	newemp.setEmp_Id(300);
	newemp.setFirst_name("Ana");
	newemp.setLast_name("Rose");
	newemp.setEmail("ana23@mail.com");
	Calendar c1 = Calendar.getInstance();
	java.util.Date newDate =c1.getTime();
	newemp.setHire_date(newDate);
	newemp.setJob_id("IT_PROG");
	newemp.setSalary(240000);
	int result = EmployeeDao.insertEmployee(newemp);
	System.out.println(result);
	
}
public static void testUpdateEmployee() {
	Employee oldEmployee = EmployeeDao.getEmployeeById(126);
	System.out.println(oldEmployee.getEmp_Id()+" "+oldEmployee.getFirst_name()+" "+oldEmployee.getSalary());
	oldEmployee.setFirst_name("ramesh");
	oldEmployee.setLast_name("Joe");
	oldEmployee.setEmail("Jeolil@mail.com");
	Calendar c1 = Calendar.getInstance();
	java.util.Date newDate =c1.getTime();
	oldEmployee.setHire_date(newDate);
	oldEmployee.setJob_id("IT_PROG");
	oldEmployee.setSalary(24000);
	int result = EmployeeDao.updateEmployee(oldEmployee);
	System.out.println(result);
	
}
public static void testDeleteEmployee() {
	int result = EmployeeDao.deleteEmployee(126);
	System.out.println(result);
}
}

    