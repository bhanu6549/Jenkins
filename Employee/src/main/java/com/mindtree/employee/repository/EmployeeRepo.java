package com.mindtree.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.employee.entity.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
