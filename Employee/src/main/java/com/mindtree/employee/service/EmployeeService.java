package com.mindtree.employee.service;

import java.util.List;

import com.mindtree.employee.entity.Employee;

public interface EmployeeService {

	List<Employee> listAll();

	void save(Employee employee);

	Employee get(long id);

	void delete(long id);

}
