package com.nt;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.UserController.UserController;
import com.nt.service.UserService;
import com.nt.user.User;

@WebMvcTest(UserController.class)
public class UserTest {

	/*
	 * @Autowired private MockMvc mockMvc;
	 */
	

	/*
	 * @Test void testSaveUser() throws Exception { User user = new User(1, "Ravi",
	 * "ravi@example.com");
	 * 
	 * Mockito.when(userService.saveUser(any(User.class))).thenReturn(user);
	 * 
	 * mockMvc.perform(post("/users/save").contentType(MediaType.APPLICATION_JSON)
	 * .content(objectMapper.writeValueAsString(user))).andExpect(status().isOk())
	 * .andExpect(jsonPath("$.name").value("Ravi")); }
	 */
	@Autowired
	private MockMvc mocMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private UserService userService;
	
	@Test
	void testSaveUsers()throws Exception {
		
		User u = new User(2,"nethra","nethra@gmail.com");
		
		Mockito.when(userService.saveUser(any(User.class))).thenReturn(u);
		mocMvc.perform(post("/users/save").contentType(MediaType.APPLICATION_JSON)
		       .content(objectMapper.writeValueAsString(u))).andExpect(status().isOk())
		        .andExpect(jsonPath("$.name").value("nethra"));
		
		
		
		
	}
	
}
