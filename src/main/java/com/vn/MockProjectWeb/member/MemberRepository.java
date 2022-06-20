package com.vn.MockProjectWeb.member;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
	 
	@Transactional
	@Query(value = "SELECT m FROM Member m WHERE m.username = :username",nativeQuery = false)
	Member checkUsername(String username);
    
	
	@Transactional
	@Query(value = "SELECT m FROM Member m WHERE m.email = :email",nativeQuery = false)
	Member checkEmail(String email);
	
	@Transactional
	@Query(value = " SELECT m FROM Member m WHERE m.password = :password",nativeQuery = false)
	Member checkPassword(String password);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Member SET fullName = :fullName ,dateOfBirth = :dateOfBirth,gender = :gender,email = :email,phoneNumber = :phoneNumber,address = :address, password = :password,rePassword = :rePassword WHERE id = :id" , nativeQuery = false)
	void updateMember(@Param("fullName") String fullName,@Param("dateOfBirth") String dateOfBirth,@Param("gender") String gender,@Param("email")String email,@Param("phoneNumber") String phoneNumber ,@Param("address")String address, @Param("password")String password,@Param("rePassword")String rePassword , @Param("id") Integer id);

}
