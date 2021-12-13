package com.kouki.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kouki.demo.Entity.CaffeUserRoles;
import com.kouki.demo.Entity.Roles;
import com.kouki.demo.Entity.User;
import com.kouki.demo.Repository.CaffeUserRolesRepository;
import com.kouki.demo.Repository.RoleRepository;
import com.kouki.demo.Repository.UserRepository;
import com.kouki.demo.model.RequestCommande;
import com.kouki.demo.model.RequestRoles;
import com.kouki.demo.model.RequestUser;
import com.kouki.demo.util.FileUploadUtil;

import javassist.NotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	CaffeUserRolesRepository caffeUserRolesRepository;

	public List<User> getUsers(){
		return userRepository.findAll();
	}


	public List<User> getUsersByRole(String role){
		return this.userRepository.getUserByRoles(role);
	}


	public User getUserById(int id ) {
		return userRepository.findById(id).get();
	}

	public List<User> getUsersByRoleId(int id){
		return this.userRepository.findBycaffeUserRolesRoleId(id);
	}


	public User getUserByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

	public ResponseEntity<Object> ajoutUser(RequestUser requestUser) throws NotFoundException {
		try {
			User user=new User();
			user.setUsername(requestUser.getUsername());
			user.setPassword(requestUser.getPassword());
			user.setVille(requestUser.getVille());
			user.setPays(requestUser.getPays());
			user.setCodePostale(requestUser.getCodePostale());
			user.setAddIp(requestUser.getAddIp());
			user.setPhotoUser(requestUser.getPhotoUser());
			user.setStatus("A");
			user=this.userRepository.save(user);

			try {
				Roles role =this.roleRepository.findByName("ROLE_USER");
				CaffeUserRoles cur=new CaffeUserRoles();
				cur.setRole(role);
				cur.setUser(user);
				user.addCaffeUserRoles(cur);
				user=this.userRepository.save(user);
				return new ResponseEntity<Object>(user,HttpStatus.OK);
			} catch (Exception e) {
				this.userRepository.deleteById(user.getId());
				throw new NotFoundException("add new user failed");
			}
		} catch (Exception e) {
			throw new NotFoundException("add new user failed");
		}
	}

	public ResponseEntity<Object> updateUser(RequestUser requestUser,int idUser) throws NotFoundException {
		try {
			User user=this.userRepository.findById(idUser).get();
			user.setUsername(requestUser.getUsername());
			user.setPassword(requestUser.getPassword());
			user.setVille(requestUser.getVille());
			user.setPays(requestUser.getPays());
			user.setCodePostale(requestUser.getCodePostale());
			user.setAddIp(requestUser.getAddIp());
			user.setPhotoUser(requestUser.getPhotoUser());
			user.setAddIp(requestUser.getStatus());
			User newUser=this.userRepository.save(user);

			return new ResponseEntity<Object>(user,HttpStatus.OK);
		} catch (Exception e) {
			throw new NotFoundException("failed to update user");
		}
	}



	public ResponseEntity<Object> deleteUserById(int id) throws NotFoundException{
		try {
			this.caffeUserRolesRepository.deleteByUserId(id);
			this.userRepository.deleteById(id);
			return new ResponseEntity<Object>("delete user "+id+" succufful",HttpStatus.OK);
		} catch (Exception e) {
			throw new NotFoundException("delete user "+id+" failed");
		}

	}

	public ResponseEntity<Object> blockerUserById(int id) throws NotFoundException{
		this.userRepository.blockerUser(id);
		return new ResponseEntity<Object>("block user "+id+" succufful",HttpStatus.OK);	
	}


	public ResponseEntity<Object> uploadImage(int idUser,MultipartFile file) throws IOException {

		User user=this.userRepository.getById(idUser);
		Path path = FileUploadUtil.saveFile("uploads/" + user.getId(), "" + ((new Date()).getTime()) + ".png", file);
		user.setPhotoUser(path.toString());

		this.userRepository.save(user);
		return new ResponseEntity<>("upload image succuffull",HttpStatus.OK);
	}

	public ResponseEntity<Object> downloadImage(int id) throws IOException
	{
		User user=this.userRepository.getById(id);
		String filename =user.getPhotoUser();
		Path uploadPath = Paths.get(filename);
		File file = new File(uploadPath.toString());
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition",
				String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/txt")).body(resource);

		return responseEntity;
	}


}
