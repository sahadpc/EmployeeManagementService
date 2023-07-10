package com.springemp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "employeedependents")
public class EmployeeDependents {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int depId;
	@Column(name = "dependent_name",nullable = false)
	private String dependentName;
	
	@ManyToOne
	@JoinColumn(name = "fk_emp_id",referencedColumnName = "empId")
	@JsonIgnore
	private EmployeeDet det;
	
	
	public EmployeeDet getDet() {
		return det;
	}

	public void setDet(EmployeeDet det) {
		this.det = det;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDependentName() {
		return dependentName;
	}

	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}

	
}
