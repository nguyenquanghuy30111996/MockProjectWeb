package com.vn.MockProjectWeb.employee;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface EmployeeService {

	

	public List<Employee> listAll();

	public Employee saveEmployee(Employee e);

	public void delete(Integer id);

	public Employee get(Integer id) throws EmployeeNotFoundException;
	
	public Employee checkUsername(String username);
	
    
	public Employee checkEmail(String email);

	Employee update(Employee employee);
	Page<Employee> findAll(Pageable pageable);
}
	

	
