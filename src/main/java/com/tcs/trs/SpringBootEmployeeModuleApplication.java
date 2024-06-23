package com.tcs.trs;

import java.util.List;

//import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.tcs.trs.dto.EmployeeDTO;
import com.tcs.trs.exception.InfyBankException;
import com.tcs.trs.service.EmployeeService;

@SpringBootApplication
public class SpringBootEmployeeModuleApplication implements CommandLineRunner {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeModuleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// addEmployee();
		//getEmployee();
		getAllEmployees();

	}

	private void addEmployee() {

		try {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setId(1234);
			employeeDTO.setName("Rajesh");
			employeeDTO.setRole("Manager");
			Integer employeeId;
			employeeId = employeeService.addEmployee(employeeDTO);
			String successMessage = environment.getProperty("EMP.INSERT_SUCCESS") + employeeId;
			System.out.println(successMessage);
		} catch (InfyBankException e) {

			e.printStackTrace();
		}

	}

	private EmployeeDTO getEmployee() {
		Integer employeeId = 1;
		EmployeeDTO employeeDTO = null;
		try {

			employeeDTO = employeeService.getEmployee(employeeId);
			System.out.println(employeeDTO);
		} catch (InfyBankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeDTO;
	}

	private List<EmployeeDTO> getAllEmployees(){
		List<EmployeeDTO> allEmployees = null;
		try {
			allEmployees = employeeService.getAllEmployees();
			System.out.println(allEmployees);
		} catch (InfyBankException e) {
			e.printStackTrace();
		}
		return allEmployees;
	}
	
	private Integer deleteEmployee() {
		Integer employeeId=2;
		try {
			Integer deleteEmployee = employeeService.deleteEmployee(employeeId);
		} catch (InfyBankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	

}
