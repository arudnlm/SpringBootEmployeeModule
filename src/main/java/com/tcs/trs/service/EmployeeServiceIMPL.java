package com.tcs.trs.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.trs.dto.EmployeeDTO;
import com.tcs.trs.entitiy.Employee;
import com.tcs.trs.exception.InfyBankException;
import com.tcs.trs.repository.EmployeeRepository;



@Service(value= "employeeServiceIMPl")
@Transactional
public class EmployeeServiceIMPL implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public Integer addEmployee(EmployeeDTO employeeDTO) throws InfyBankException {
		Employee employeeEntity = new Employee();
		employeeEntity.setId(employeeDTO.getId());
		employeeEntity.setName(employeeDTO.getName());
		employeeEntity.setRole(employeeDTO.getRole());
		Employee employee = employeeRepository.save(employeeEntity);
		return employee.getId();
	}

	@Override
	public EmployeeDTO getEmployee(Integer id) throws InfyBankException {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = optional.orElseThrow(() -> new InfyBankException("Service.EMPLOYEE_NOT_FOUND"));
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(employee.getId());
		employeeDTO.setName(employee.getName());
		employeeDTO.setRole(employee.getRole());
		return employeeDTO;
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() throws InfyBankException {
		Iterable<Employee> employees = employeeRepository.findAll();
		List<EmployeeDTO> employeeDTO = new ArrayList<>();
		employees.forEach(employee -> {
			EmployeeDTO emp = new EmployeeDTO();
			emp.setId(employee.getId());
			emp.setName(employee.getName());
			emp.setRole(employee.getRole());
			employeeDTO.add(emp);
		});
		if (employeeDTO.isEmpty())
			throw new InfyBankException("Service.EMPLOYEES_NOT_FOUND");
		return employeeDTO;
	}

	@Override
	public Integer deleteEmployee(Integer id) throws InfyBankException {
		Optional<Employee> employee = employeeRepository.findById(id);
		employee.orElseThrow(() -> new InfyBankException("Service.EMPLOYEE_NOT_FOUND_APP"));
		employeeRepository.deleteById(id);
		return id;
	}

	@Override
	public Integer updateEmployee(Integer id, String name, String role) throws InfyBankException {
		Optional<Employee> employee = employeeRepository.findById(id);
		Employee e = employee.orElseThrow(() -> new InfyBankException("Service.EMPLOYEE_NOT_FOUND_UPDATE"));
		e.setName(name);
		e.setRole(role);
		return id;
	}

}
