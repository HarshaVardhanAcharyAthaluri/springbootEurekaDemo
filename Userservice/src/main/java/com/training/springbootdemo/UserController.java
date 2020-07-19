package com.training.springbootdemo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {

	@Autowired
	private UserRepository userrepo;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
	
		return (List<User>) userrepo.findAll();
	}
	
	@GetMapping("/userid/{id}")
	public Optional<User> getAllUsers(@PathVariable int id) {
	
		return  userrepo.findById(id);
	}
	
	@GetMapping("/users/{name}")
	public User getuserbyName(@PathVariable String name) {
	
		return  userrepo.findUserByName(name);
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User us) {
		User saveduser = null;
		try {
			saveduser = userrepo.save(us);
		}catch (Exception e) {
			return new ResponseEntity<User>(saveduser,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<User>(saveduser, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable int id) {
		
		userrepo.deleteById(id);
		return "User Dleted with "+id;
		
	}
	
	@PutMapping("update/{id}")
	public User updateUser(@PathVariable int id,@RequestBody User u) {
		
		Optional<User> updateuser = userrepo.findById(id);
		User  uuser = updateuser.get();
		
		uuser.setName(u.getName());
		uuser.setAddress(u.getAddress());
		uuser.setOccupation(u.getOccupation());
		uuser.setContact(u.getContact());
		
		return uuser;
		
	}
}

























