package com.ecom.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.model.User;
import com.ecom.services.userServices;
@RestController
public class UserController {
	
	@Autowired
	private userServices userService; 
	//List <User> alluser =new ArrayList<User>();
	User user=new User();
	
	@GetMapping("/admin/all/user")
	public List<User> getAllUsers()
	{
		return userService.getAllusers();
		 
	}
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Long id) 
	{
			return userService.getuserById(id);
	}
	
	@PostMapping("/user")
	public String adduser(@RequestBody User newUser) {
		
		userService.adduser(newUser);
		
		return "Saved Succefully";
	}
}
