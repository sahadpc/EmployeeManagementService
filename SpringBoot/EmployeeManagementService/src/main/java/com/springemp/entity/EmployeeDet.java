package com.springemp.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employeedet")
public class EmployeeDet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	
	@Column(name = "emp_name",nullable = false)
	private String empName;
	
	@Column(name = "salary",nullable = false)
	private double salary;
	
	@Column(name = "address",nullable = false)
	private String address;
	
	
	@Column(name = "email",nullable =false)
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "credid",referencedColumnName = "credId")
	private Credentials credentials;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_emp_id",referencedColumnName = "empId")
	private List<EmployeeDependents> dependents;

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Credentials getCredentials() {
		return credentials;
	}


	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}


	public List<EmployeeDependents> getDependents() {
		return dependents;
	}


	public void setDependents(List<EmployeeDependents> dependents) {
		this.dependents = dependents;
	}
	

}
