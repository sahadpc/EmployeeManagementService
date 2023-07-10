package com.springemp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springemp.entity.EmployeeDependents;

@Repository
public interface EmployeeDendentsDao extends JpaRepository<EmployeeDependents, Integer> {

	@Query(value = "SELECT * FROM employeedependents WHERE fk_emp_id=?1", nativeQuery = true)
	public List<EmployeeDependents> findByFk_emp_id(int fk_emp_id);
}
