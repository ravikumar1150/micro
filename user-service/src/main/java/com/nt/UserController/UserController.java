package com.nt.UserController;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.exception.CustomeSuccessMsg;
import com.nt.exception.UserIdNotFoundException;
import com.nt.service.UserService;
import com.nt.user.User;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {

		User orElseThrow = userService.getUserById(id)
				.orElseThrow(() -> new UserIdNotFoundException("No Employee Found"));

		return ResponseEntity.ok(orElseThrow);
	}

	@GetMapping("/")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	@GetMapping("/gets")
	public ResponseEntity<?> getUserByName(@RequestParam("name") String name) {

		List<Object[]> userNameEmail = userService.getUserNameEmail(name);

		return new ResponseEntity<>(userNameEmail, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id) {

		int deleteUSer = userService.deleteUSer(id);

		if (deleteUSer > 0) {
			return ResponseEntity.ok("User Deleted Successfull !!");
		} else {
			throw new UserIdNotFoundException("User Not Delete Pless TryAgain");
		}
	}

	@PutMapping("/updateName/newName/{newName}/oldName/{oldName}/id/{id}")
	public ResponseEntity<?> updateUser(@PathVariable String newName,
			                            @PathVariable String oldName,
			                            @PathVariable Integer id) {

		Integer count = userService.updateUSerName(newName, oldName, id);

		CustomeSuccessMsg success = new CustomeSuccessMsg("User Update Successfull", LocalDateTime.now(), count);

		return new ResponseEntity<>(success, HttpStatus.OK);

	}

}
