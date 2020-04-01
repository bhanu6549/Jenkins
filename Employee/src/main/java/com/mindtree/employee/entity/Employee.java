package com.mindtree.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String location;
	private double salary;
	public Employee()
	{
		
	}
	public Employee(long id,String name, String location, double salary) {
		super();
		this.id=id;
		this.name = name;
		this.location = location;
		this.salary = salary;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
