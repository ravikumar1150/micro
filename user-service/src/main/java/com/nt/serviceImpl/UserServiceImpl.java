package com.nt.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.exception.UserIdNotFoundException;
import com.nt.kafka.KafkaProducer;
import com.nt.service.UserService;
import com.nt.user.User;
import com.nt.userRepo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private KafkaProducer kafkaProducer;

	@Autowired
	private UserRepo userRepo;

	@Override
	public User saveUser(User user) {

		if (user != null) {
			kafkaProducer.sendTopic("User Entity saved Successfull !!!");
		}
		return userRepo.save(user);

	}

	@Override
	public Optional<User> getUserById(Integer id) {

		return userRepo.findById(id);
	}

	@Override
	public List<User> getAllUser() {
		
		return Optional.of(userRepo.findAll())
				        .filter(list ->  ! list.isEmpty())
				        .orElseThrow(()->new UserIdNotFoundException("No Employee Found "));
		 
		 
	}

	@Override
	public List<Object[]> getUserNameEmail(String name) {
		
		return Optional.of( userRepo.getUserWithSal(name))
		         .filter(f -> !f.isEmpty())
		         .orElseThrow(()->new UserIdNotFoundException("There IS No Name And Email"));
		
		
	}
	@Override
	public Integer deleteUSer(Integer id) {
		return userRepo.deleteCustomer(id);

	}

	@Override
	public Integer updateUSerName(String newName, String oldName,Integer id) {
		Integer updateUserName = userRepo.updateUserName(newName, oldName,id);
		if(updateUserName==0) {
			throw new UserIdNotFoundException("There IS No  Old Name : "+oldName);
		}
		return updateUserName;
	}

}
