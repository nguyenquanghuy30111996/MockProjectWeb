package com.vn.MockProjectWeb.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	

	@Transactional
	@Query(value = "FROM Employee e WHERE e.username = :username" ,nativeQuery = false)
	Employee checkUsername(String username);
		
		

	@Transactional
	@Query(value = "FROM Employee e WHERE e.email = :email",nativeQuery = false)
	Employee checkEmail(String email);
		
	
	@Transactional
	@Query(value = "FROM Employee e where e.id = :id", nativeQuery = false)
	Employee findAllById(Integer id);
    
	@Modifying
	@Transactional
	@Query(value = "UPDATE Employee e SET fullName = :fullName ,dateOfBirth = :dateOfBirth,gender = :gender,email = :email,phoneNumber = :phoneNumber,address = :address,registerDate = :registerDate, password = :password,rePassword = :rePassword WHERE id = :id" , nativeQuery = false)
	void updateEmployee(@Param("fullName") String fullName,@Param("dateOfBirth") String dateOfBirth,@Param("gender") String gender,@Param("email")String email,@Param("phoneNumber") String number ,@Param("address")String address,@Param("registerDate")String registerDate, @Param("password")String password , @Param("rePassword") String rePassword, @Param("id") Integer id);
    
	@Query(value = "SELECT e FROM Employee e")
	@Transactional
	Page<Employee> findEmployees(Pageable pageable);
	
	
}
