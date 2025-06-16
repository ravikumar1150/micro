package com.nt.userRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nt.user.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("SELECT e.name, e.eMail FROM User e WHERE e.name = :name")
	public List<Object[]> getUserWithSal(@Param("name") String name);

	@Modifying
	@Transactional
	@Query("delete from User u where u.id= :id")
	public Integer deleteCustomer(@Param("id") Integer id);

	@Modifying
	@Transactional
	@Query("update User u set u.name= :newName where u.name= :oldName and u.id= :id ")
	public Integer updateUserName(@Param("newName") String name,
			                      @Param("oldName") String oldName,
			                      @Param("id")Integer id);
	@Modifying
	@Transactional
	@Query("delete from User u where u.name= :name")
	public Integer deleteUser(@Param("name") String name);

}
