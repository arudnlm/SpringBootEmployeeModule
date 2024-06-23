package com.tcs.trs.service;

import java.util.List;

import com.tcs.trs.dto.EmployeeDTO;
import com.tcs.trs.exception.InfyBankException;

public interface EmployeeService {
	
public  Integer addEmployee(EmployeeDTO employeeDTO) throws InfyBankException;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
public EmployeeDTO getEmployee(Integer id) throws InfyBankException;
public List<EmployeeDTO> getAllEmployees() throws InfyBankException;
public Integer deleteEmployee(Integer id)throws InfyBankException;	
public Integer updateEmployee(Integer id, String name,String role)throws InfyBankException;

}
