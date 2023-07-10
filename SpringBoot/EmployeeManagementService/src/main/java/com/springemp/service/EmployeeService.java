package com.springemp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.springemp.entity.EmployeeDependents;
import com.springemp.entity.EmployeeDet;
import com.springemp.modal.DependentModal;
import com.springemp.modal.EmployeeReq;

public interface EmployeeService {
	public List<EmployeeDet> getAllEmployee();
	public void  deleteEmployee( int id);
	public void saveEmployee(EmployeeReq employeeReq);
	public void updateEmployee(EmployeeReq employeeReq,int id);
	public void addDepDetails(DependentModal dependentModal, int id);
	public List<EmployeeDependents> findAllDep(int id);
	public List<EmployeeDet> sortAllEmployee();
	public Page<EmployeeDet> findPaginated(int pageNo,int pageSize);
	public Page<EmployeeDet> findPaginatedd(int pageNo,int pageSize,String sortField,String sortDirection);
	

}
