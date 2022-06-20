package com.vn.MockProjectWeb.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository repo;

	@Override
	public List<Employee> listAll() {
		return (List<Employee>) repo.findAll();
	}

	@Override
	public Employee saveEmployee(Employee e) {

		return repo.save(e);
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public Employee get(Integer id) throws EmployeeNotFoundException {
		Optional<Employee> employee = repo.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		}
		throw new EmployeeNotFoundException("Not found !");
	}

	@Override
	public Employee checkUsername(String username) {
		return repo.checkUsername(username);

	}

	@Override
	public Employee checkEmail(String email) {
		return repo.checkEmail(email);
	}


	@Override
	public Employee update(Employee employee) {
		repo.updateEmployee(employee.getFullName(),employee.getDateOfBirth(),employee.getGender(),employee.getEmail(),employee.getPhoneNumber(),employee.getAddress(),employee.getRegisterDate(),employee.getPassword(),employee.getRePassword(), employee.getId());
		return employee;
}

	@Override
	public Page<Employee> findAll(Pageable pageable) {
	     return	repo.findEmployees(pageable);
		
	}

	


	}
