package com.springemp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springemp.entity.Credentials;
import com.springemp.entity.EmployeeDependents;
import com.springemp.entity.EmployeeDet;
import com.springemp.exception.CustomException;

import com.springemp.modal.DependentModal;
import com.springemp.modal.EmployeeReq;
import com.springemp.repository.EmployeeDendentsDao;
import com.springemp.repository.EmployeeDetDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDendentsDao depndentsDao;
	
	@Autowired
	private EmployeeDetDao dao;
	
	/*Getting All list of employee*/
	
	@Override
	public List<EmployeeDet> getAllEmployee() {
		List<EmployeeDet> list= new ArrayList<EmployeeDet>();
		list=dao.findAll();
		return list;
		}
	
	/*Delete a Employee Based On EmployeeId*/

	@Override
	public void deleteEmployee(int id) {
		EmployeeDet empdet=dao.findById(id).orElseThrow(()->new CustomException("No Such Employee present in the data base") );
		dao.deleteById(id);	
	}
	
	/*Adding Employee*/
	
	@Override
	public void saveEmployee(EmployeeReq employeeReq) {
		EmployeeDet empdet=dao.findByEmail(employeeReq.getEmail());
		if(empdet==null) {

			EmployeeDet det=new EmployeeDet();
			Credentials credentials=new Credentials();
			det.setEmpName(employeeReq.getEmpName());
			det.setAddress(employeeReq.getAddress());
			det.setSalary(employeeReq.getSalary());
			det.setEmail(employeeReq.getEmail());
			credentials.setUserName(employeeReq.getUserName());
			credentials.setPassword(employeeReq.getPassword());
			det.setCredentials(credentials);
			dao.save(det);
		}
		else {
			throw new CustomException("Employee Already Exist");
		}	
	}
	
	/*Update Employee*/

	@Override
	public void updateEmployee(EmployeeReq employeeReq, int id) {
		EmployeeDet det=dao.findById(id).orElseThrow(()->new CustomException("No Such Employee present in the data base") );		
			det.setEmpName(employeeReq.getEmpName());
			det.setAddress(employeeReq.getAddress());
			det.setEmail(employeeReq.getEmail());
			det.setSalary(employeeReq.getSalary());
			det.getCredentials().setUserName(employeeReq.getUserName());
			det.getCredentials().setPassword(employeeReq.getPassword());
			dao.save(det);
	}

	
	/*Adding Dependent*/

	@Override
	public void addDepDetails(DependentModal dependentModal, int id) {
		EmployeeDet det=dao.findById(id).get();
		if(det!=null) {
			EmployeeDependents dependents=new EmployeeDependents();
			dependents.setDependentName(dependentModal.getDepName());
			dependents.setDet(det);
			depndentsDao.save(dependents);
		}
		else {
			throw new CustomException("No Such Employee Exist In The Data Base");
		}
	}
	
	/*Show All Dependent*/

	@Override
	public List<EmployeeDependents> findAllDep(int id) {
		List<EmployeeDependents> findAllDep = new ArrayList<>();
		findAllDep = depndentsDao.findByFk_emp_id(id);
		return findAllDep;
	}
	
	/*Sort Employee*/

	@Override
	public List<EmployeeDet> sortAllEmployee() {
		List<EmployeeDet> sortedList = dao.findAllOrderBySalary();
		return sortedList;
		}

	/* Pagination for all employee*/
	
	@Override
	public Page<EmployeeDet> findPaginated(int pageNo, int pageSize) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize); 
		return this.dao.findAll(pageable);
		}

	/* Pagination for all employee sorted by salary */
	
	@Override
	public Page<EmployeeDet> findPaginatedd(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort=sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
		Sort.by(sortField).descending();
		Pageable pageable=PageRequest.of(pageNo-1, pageSize,sort); 
		return this.dao.findAll(pageable);
	}

}
