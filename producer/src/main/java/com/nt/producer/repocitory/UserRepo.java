 package com.nt.producer.repocitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.producer.entity.Users;

public interface UserRepo  extends JpaRepository<Users,Integer> {
	
	
	

}
