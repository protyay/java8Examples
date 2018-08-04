package com.java.eight.practice;

import static java.util.stream.Collectors.averagingDouble;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JavaStreamAPI {
	
	public static void main(String[] args) {

		Employee john = new Employee("E123", "John Nhoj", 201.99, "IT");
		Employee south = new Employee("E223", "South Htuos", 299.99, "Sales");
		Employee reet = new Employee("E133", "Reet Teer", 300.99, "IT");
		Employee prateema = new Employee("E143", "Prateema Rai", 308.99,"Benefits");
		Employee yogen = new Employee("E323", "Yogen Rai", 290.99, "Sales");

		List<Employee> employees = Arrays.asList(john, south, reet, prateema,
				yogen);

		// calculating average -- Collectors example
		Double averageSalary = employees.stream().collect(averagingDouble(Employee::getSalary));
		System.out.println(averageSalary);
		
		//Various ways to SORT all employees by employeeId and collect it into a LIST
		Comparator<Employee> sortComparator = (a,b) -> a.getEmpId().compareTo(b.getEmpId());
		Collections.sort(employees, sortComparator);
		//1st way
		System.out.println(String.join("\n", employees.toString()));
		//2nd way - Collections.comparing // Sorted by salary
		Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary));
		System.out.println("Sorted employees by increasing order of their salary \n"+employees);
		//Sort employees in reverse order
		System.out.println("Sorted");
		
		//TODO: Group Employees by department and then find the highest salary among them.
		
	}
}

class Employee {
	private String empId;
	private String name;
	private Double salary;
	private String department;

	public Employee(String empId, String name, Double salary, String department) {
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	public String getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public Double getSalary() {
		return salary;
	}

	public String getDepartment() {
		return department;
	}

	@Override
	public String toString() {
		return "{" + "empId='" + empId + '\'' + ", name='" + name + '\''
				+ ", salary=" + salary + ", department='" + department + '\''
				+ '}';
	}
	//Contract for EQUALS
	/**
	 * is TRANSITIVE , REFLEXIVE, CONSISTENT, SYMMETRIC
	 * 
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Employee))
		return false;
		
		Employee other = (Employee) o;
		if(other.getEmpId().equals(this.getEmpId()))
			return true;
		
		return false;
		
	}
}
