package com.tcs.trs.repository;

import org.springframework.data.repository.CrudRepository;

import com.tcs.trs.entitiy.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
