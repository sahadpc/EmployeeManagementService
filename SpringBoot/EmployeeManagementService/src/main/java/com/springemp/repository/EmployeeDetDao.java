package com.springemp.repository;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springemp.entity.EmployeeDet;

@Repository
public interface EmployeeDetDao extends JpaRepository<EmployeeDet, Integer> {
	
	@Query(value = "SELECT * FROM employeedet ORDER BY salary ASC",nativeQuery = true)
	public List<EmployeeDet> findAllOrderBySalary();
	
	public EmployeeDet findByEmail(String email);

}
