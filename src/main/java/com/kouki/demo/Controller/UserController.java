package com.kouki.demo.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kouki.demo.Entity.User;
import com.kouki.demo.model.RequestRoles;
import com.kouki.demo.model.RequestUser;
import com.kouki.demo.service.UserService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("")
	public List<User> getUsers(){
		return this.userService.getUsers();
	}
	
	
	@GetMapping("/id/{id}")
	public User getUserById(@PathVariable int id) {
		return this.userService.getUserById(id);
	}
	
	
	@GetMapping("/username/{username}")
	public User getUserByUsername(@PathVariable String username) {
		return this.userService.getUserByUsername(username);
	}
	
	@GetMapping("/roleId/{id}")
	public List<User> getUsersByRoleId(@PathVariable int id){
		return this.userService.getUsersByRoleId(id);
	}
	
	@GetMapping("/role/{role}")
	public List<User> getUsersByRoleId(@PathVariable String role){
		return this.userService.getUsersByRole(role);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody RequestUser user,@PathVariable int id) throws NotFoundException{
		return this.userService.updateUser(user, id);	
	}
	
	
	@PostMapping("/ajout")
	public ResponseEntity<Object> ajoutUser(@RequestBody RequestUser user) throws NotFoundException{
		return this.userService.ajoutUser(user);	
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) throws NotFoundException {
		return this.userService.deleteUserById(id);
	}
	
	@PutMapping("/block/{id}")
	public ResponseEntity<Object> blockerUserById(@PathVariable int id) throws NotFoundException {
		return this.userService.blockerUserById(id);
	}
	
	@PostMapping("/changeImage/{id}")
	public ResponseEntity<Object> uploadImage(@PathVariable int id , @RequestParam("imageUser") MultipartFile file) throws IOException{
		return this.userService.uploadImage(id, file);
	}
	
	@GetMapping("/downloadImage/{id}")
	public ResponseEntity<Object> downloadImage(@PathVariable int id) throws IOException{
		return this.userService.downloadImage(id);
	}

}
