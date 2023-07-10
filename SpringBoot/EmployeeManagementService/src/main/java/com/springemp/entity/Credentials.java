package com.springemp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "credentials")
public class Credentials {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int credId;
	@Column(name = "user_name",nullable = false)
	private String userName;
	@Column(name = "password",nullable = false)
	private String password;
	
	@OneToOne(mappedBy = "credentials")
	//@JoinColumn(name = "userId"/* ,referencedColumnName = "userId" */)
	private EmployeeDet employeeDet;

	

	public int getCredId() {
		return credId;
	}

	public void setCredId(int credId) {
		this.credId = credId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
